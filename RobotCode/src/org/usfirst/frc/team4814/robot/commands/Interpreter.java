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
		requires(Robot.arm);
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		outputWriter = new OutputWriter();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() { //gets values of motions and sends to writer
		double leftPower = Robot.chassis.getLeftPower();
		double rightPower = Robot.chassis.getRightPower();
		double armPower = Robot.arm.getArmPower();
		double elevatorPower = Robot.elevator.getElevatorPower();
		outputWriter.writeText(leftPower, rightPower, armPower, elevatorPower);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		outputWriter.save();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
