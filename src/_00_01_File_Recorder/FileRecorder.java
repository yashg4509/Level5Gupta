package _00_01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	String message;

	public static void main(String[] args) {
		FileRecorder fr = new FileRecorder();
		try {
			fr.message = JOptionPane.showInputDialog("What would you like to write on your file?");

			FileWriter fw = new FileWriter("src/_00_01_File_Recorder/message.txt");
			fw.write(fr.message);
			fw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
