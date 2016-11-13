// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Rosieppbs;

import org.usfirst.frc5933.Rosieppbs.commands.*;
import org.usfirst.frc5933.Rosieppbs.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command arcadeDrive;
	Command autonomousCommand;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static PingPongBallCannon pingPongBallCannon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private Helmsman helmsman_;
	
	//public static PowerDistributionPanel pdp = RobotMap.pingPongBallCannonPowerDistributionPanel1;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        pingPongBallCannon = new PingPongBallCannon();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		//(which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new DefaultAutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


		arcadeDrive = new DefaultTeleopCommand();
		helmsman_ = new Helmsman("10.59.33.21", 59330);  

		if (!helmsman_.connect()) {  
			System.err.println("Failed to connect to the Helmsman and I really need my mayonnaise");  
		}  else{
			System.out.println("Connected. No mayo for me.");
		}
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	}
	// TODO: Put in the correct ip and port  



	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	public void take_directions_from_helmsman() {  
		if (!helmsman_.is_connected()) 
			return;  

		if (helmsman_.recv()){
			System.out.println("Recieved packet");
		}else{
			//System.out.println("No go");
		}
		String direction = helmsman_.get_direction();  
		double degrees = helmsman_.get_degrees();
		switch (direction)   
		{  
		case Helmsman.NADA:  
			System.out.println("Skipping along...");
			return;  
		case Helmsman.LEFT:  
			//degrees = helmsman_.get_degrees();
			System.out.println("LEFTING"); 
			driveTrain.turn_left(0.3); 
			return;
		case Helmsman.RIGHT:  
			//degrees = helmsman_.get_degrees();
			System.out.println("RIGHTING");
			driveTrain.turn_right(0.3);  
			return;
		}  
	}  


	/**
	 * This function is called periodically during operator control
	 */
	boolean notPressed = true;
	long startTime = 0;
	long spinUpTime = 1000;
	long pistonRunTime = 1485; //start at 1485
	double wheelSpeed = -.5;
	boolean tested = false;
	boolean tapped = false;
	double moveDistance = 0.2;

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//This returns the same number as the driver station battery voltage number.
		double current = RobotMap.pingPongBallCannonPowerDistributionPanel1.getVoltage();
		//System.out.println("Current reads as " + current + " volts.");

		if(oi.getXBoxJoystick().getRawButton(1)){
			if (!tested){
				startTime = System.currentTimeMillis();
				tested = true;
			}
			pingPongBallCannon.pistonStart();
		}if(!oi.getXBoxJoystick().getRawButton(1)){
			pingPongBallCannon.pistonStop();
			if (tested){
				pistonRunTime = System.currentTimeMillis() - startTime;
				tested = false;
				System.out.println("Piston Run Time: " + pistonRunTime);
			}
		}

		if(oi.getXBoxJoystick().getRawButton(4)){
			wheelSpeed = -.58;

			//theoretical equation: distance = (-3.29684135*wheelSpeed) - 4.12167;
			//therefore wheelSpeed = (distance/-3.29684135) + 1.25
		}

		if(oi.getXBoxJoystick().getRawButton(3)){
			wheelSpeed = -.35;
		}

		if(oi.getXBoxJoystick().getRawButton(2)){
			wheelSpeed = -.42;//mid speed
		}

		if (oi.getXBoxJoystick().getRawButton(5)&&notPressed) {
			startTime = System.currentTimeMillis();
			pingPongBallCannon.wheelSpeed(wheelSpeed * 12.60 / current);
			notPressed = false;
		}if ((startTime <= (System.currentTimeMillis() - spinUpTime))&&!notPressed){
			pingPongBallCannon.pistonStart();
			pingPongBallCannon.wheelSpeed(wheelSpeed * 12.60 / current);
		}if ((startTime <= (System.currentTimeMillis() - (spinUpTime + pistonRunTime)))&&!notPressed) {//try this at 1485 first, change after testing.
			pingPongBallCannon.pistonStop();
			pingPongBallCannon.wheelSpeed(wheelSpeed * 12.60 / current);
		}if ((startTime <= (System.currentTimeMillis() - (spinUpTime + pistonRunTime + 500)))&&!notPressed&&!oi.getXBoxJoystick().getRawButton(5)){
			notPressed = true;
			pingPongBallCannon.wheelSpeed(0);
			spinUpTime = 1000;
		}else if ((startTime <= (System.currentTimeMillis() - (spinUpTime + pistonRunTime)))&&!notPressed&&oi.getXBoxJoystick().getRawButton(5)){
			notPressed = true;
			spinUpTime = 0;
		}

		
		
		if ((oi.getXBoxJoystick().getPOV() == 270)&&!tapped){
			driveTrain.turn_left(moveDistance);
			tapped = true;
		}
		if ((oi.getXBoxJoystick().getPOV() == 90)&&!tapped){
			driveTrain.turn_right(moveDistance);
			tapped = true;
		}
		if((oi.getXBoxJoystick().getPOV() == 0)&&!tapped){
			if(moveDistance < 1.0){
			moveDistance += 0.1;
			}else{
				System.out.println("Maximum value achieved.");
			}
			System.out.println("The robot will now adjust at " + moveDistance + " input value.");
			tapped = true;
		}
		if((oi.getXBoxJoystick().getPOV() == 180)&&!tapped){
			if(moveDistance > 0.3){
			moveDistance -= 0.1;
			}else{
				System.out.println("Minimum value achieved.");
			}
			System.out.println("The robot will now adjust at " + moveDistance + " input value.");
			tapped = true;
		}
		if((oi.getXBoxJoystick().getPOV() == -1)&&tapped){
			tapped = false;
		}
		
		if (arcadeDrive != null){
			arcadeDrive.start();
		}
		if(oi.getXBoxJoystick().getRawButton(9))
			take_directions_from_helmsman(); //use the above method to tell the robot/user left or right
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
