package _00_02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("What message would you like to display on the encryptor file?");

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < message.length(); i++) {
			if (Character.isUpperCase(message.charAt(i))) {
				char ch = (char) (((int) message.charAt(i) + 3 - 65) % 26 + 65);
				result.add(ch + "");
			} else {
				char ch = (char) (((int) message.charAt(i) + 3 - 97) % 26 + 97);
				result.add(ch + "");
			}
		}

		try {
			FileWriter fw = new FileWriter("src/_00_02_File_Encrypt_Decrypt/encrypted.txt");
			for (int i = 0; i < result.size(); i++) {
				fw.write(result.get(i));
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
