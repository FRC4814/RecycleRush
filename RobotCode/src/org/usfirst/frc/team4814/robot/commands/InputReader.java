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
	
	private Vector<String> dataStack; //used to store data read from the text file
	private String temp; //temporary text
	
    public InputReader() {
        
    	//initializes scanner and sets to the text file
    	Scanner scanner = null;
    	try {
			scanner = new Scanner(new FileInputStream("data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	//loops and sets the Vector data lsit
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
	    	double armPower = Double.parseDouble(data[2]);
	    	double elevatorPower = Double.parseDouble(data[3]);
	    	
	    	//Why?? VV
	    	//Robot.arm.setArmPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
	    	//temp = temp.substring(temp.indexOf(','));
	    	//Robot.elevator.setElevatorPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
	    	//temp = temp.substring(temp.indexOf(','));
	    	
	    	Robot.arm.setArmPower(armPower);
	    	Robot.elevator.setElevatorPower(elevatorPower);
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
