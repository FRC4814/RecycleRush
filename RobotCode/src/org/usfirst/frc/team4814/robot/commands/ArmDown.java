package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDown extends Command {

    public ArmDown() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.resetCounters();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.setArmPower(-0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.armLimitLow();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.setArmPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
