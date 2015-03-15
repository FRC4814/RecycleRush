package org.usfirst.frc.team4814.robot.subsystems;
import org.usfirst.frc.team4814.robot.RobotMap;
import org.usfirst.frc.team4814.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class Chassis extends Subsystem {
	private RobotDrive myRobot;
	private Encoder encoderLeft;
	private Encoder encoderRight;
	private double leftPower;
	private double rightPower;
    public Chassis() {
    	//front left back left front right back right
    	myRobot = new RobotDrive(RobotMap.LEFT_MOTORS[0],RobotMap.LEFT_MOTORS[1],RobotMap.RIGHT_MOTORS[0],RobotMap.RIGHT_MOTORS[1]); 
    	encoderLeft = new Encoder(RobotMap.ENCODER_LEFT[0], RobotMap.ENCODER_LEFT[1], true, EncodingType.k2X);
    	encoderLeft.setDistancePerPulse(12.566370614359172/360);
    	//TODO FIX THIS//encoderRight = new Encoder(RobotMap.ENCODER_RIGHT[0], RobotMap.ENCODER_RIGHT[1], true, EncodingType.k4X);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    // If you know him, Tell Kyle Inzunza to get motorvated. 
    public void initDefaultCommand() {
    	
    // Set the default command for a subsystem here.
        setDefaultCommand(new HaloDrive());
    }

	public void drive(double leftPower, double rightPower) { 
    	this.leftPower = leftPower;				// Comment out during normal run time
    	this.rightPower = rightPower;			// Comment out during normal run time
 	   	myRobot.tankDrive(leftPower, rightPower);
 	}

	public Encoder getEncoderLeft() {
		return encoderLeft;//returnes pulses of encoder
	}
	
	/**
	 * @return the right encoder's distance
	 */
	public Encoder getEncoderRight() {
		return encoderRight;//returnes pulses of encoder
	}

	/**
	 * @return the leftPower
	 */
	public double getLeftPower() {
		return leftPower;
	}

	/**
	 * @param leftPower the leftPower to set
	 */
	public void setForwardPower(double leftPower) {
		this.leftPower = leftPower;
	}

	/**
	 * @return the turnPower
	 */
	public double getRightPower() {
		return rightPower;
	}

	/**
	 * @param turnPower the turnPower to set
	 */
	public void setRightPower(double rightPower) {
		this.rightPower = rightPower;
	}
}