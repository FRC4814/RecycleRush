package org.usfirst.frc.team4814.robot;

import org.usfirst.frc.team4814.robot.autocommands.AutoTest;
import org.usfirst.frc.team4814.robot.autocommands.DriveFor;
import org.usfirst.frc.team4814.robot.commands.ElevatorDown;
import org.usfirst.frc.team4814.robot.commands.ElevatorUp;
import org.usfirst.frc.team4814.robot.subsystems.Arm;
import org.usfirst.frc.team4814.robot.subsystems.Chassis;
import org.usfirst.frc.team4814.robot.subsystems.Elevator;
import org.usfirst.frc.team4814.robot.subsystems.AutonomousCode;
import org.usfirst.frc.team4814.robot.subsystems.DoNothing;

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

	public static Chassis chassis ;
	public static Elevator elevator; 
	public static DriveFor DriveFor;
	public static Arm arm; 
	public static OI oi;

	Command autonomousCommand;
		SendableChooser autoChooser;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		autoChooser = new SendableChooser();
		//autoChooser.addDefault("doNothing", new doNothing());
		//autoChooser.addDefault("autonomousCode", new autonomousCode());
		chassis = new Chassis();
		//arm = new Arm();
		elevator = new Elevator();
		oi = new OI();
		// instantiate the command used for the autonomous period
		// If you see this part of the code and know a Kyle Inzunza, tell him to
		// get Motorvated --Steven
		oi.rightButton3.whileHeld(new ElevatorUp());
		oi.rightButton2.whileHeld(new ElevatorDown());
		//oi.rightButton4.whenPressed(new Interpreter());
		//oi.rightButton5.whenPressed(new InputReader());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		//autonomousComand = (Command) autonomous;
		autonomousCommand = new AutoTest();
		if (autonomousCommand != null) autonomousCommand.start();
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
		if (autonomousCommand != null)
			autonomousCommand.start();
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
