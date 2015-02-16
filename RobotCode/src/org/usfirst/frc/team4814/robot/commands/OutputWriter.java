package org.usfirst.frc.team4814.robot.commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
		data.concat(forwardPower + "," + turnPower + "," + armPower + ","
				+ elevatorPower + "\n");
	}

	public void save() { //writes to text file
		
            /*
		FileOutputStream FOS = null;
		PrintWriter writer;
		File file = new File("c:/data.txt");
		
		try{
			
			FOS = new FileOutputStream(file);
			writer = new PrintWriter(FOS);
			if(!file.exists()){
				file.createNewFile();
			}
			
			writer.println(data);
			
		}catch(IOException e){
			
		}
		
	 	
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
		
		
		
		DataOutputStream theFile;
		FileConnection fc;
		try{
			fc = (FileConnection)Connector.open("file:///output.txt", Connector.WRITE);
			fc.create();
			theFile = fc.openDataOutputSteam();
		} catch (Exception e){
			
		}
		com.squ
		
		
		*/	
	}
}
