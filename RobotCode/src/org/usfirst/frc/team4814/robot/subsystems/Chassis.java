package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;
import org.usfirst.frc.team4814.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	private RobotDrive myRobot;
	private Encoder encoderLeft;
	private Encoder encoderRight;
    public Chassis(){    	
    	myRobot = new RobotDrive(RobotMap.LEFT_MOTORS[0],RobotMap.LEFT_MOTORS[1],RobotMap.RIGHT_MOTORS[0],RobotMap.RIGHT_MOTORS[1]); //front left back left front right back right
    	encoderLeft = new Encoder(RobotMap.ENCODER_LEFT[0], RobotMap.ENCODER_LEFT[1], true, EncodingType.k4X);
    	encoderRight = new Encoder(RobotMap.ENCODER_RIGHT[0], RobotMap.ENCODER_RIGHT[1], true, EncodingType.k4X);
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
     * @param distance
     */

	public Encoder getEncoderLeft() {
		return encoderLeft;
	}
	
	public Encoder getEncoderRight() {
		return encoderRight;
	}
}


