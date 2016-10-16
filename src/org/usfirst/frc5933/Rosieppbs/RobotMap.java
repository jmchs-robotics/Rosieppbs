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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainCANTalon1;
    public static CANTalon driveTrainCANTalon2;
    public static CANTalon driveTrainCANTalon3;
    public static CANTalon driveTrainCANTalon4;
    public static RobotDrive driveTrainRobotDrive4;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainCANTalon1 = new CANTalon(0);
        LiveWindow.addActuator("DriveTrain", "CAN Talon 1", driveTrainCANTalon1);
        
        driveTrainCANTalon2 = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "CAN Talon 2", driveTrainCANTalon2);
        
        driveTrainCANTalon3 = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "CAN Talon 3", driveTrainCANTalon3);
        
        driveTrainCANTalon4 = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "CAN Talon 4", driveTrainCANTalon4);
        
        driveTrainRobotDrive4 = new RobotDrive(driveTrainCANTalon1, driveTrainCANTalon2,
              driveTrainCANTalon3, driveTrainCANTalon4);
        
        driveTrainRobotDrive4.setSafetyEnabled(true);
        driveTrainRobotDrive4.setExpiration(0.1);
        driveTrainRobotDrive4.setSensitivity(0.5);
        driveTrainRobotDrive4.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
