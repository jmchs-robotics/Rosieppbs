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
	private final CANTalon cANTalon1 = RobotMap.driveTrainCANTalon1;
	private final CANTalon cANTalon2 = RobotMap.driveTrainCANTalon2;
	private final CANTalon cANTalon3 = RobotMap.driveTrainCANTalon3;
	private final CANTalon cANTalon4 = RobotMap.driveTrainCANTalon4;
	private final RobotDrive robotDrive4 = RobotMap.driveTrainRobotDrive4;

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
	        double y = stick.getY();
	        double x = stick.getX();

	        robotDrive4.arcadeDrive(y, x);
	    }

	public void stop() {
		robotDrive4.stopMotor();
	}
}

