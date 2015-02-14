package org.usfirst.frc.team4814.robot.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InputReader extends Command {
	
	private Vector<String> dataStack;
	private String temp;
	
    public InputReader() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	Scanner scanner = null;
    	try {
			scanner = new Scanner(new FileInputStream("data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	dataStack = new Vector<String>();
    	while(scanner.hasNext()){
    		dataStack.add(scanner.nextLine());
    	}
    	scanner.close();
    }

    public void reader(){
    	
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	temp = dataStack.remove(0);
    	if(temp.isEmpty() == false){
    		String[] data = temp.split(",");
    		double leftPower = Double.parseDouble(data[0]);
	    	double rightPower = Double.parseDouble(data[1]);
	    	Robot.chassis.drive(leftPower, rightPower);
	    	Double.parseDouble(data[2]);
	    	Double.parseDouble(data[3]);
	    	Robot.arm.setArmPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
	    	temp = temp.substring(temp.indexOf(','));
	    	Robot.elevator.setElevatorPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
	    	temp = temp.substring(temp.indexOf(','));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(temp.isEmpty() == false){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
