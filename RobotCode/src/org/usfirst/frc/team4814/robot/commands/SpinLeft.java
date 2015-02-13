package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinLeft extends Command {

    public SpinLeft(double seconds) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.getEncoderLeft().reset();
    	Robot.chassis.getEncoderRight().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(0.5, -0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
