package _00_02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		String message = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/_00_02_File_Encrypt_Decrypt/encrypted.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			message = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String k = JOptionPane.showInputDialog("Enter key: ");
		int key = Integer.parseInt(k);
		char ch;
		String decryptedMessage = "";

		for (int i = 0; i < message.length(); i++) {
			ch = message.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - key);

				if (ch < 'a') {
					ch = (char) (ch + 'z' - 'a' + 1);
				}

				decryptedMessage += ch;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - key);

				if (ch < 'A') {
					ch = (char) (ch + 'Z' - 'A' + 1);
				}

				decryptedMessage += ch;

			} else {
				decryptedMessage += ch;
			}
		}

		System.out.println("Decrypted Message = " + decryptedMessage);

	}
}
