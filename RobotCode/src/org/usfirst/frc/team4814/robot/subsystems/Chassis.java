package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;
import org.usfirst.frc.team4814.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	RobotDrive myRobot;
    public Chassis(){    	
    	myRobot = new RobotDrive(RobotMap.LEFT_MOTORS[0],RobotMap.LEFT_MOTORS[1],RobotMap.RIGHT_MOTORS[0],RobotMap.RIGHT_MOTORS[1]); //front left back left front right back right
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new HaloDrive());
    }
    //public void drive(double leftPower, double rightPower){
    	//myRobot.tankDrive(leftPower, rightPower);    	
    //}
    
    public void drive(double ForwardPower, double TurnPower){ //HALO DRIVE
 	   myRobot.tankDrive(ForwardPower, TurnPower);
 	   }
    /**
     * 
     * Drives the robot forward for an amount of time given in seconds 
     * 
     * @param leftPower
     * @param rightPower
     * @param time to travel in seconds
     */
    public void driveFor(double leftPower, double rightPower, int time) {
    	this.drive(leftPower, rightPower);
    	try {
    		Thread.sleep(time*1000);
    	} catch (InterruptedException ex){
    	}
    	this.drive(0, 0);
    }
    public void turnLeft() {
    	this.driveFor(0.5, 0.1, 2);
    }
    public void turnRight() {
    	this.driveFor(0.1, 0.5, 2);
    }
    public void spinLeft() {
    	this.driveFor(0.5, -0.5, 2);
    }
    public void spinRight() {
    	this.driveFor(-0.5, 0.5, 2);
    }
}


