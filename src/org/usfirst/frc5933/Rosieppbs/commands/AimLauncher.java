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

import org.usfirst.frc5933.Rosieppbs.Helmsman;
import org.usfirst.frc5933.Rosieppbs.Robot;

/**
 *
 */
public class AimLauncher extends Command {
    private static Helmsman helmsman_ = new Helmsman("10.59.33.21", 59330);
    private boolean DEBUG = true;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AimLauncher() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        if (!helmsman_.is_connected()) {
        	if (!helmsman_.connect()) {
        		System.err.println("Failed to connect to the Helmsman and I really need my mayonnaise");
        	} else {
        		System.out.println("Connected. No mayo for me.");
        	}
        }
    }

    public void take_directions_from_helmsman() {
        if (!helmsman_.is_connected())
            return;

        if (DEBUG) {
            if (helmsman_.recv()) {
                System.out.println("Recieved packet");
            } else {
                System.out.println("No go");
            }
        }
        
        final String direction = helmsman_.get_direction();

        switch (direction) {
        case Helmsman.NADA:
            if (DEBUG)
                System.out.println("Skipping along...");
            Robot.driveTrain.turn_left(0);
            return;
        case Helmsman.LEFT:
            if (DEBUG)
                System.out.println("LEFTING");
            Robot.driveTrain.turn_left(0.3);
            return;
        case Helmsman.RIGHT:
            if (DEBUG)
                System.out.println("RIGHTING");
            Robot.driveTrain.turn_right(0.3);
            return;
        }
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        take_directions_from_helmsman();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}