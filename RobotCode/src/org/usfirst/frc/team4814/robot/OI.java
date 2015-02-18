package org.usfirst.frc.team4814.robot;

import org.usfirst.frc.team4814.robot.subsystems.Attack3Joystick;

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
	
	// Driver controls
    public Attack3Joystick driverLeftStick = new Attack3Joystick(0);    
    public Attack3Joystick driverRightStick = new Attack3Joystick(1);
    public JoystickButton rightButton2 = new JoystickButton(driverRightStick, 2);
    public JoystickButton rightButton3 = new JoystickButton(driverRightStick, 3);
    public JoystickButton recordButton = new JoystickButton(driverRightStick, 4);
    public JoystickButton playbackButton = new JoystickButton(driverRightStick, 5);
    
    // Operator controls
    public static final int[] ELEVATOR_BUTTONS = {6,7,10,11};
    public static final int[] ELEVATOR_LEVEL = {0,1,2,3,4};
    public Attack3Joystick operatorRightStick = new Attack3Joystick(2);
    public JoystickButton[] elevatorLevel = new JoystickButton[5];
    
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
    public OI() {
    	for (int i = 0; i < elevatorLevel.length-1; i++) {//creates 4 new joystick buttons for operator elevator
			elevatorLevel[i] = new JoystickButton(operatorRightStick, ELEVATOR_BUTTONS[i]);
		}
    }
}

