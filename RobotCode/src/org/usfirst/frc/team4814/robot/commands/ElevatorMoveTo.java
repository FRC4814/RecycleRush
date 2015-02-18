package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator to a level dictated by the constructor
 */
public class ElevatorMoveTo extends Command {
	
	private int level;
	private double power;
	
	// Lists requirements and sets desired level
    public ElevatorMoveTo(int level) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
        this.level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(Robot.elevator.getCurrentElevatorLevel()); 	//TODO Remove testing code
    	if (Robot.elevator.getCurrentElevatorLevel() == 0) {			// Checks to see if the elevator is as low as it can go, then sets its power to zero if it is
    		power = 0;
    	} else if (Robot.elevator.getCurrentElevatorLevel() == 2) {		// Checks to see if the elevator is as high as it can go, then sets its power to zero if it is
    		power = 0;
    	} else if (level <= Robot.elevator.getCurrentElevatorLevel()) {	// Checks to see if the destination is lower than the current location, then moves it downward if it is
    		power = -0.25;
    	} else if (level > Robot.elevator.getCurrentElevatorLevel()) {	// Checks to see if the destination is higher that the current location, then moves it upward if it is
    		power = 0.25;
    	}
    }

    // Called repeatedly when this command is scheduled to run
    // Moves the elevator in a direction based on the value of 'power'
    protected void execute() {
    	System.out.println(Robot.elevator.getCurrentElevatorLevel());
    	Robot.elevator.lift(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.elevator.getCurrentElevatorLevel() == level); 	// Checks to see if the elevator has reached it's destination
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