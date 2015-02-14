package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	Victor winchMotor;
	private DigitalInput elevatorLowLimitSwitch;
	private DigitalInput elevatorHighLimitSwitch;
	private Counter counterLow;
	private Counter counterHigh;
	private double elevatorPower;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		winchMotor = new Victor(RobotMap.WINCH);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetCounters() {
    	counterLow.reset();
    	counterHigh.reset();
    }
    
    public boolean armLimitLow() {
    	if(counterLow.get() > 0)
    		return true;
    	return false;
    }
    
    public boolean armLimitHigh() {
    	if(counterHigh.get() > 0)
    		return true;
    	return false;
    }
    
    public void lift(double power){
    	winchMotor.set(power);
    }
    
	/**
	 * @return the value of the Elevator Limit Switch
	 */
	public DigitalInput getElevatorLowLimitSwitch() {
		return elevatorLowLimitSwitch;
	}

	/**
	 * @return the elevatorHighLimitSwitch
	 */
	public DigitalInput getElevatorHighLimitSwitch() {
		return elevatorHighLimitSwitch;
	}

	/**
	 * @return the elevatorPower
	 */
	public double getElevatorPower() {
		return elevatorPower;
	}

	/**
	 * @param elevatorPower the elevatorPower to set
	 */
	public void setElevatorPower(double elevatorPower) {
		this.elevatorPower = elevatorPower;
	}

	/**
	 * @return the armLowLimitSwitch
	 */
}

