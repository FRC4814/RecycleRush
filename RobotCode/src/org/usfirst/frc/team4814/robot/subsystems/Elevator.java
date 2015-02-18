package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	Victor[] winchMotor;
	private DigitalInput[] elevatorLimitSwitch;
	private double elevatorPower;
	private int currentElevatorLevel;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		winchMotor = new Victor[2];
		winchMotor[0] = new Victor(RobotMap.ELEVATOR_MOTOR[0]);
		winchMotor[1] = new Victor(RobotMap.ELEVATOR_MOTOR[1]);
		elevatorLimitSwitch = new DigitalInput[4];
		for (int i = 0; i < elevatorLimitSwitch.length; i++) {
			elevatorLimitSwitch[i] = new DigitalInput(RobotMap.ELEVATOR_PORTS[i]);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lift(double power){
    	//winchMotor[0].set(power);
    	//winchMotor[1].set(power);
    }
    
	/**
	 * @return the value of the Elevator Limit Switch
	 */
	public boolean getLimitSwitch(int level) {
		return elevatorLimitSwitch[level].get();
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

	public int getCurrentElevatorLevel() {
		int counter = 0;
		for (int i = 0; i < elevatorLimitSwitch.length; i++)
			if (!elevatorLimitSwitch[i].get())
				counter++;
		return counter;
	}
}

