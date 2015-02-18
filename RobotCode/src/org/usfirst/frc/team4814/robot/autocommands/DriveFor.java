package org.usfirst.frc.team4814.robot.autocommands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * Drives the robot forward for a distance, given in TODO Determine the ratio of encoder  to distance  
 * 
 */
public class DriveFor extends Command {
	private double leftPower;	
	private double rightPower;	
	private double distance;	// Distance in Inches
	
    //Called in autonomous
	public DriveFor(double leftPower, double rightPower, double distance) {//TODO fix this
	//public DriveFor(double leftPower, double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        this.leftPower = leftPower;		// Power for Left Motor	
        this.rightPower = 0.5;	// Power for Right Motor
        this.distance = distance;		// Distance to travel in Inches 
    }

    // Called just before this Command runs the first time
    // If you know Kyle Inzunza, tell him to get motorvated
    protected void initialize() {
    	System.out.println("Reset");
    	// Sets encoders to zero 
    	Robot.chassis.getEncoderLeft().reset();    	
    	//Robot.chassis.getEncoderRight().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(leftPower, rightPower);	// Moves the motors with the respective values given
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Tests to see if either encoder has reached the distance it requires
    	System.out.println(Robot.chassis.getEncoderLeft().get());
    	if (Robot.chassis.getEncoderLeft().getDistance() >= distance && Robot.chassis.getEncoderRight().getDistance() > distance) //TODO FIIXXX THISS
    	{
    		return true;
		}
        return false;
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
