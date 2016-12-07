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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton xButton;
    public JoystickButton yButton;
    public JoystickButton aButton;
    public JoystickButton bButton;
    public JoystickButton rightBumper;
    public JoystickButton leftBumper;
    public JoystickButton rightToggle;
    public JoystickButton leftToggle;
    public JoystickButton backButton;
    public JoystickButton startButton;
    public Joystick xBoxJoystick;
    public JoystickButton xButton2;
    public JoystickButton yButton2;
    public JoystickButton aButton2;
    public JoystickButton bButton2;
    public JoystickButton rightBumper2;
    public JoystickButton leftBumper2;
    public JoystickButton rightToggle2;
    public JoystickButton leftToggle2;
    public JoystickButton backButton2;
    public JoystickButton startButton2;
    public Joystick xBoxJoystick2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xBoxJoystick2 = new Joystick(1);
        
        startButton2 = new JoystickButton(xBoxJoystick2, 8);
        startButton2.whenPressed(new FlopLidar());
        backButton2 = new JoystickButton(xBoxJoystick2, 7);
        backButton2.whenPressed(new ToggleSpeed());
        leftToggle2 = new JoystickButton(xBoxJoystick2, 9);
        leftToggle2.whenPressed(new IncrementFlyWheelSpeed());
        rightToggle2 = new JoystickButton(xBoxJoystick2, 10);
        rightToggle2.whenPressed(new DecrementFlyWheelSpeed());
        leftBumper2 = new JoystickButton(xBoxJoystick2, 5);
        leftBumper2.whenPressed(new ReleaseBall());
        rightBumper2 = new JoystickButton(xBoxJoystick2, 6);
        rightBumper2.whenPressed(new AimLauncher());
        bButton2 = new JoystickButton(xBoxJoystick2, 2);
        bButton2.whenPressed(new StartFastFlyWheel());
        aButton2 = new JoystickButton(xBoxJoystick2, 1);
        aButton2.whenPressed(new StopFlyWheel());
        yButton2 = new JoystickButton(xBoxJoystick2, 4);
        yButton2.whenPressed(new StartSlowFlyWheel());
        xButton2 = new JoystickButton(xBoxJoystick2, 3);
        xButton2.whenPressed(new StartMediumFlyWheel());
        xBoxJoystick = new Joystick(0);
        
        startButton = new JoystickButton(xBoxJoystick, 8);
        startButton.whenPressed(new FlopLidar());
        backButton = new JoystickButton(xBoxJoystick, 7);
        backButton.whenPressed(new ToggleSpeed());
        leftToggle = new JoystickButton(xBoxJoystick, 9);
        leftToggle.whenPressed(new IncrementFlyWheelSpeed());
        rightToggle = new JoystickButton(xBoxJoystick, 10);
        rightToggle.whenPressed(new DecrementFlyWheelSpeed());
        leftBumper = new JoystickButton(xBoxJoystick, 5);
        leftBumper.whenPressed(new ReleaseBall());
        rightBumper = new JoystickButton(xBoxJoystick, 6);
        rightBumper.whenPressed(new AimLauncher());
        bButton = new JoystickButton(xBoxJoystick, 2);
        bButton.whenPressed(new StartFastFlyWheel());
        aButton = new JoystickButton(xBoxJoystick, 1);
        aButton.whenPressed(new StopFlyWheel());
        yButton = new JoystickButton(xBoxJoystick, 4);
        yButton.whenPressed(new StartSlowFlyWheel());
        xButton = new JoystickButton(xBoxJoystick, 3);
        xButton.whenPressed(new StartMediumFlyWheel());


        // SmartDashboard Buttons
        SmartDashboard.putData("StopFlyWheel", new StopFlyWheel());
        SmartDashboard.putData("DefaultAutonomousCommand", new DefaultAutonomousCommand());
        SmartDashboard.putData("NullCommand", new NullCommand());
        SmartDashboard.putData("ReleaseBall", new ReleaseBall());
        SmartDashboard.putData("StartSlowFlyWheel", new StartSlowFlyWheel());
        SmartDashboard.putData("StartMediumFlyWheel", new StartMediumFlyWheel());
        SmartDashboard.putData("StartFastFlyWheel", new StartFastFlyWheel());
        SmartDashboard.putData("AimLauncher", new AimLauncher());
        SmartDashboard.putData("ToggleSpeed", new ToggleSpeed());
        SmartDashboard.putData("IncrementFlyWheelSpeed", new IncrementFlyWheelSpeed());
        SmartDashboard.putData("DecrementFlyWheelSpeed", new DecrementFlyWheelSpeed());
        SmartDashboard.putData("FlopLidar", new FlopLidar());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXBoxJoystick() {
        return xBoxJoystick;
    }

    public Joystick getXBoxJoystick2() {
        return xBoxJoystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

