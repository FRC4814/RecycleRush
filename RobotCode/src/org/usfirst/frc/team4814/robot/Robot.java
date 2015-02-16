package org.usfirst.frc.team4814.robot;

import org.usfirst.frc.team4814.robot.autocommands.AutoTest;
import org.usfirst.frc.team4814.robot.autocommands.DriveFor;
//import org.usfirst.frc.team4814.robot.commands.DigitalInput; //TODO FIX THIS
import org.usfirst.frc.team4814.robot.commands.ElevatorDown;
import org.usfirst.frc.team4814.robot.commands.ElevatorUp;
import org.usfirst.frc.team4814.robot.commands.InputReader;
import org.usfirst.frc.team4814.robot.commands.Interpreter;
import org.usfirst.frc.team4814.robot.subsystems.Arm;
import org.usfirst.frc.team4814.robot.subsystems.AutonomousCode;
import org.usfirst.frc.team4814.robot.subsystems.Chassis;
import org.usfirst.frc.team4814.robot.subsystems.DoNothing;
import org.usfirst.frc.team4814.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//public static DigitalInput DigitalInput;
	public static Chassis chassis; 		// Creates the Chassis for the robot, allowing driving
	public static Elevator elevator; 	// Creates the Elevator for the robot, allowing lifting
	public static DriveFor DriveFor; 	// TODO Remove for final version of code
	public static Arm arm; 				// Creates the Arm for the robot, allowing it's raising and lowering
	public static OI oi; 				// Creates the Inputs from the driver to the robot

	Command autonomousCommand;		// Calls the autonomous commands for the robot
	SendableChooser autoChooser;	// Choose which autonomous mode we play using

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		autoChooser = new SendableChooser();	// Initializing autoChooser
		autoChooser.addDefault("doNothing", new DoNothing());	// Adds default action to autoChooser of DoNothing
		autoChooser.addObject("autonomousCode", new AutonomousCode());	// Adds a second option to the robot 
		chassis = new Chassis();	// Initializes the Chassis and calls its constructor
		// arm = new Arm();			// Initializes the Robot's arm and calls its constructor TODO uncomment arm initialization
		elevator = new Elevator();	// Initializes the Robot's Elevator and calls its constructor 
		oi = new OI();				// Initializes the Robot's OI and calls its constructor
		autoChooser = new SendableChooser();
		//autoChooser.addDefault("doNothing", new doNothing());
		//autoChooser.addDefault("autonomousCode", new autonomousCode());
		
		// instantiate the command used for the autonomous period
		// If you see this part of the code and know a Kyle Inzunza, tell him to
		// get Motorvated --Steven
		oi.rightButton3.whileHeld(new ElevatorUp());	// Moves the elevator up while the right joystick's button 3 is held
		oi.rightButton2.whileHeld(new ElevatorDown());	// Moves the elevator down while the right joystick's button 2 is held
		oi.recordButton.whileHeld(new Interpreter());
		oi.playbackButton.whenPressed(new InputReader());
		// oi.rightButton4.whenPressed(new Interpreter());	// Starts recording user input when button 4 is pressed TODO Uncomment Interpreter initialization
		// oi.rightButton5.whenPressed(new InputReader());	// Starts reading the recorded user input when button 5 is pressed TODO Uncomment output reader initialization
	}
	/**
	 * Called after * returns false
	 */
	public void disabledPeriodic() {
		// Stops the periodic checker from being called
		Scheduler.getInstance().run();
	}
	/**
	 * Called during the start of the autonomous period to start the autonomousCommand function
	 */
	public void autonomousInit() {
		// schedule the autonomous command (example)
		// autonomousComand = (Command) autonomous;
		autonomousCommand = new AutoTest();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

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
		if (autonomousCommand != null){			
			autonomousCommand.cancel();
			autonomousCommand = null;
			}
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
