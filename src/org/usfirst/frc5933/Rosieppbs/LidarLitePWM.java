package org.usfirst.frc5933.Rosieppbs; // TODO: Change this package for your robot.

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class LidarLitePWM implements Runnable {

	public static final int kPeriodScalar = 10000;
	DigitalInput input_;
	DigitalOutput output_;    
	Counter counter_;
	boolean running_;
	boolean debug_;
	double pulseWidth_;
	int delay_;

	// Make sure that you have 1 more set of value in your table
	// that is bigger than the maximum value you want to measure.

	// FIXME: Why is the garbage can diameter 22 inches, for short, 21.5 for the medium, and 14.5 for the long ???
	// I didn't know that garbage can got smaller the further away it got..... :)
	// We can also replace the y values with the constants from the FieldElements class
	static double [][] kPulseWidthTable = new double[][] {
		// raw, inches
		{0, 0},   // base
		{25.7, 96.5}, // near can short val (calculated value is 96.5, yeah!!!! we match)
		{30.6, 118.5}, // near can far val 
		{40, 154.5}, // mid can short val  (calculated value is 156.5 FIXME)
		{45.6, 176}, // mid can far val
		{57.5, 223}, // far can short val (calculated value is 216.5 FIXME)
		{59, 237.5}, // far can far val
		{63.5, 246.5} // ceiling
	};

	LidarLitePWM() {
	}

	public LidarLitePWM(int digitalInput, int digitalOutput, int samples, int delay, boolean debug) {
		input_ = new DigitalInput(digitalInput);
		counter_ = new Counter(input_); 
		counter_.setSemiPeriodMode(true);
		counter_.setSamplesToAverage(samples);
		output_ = new DigitalOutput(digitalOutput);
		debug_ = debug;
		delay_ = delay;
		running_ = true;
		reset();
	}

	private void reset() {
		counter_.reset();
		output_.set(true);
	}

	private void trigger() {
		reset();
		output_.set(false);
		if (Robot.debugModeEnabled)
			System.out.println("LidarLightPWM::trigger");
	}

	private void measure() {
		pulseWidth_ = counter_.getPeriod() * kPeriodScalar;
		if (Robot.debugModeEnabled)
			System.out.println("LidarLightPWM::measure " + pulseWidth_);

		output_.set(true);
	}

	private synchronized boolean isRunning() {
		return running_;
	}

	public synchronized void setRunning(boolean running) {
		running_ = running;
	}

	private static double pulseWidthToInches(double pw) {
		int index = 0;
		while (kPulseWidthTable.length - 1 > index) {
			if (kPulseWidthTable[index][0] == pw ) {
				return kPulseWidthTable[index][1];
			} else if ((pw >  kPulseWidthTable[index][0]) && (kPulseWidthTable[index + 1][0] > pw)) {
				break;
			}
			++index;
		}

		if (index+1 >= kPulseWidthTable.length) {
			if(Robot.debugModeEnabled)
				System.err.println("Ran off the end of the PulseWidthTable");
			return 0;
		}
		// the slope intercept formulas
		// m = y2 - y1 / x2 - x1
		// b = y - mx
		// y = mx + b
		double m = (kPulseWidthTable[index+1][1] - kPulseWidthTable[index][1]) / (kPulseWidthTable[index+1][0] - kPulseWidthTable[index][0])  ;
		double b =  kPulseWidthTable[index][1] - (m * kPulseWidthTable[index][0]);
		double y = (m * pw) + b;
		return y;
	}

	public synchronized double getDistance() {
		return LidarLitePWM.pulseWidthToInches(pulseWidth_);
	}

	private void snooze() {
		try {
			Thread.sleep(delay_);
		} catch (InterruptedException e) {
		}
	}

	public double pidGet() {
		// TODO: Is this correct or Should it be a value of -1 to 1 ?
		return getDistance();
	}

	public void run() {
		while (isRunning())
		{
			trigger();
			snooze();
			measure();
		}
	}
}
