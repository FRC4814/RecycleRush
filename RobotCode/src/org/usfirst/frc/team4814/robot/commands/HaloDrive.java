package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.OI;
import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HaloDrive extends Command {

    public HaloDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftPower = Robot.oi.leftStick.getY();
    	double rightPower = Robot.oi.rightStick.getY();
    	Robot.chassis.drive(leftPower,rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
