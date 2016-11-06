// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Rosieppbs.subsystems;

import org.usfirst.frc5933.Rosieppbs.RobotMap;
import org.usfirst.frc5933.Rosieppbs.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final CANTalon frontLeft = RobotMap.driveTrainFrontLeft;
	private final CANTalon rightLeft = RobotMap.driveTrainRightLeft;
	private final CANTalon frontRight = RobotMap.driveTrainFrontRight;
	private final CANTalon rearRight = RobotMap.driveTrainRearRight;
	private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void arcadeDrive(Joystick stick) {
		robotDrive.arcadeDrive(stick);
	}

	public void stop() {
		robotDrive.stopMotor();
	}

	public void turn_left(double degrees) {  
		// TODO: Figure out how to convert degrees into a rotation value  
		frontLeft.set(degrees);
		rightLeft.setPosition(degrees);
	}  

	public void turn_right(double degrees) {  
		// TODO: Figure out how to convert degrees into a rotation value  
		frontRight.set(degrees);
		rearRight.set(degrees);
	}  

}

