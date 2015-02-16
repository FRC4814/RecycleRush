package org.usfirst.frc.team4814.robot.commands;

import java.io.DataOutputStream;

/**
 *
 */
public class OutputWriter {

	private String data = new String();

	public OutputWriter() {

	}

	public void writeText(double forwardPower, double turnPower, 
			double armPower, double elevatorPower) {
		//writes to variable to text file to store motions 
		data.concat(forwardPower + "," + turnPower + "," + armPower + ","
				+ elevatorPower + "\n");
	}

	public void save() { //writes to text file
		DataOutputStream theFile;
		FileConnection fc;
		try{
			fc = (FileConnection)Connector.open("file:///output.txt", Connector.WRITE);
			fc.create();
			theFile = fc.openDataOutputSteam();
		} catch (Exception e){
			
		}
		com.squ	
	}
}
