package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	private DigitalInput armLowLimitSwitch;
	private DigitalInput armHighLimitSwitch;
	private SpeedController armMotor;
	private Counter counterLow;
	private Counter counterHigh;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Arm() {
		armMotor = new Victor(RobotMap.ARM_MOTOR);
		counterLow = new Counter(armLowLimitSwitch);
		counterHigh = new Counter(armHighLimitSwitch);
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
    
    public void armUp() {
    	armMotor.set(0.5);
    }
    
    public void armDown() {
    	armMotor.set(-0.5);
    }
    
    public void armStop() {
    	armMotor.set(0);
    }
}

