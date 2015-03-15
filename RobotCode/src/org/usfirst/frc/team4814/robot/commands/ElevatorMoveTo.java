package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMoveTo extends Command {
	
	private int level;
	private double power;
	
    public ElevatorMoveTo(int level) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
        this.level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {//if value less than input, go down
    	System.out.println(Robot.elevator.getCurrentElevatorLevel());
    	if (!Robot.elevator.getLimitSwitch(0)) {
    		power = 0;
    	} else if (!Robot.elevator.getLimitSwitch(3)) {
    		power = 3;//??
    	} else if (level <= Robot.elevator.getCurrentElevatorLevel()) {
    		power = -0.25;
    	} else if (level > Robot.elevator.getCurrentElevatorLevel()) {
    		power = 0.25;
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.elevator.getCurrentElevatorLevel());
    	for (int i = 0; i < 4; i++) {
			System.out.println(Robot.elevator.getLimitSwitch(i));
		}
    	Robot.elevator.lift(power);
    	for (int i = 0; i < 4; i++) {
    		if (Robot.elevator.getLimitSwitch(i)) {
    			//Robot.elevator.setCurrentElevatorLevel(i);
        	}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getLimitSwitch(level);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.lift(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}