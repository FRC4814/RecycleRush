package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	Victor winchMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		winchMotor = new Victor(RobotMap.WINCH);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void lift(double power){
    	winchMotor.set(power);
    }
}

