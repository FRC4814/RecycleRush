package org.usfirst.frc.team4814.robot.autocommands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * Drives the robot forward for a distance, given in TODO Determine the ratio of encoder  to distance  
 * 
 */
public class DriveFor extends Command {
	private double leftPower;	// Power for the left motor
	private double rightPower;	// Power for the right motor
	private double distance;	// Distance in Inches
	
    //Called in autonomous
	//public DriveFor(double leftPower, double rightPower, double distance) {//TODO fix this
	public DriveFor(double leftPower, double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        this.leftPower = .5;	// The amount of power given to the left motors
        this.rightPower = .5;	// The amount of power given to the right motors
        this.distance = 20;		// Distance to travel //TODO multiply 
    }

    // Called just before this Command runs the first time
    // If you know Kyle Inzunza, tell him to get motorvated
    protected void initialize() {
    	Robot.chassis.getEncoderLeft().reset();	// Sets the left encoders to zero 
    	//Robot.chassis.getEncoderRight().reset();// Sets the right encoders to zero
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(leftPower, rightPower);	// Moves the motors with the respective values given
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Tests to see if either encoder has reached the distance it requires
    	if (Robot.chassis.getEncoderLeft().getDistance()*12.566370614359172 < distance) //&& Robot.chassis.getEncoderRight().getDistance()*12.566370614359172 < 
    			//distance) //TODO FIIXXX THISS
    			{
    		return false;
		}
        return true;
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
