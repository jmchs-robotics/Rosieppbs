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

import org.usfirst.frc5933.Rosieppbs.FieldElements;
import org.usfirst.frc5933.Rosieppbs.LidarLitePWM;
import org.usfirst.frc5933.Rosieppbs.Robot;
import org.usfirst.frc5933.Rosieppbs.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BallLauncher extends Subsystem {
    private int flyWheelManualAdjustmentCount;
    public static final double kFlyWheelAdjustmentIncrement = 0.05; // A small value that was picked from a magical hat
    
    // Values that were determined by testing over and again.
    public static final double kSlowFlyWheelSpeed = -0.37;
    public static final double kMediumFlyWheelSpeed = -0.50;
    public static final double kFastFlyWheelSpeed = -0.63;
    
    public enum FlyWheelSpeed {
        SLOW,
        MEDIUM,
        FAST
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController flyWheel = RobotMap.ballLauncherFlyWheel;
    private final LidarLitePWM spock = RobotMap.ballLauncherSpock;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetFlyWheelManualAdjustment() {
        flyWheelManualAdjustmentCount = 0;
    }
    
    private double getFlyWheelManualAdjustment() {
        return flyWheelManualAdjustmentCount * kFlyWheelAdjustmentIncrement;
    }

    public void increaseFlyWheelManualAdjustment() {
        ++flyWheelManualAdjustmentCount;
    }
    
    public void decreaseFlyWheelManualAdjustment() {
        --flyWheelManualAdjustmentCount;
    }
    
    private double getLidarValue(double fudgeFactor) {
        // the slope intercept formulas
        // m = y2 - y1 / x2 - x1
        // b = y - mx
        // y = mx + b
         double slope = (kFastFlyWheelSpeed - kSlowFlyWheelSpeed) / (FieldElements.kFarCanCenterDistance - FieldElements.kNearCanCenterDistance);
         double b = kSlowFlyWheelSpeed - (slope * FieldElements.kNearCanCenterDistance);
         double y = (slope * (spock.getDistance() + FieldElements.kLidarOffsetFromCenter + FieldElements.kGarbageCanRadius + fudgeFactor)) + b;
         return y;
    }
    
    public void set(FlyWheelSpeed speed) {
       double startingValue = 0;
       double fudge = -3;
       switch (speed) {
            case SLOW:
                fudge = 1;
                startingValue = kSlowFlyWheelSpeed;
            break;
            case MEDIUM:
                fudge = -3;
                startingValue = kMediumFlyWheelSpeed;
            break;
            case FAST:
                fudge = -3;
                startingValue = kFastFlyWheelSpeed;
            break;
       }

       if (Robot.useLidar()) {
           startingValue = getLidarValue(fudge);
       }
       
       // System.out.println("DEBUG: " + getFlyWheelManualAdjustment());

       double adjustedBatteryValue = startingValue * Electrical.kFullyChargedBatteryVoltage / RobotMap.electricalPowerDistributionPanel.getVoltage();
        flyWheel.set(adjustedBatteryValue + getFlyWheelManualAdjustment());
    }
}
