package org.usfirst.frc.team4814.robot.commands;

import java.io.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OutputWriter {

	private String data = new String();

	public OutputWriter() {

	}

	public void writeText(double forwardPower, double turnPower,
			double armPower, double elevatorPower) {
		data.concat(forwardPower + "," + turnPower + "," + armPower + ","
				+ elevatorPower + "\n");
	}

	public void save() {
		FileOutputStream fileHandle2 = null; // Location of the output file
		PrintWriter writer; // Writer for the text
		String fileName = "info.txt"; // File location name
		try {
			fileHandle2 = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // location of data
		writer = new PrintWriter(fileHandle2); // print writer
		writer.println(data); // prints the information
		writer.close();
	}
}