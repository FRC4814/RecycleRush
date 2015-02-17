package org.usfirst.frc.team4814.robot.autocommands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
		data = data.concat(forwardPower + "," + turnPower + "," + armPower + ","
				+ elevatorPower + "\n");
	}

	public void save() { //writes to text file
		System.out.println("data"+ data);
		FileOutputStream fileHandle2 = null; // Location of the output file
		PrintWriter writer; // Writer for the text
		String fileName = "/home/lvuser/info.txt"; // File location name
		try {
			fileHandle2 = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // location of data
		writer = new PrintWriter(fileHandle2); // print writer
		writer.write(data); // prints the information
		writer.close();
		
	}
}
