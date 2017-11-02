// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5933.Rosieppbs.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.Rosieppbs.Robot;
import org.usfirst.frc5933.Rosieppbs.RobotMap;

/**
 * this class expects the robot to be aligned and it will deliver the gear by 1.
 * drive straight forward until it reaches the peg(stop mechanism undecided) 2.
 * stop when stop condition is met
 */
public class DeliverCenterGear extends Command {

	private boolean stopped = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DeliverCenterGear() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.driveTrain);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// This method makes the robot drive straight towards the peg.
	protected void driveStraight() {
		RobotMap.driveTrainRobotDrive.tankDrive(1, 1); // drive straight, possibly turn
														// then go straight again then turn again
														// ^^ could be in another class/command
	}

	// This is the method that checks to see the stopCondition has occurred.
	protected boolean stopCondition() {
		return stopped; // TODO: We need to figure out how we stop!
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		while (stopCondition() == false) {
			driveStraight();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return stopped;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
