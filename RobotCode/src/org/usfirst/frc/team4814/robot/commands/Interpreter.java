package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Interpreter extends Command {
	private OutputWriter outputWriter;

	public Interpreter() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
		//requires(Robot.arm);
		requires(Robot.elevator);
		setTimeout(10);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		outputWriter = new OutputWriter();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() { //gets values of motions and sends to writer
		// Gathers values from throughout the robot and saves them to temporary double variables
		double leftPower = Robot.chassis.getLeftPower();
		double rightPower = Robot.chassis.getRightPower();
		double armPower = 0; //Robot.arm.getArmPower();
		double elevatorPower = Robot.elevator.getElevatorPower();
		// Sends the temporary double variables into the outputWriter to add to it's String
		outputWriter.writeText(leftPower, rightPower, armPower, elevatorPower);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		// outputWriter saves all current data to the hard disk
		outputWriter.save();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
