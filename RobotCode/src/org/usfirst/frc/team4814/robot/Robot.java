package org.usfirst.frc.team4814.robot;
import org.usfirst.frc.team4814.robot.autocommands.AutoTest;
import org.usfirst.frc.team4814.robot.autocommands.DriveFor;
import org.usfirst.frc.team4814.robot.autocommands.InputReader;
import org.usfirst.frc.team4814.robot.autocommands.Interpreter;
import org.usfirst.frc.team4814.robot.commands.ElevatorDown;
import org.usfirst.frc.team4814.robot.commands.ElevatorUp;
import org.usfirst.frc.team4814.robot.commands.ElevatorMoveTo;
import org.usfirst.frc.team4814.robot.subsystems.Arm;
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
	
	public static Chassis chassis; 		// drive code
	public static Elevator elevator;
	public static DriveFor DriveFor; 	// TODO this will be changed to InputReader
	public static Arm arm; 				
	public static OI oi; 				

	Command autonomousCommand;		
	SendableChooser autoChooser;	// Choose which autonomous mode we play using

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		autoChooser = new SendableChooser();	// Initializing autoChooser
		autoChooser.addDefault("doNothing", new DoNothing());	// Adds default action to autoChooser of DoNothing
		//autoChooser.addObject("autonomousCode", new AutonomousCode());	// Adds a second option to the robot 
		
		//initializes and calls constructor
		// arm = new Arm();			//TODO uncomment arm initialization
		chassis = new Chassis();			
		elevator = new Elevator();	 
		oi = new OI();				
		autoChooser = new SendableChooser();
		// instantiate the command used for the autonomous period
		//autoChooser.addDefault("doNothing", new doNothing());
		//autoChooser.addDefault("autonomousCode", new autonomousCode());
		
		// If you see this part of the code and know a Kyle Inzunza, tell him to
		// get Motorvated --Steven
		
		//elevator moves while buttons held
		oi.rightButton3.whileHeld(new ElevatorUp());
		oi.rightButton2.whileHeld(new ElevatorDown());
		
		oi.recordButton.whenPressed(new Interpreter()); // Starts recording joystick output when button 4 is pressed 
		oi.playbackButton.whenPressed(new InputReader());// plays back recorded outputs
			
			
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
		autonomousCommand = new AutoTest();//where autonomous is called//TODO Change this to InputReader
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
