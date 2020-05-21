package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message=JOptionPane.showInputDialog("Enter a message.");
		int key;
		try {
			key=Integer.parseInt(JOptionPane.showInputDialog("Enter a key."));
		}catch(Exception e) {
			e.printStackTrace();
			key=0;
		}
		String encryptedMessage="";
		String letters="abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < message.length(); i++) {
			char character=message.charAt(i);
			String type;
			if(!letters.contains((character+"").toLowerCase())) {
				type="none";
			}else if((character+"").toLowerCase().equals(character+"")){
				type="lower";
			}else {
				type="upper";
			}
			char newChar='a';
			if(type.equals("none")) {
				newChar=character;
			}else {
				newChar=letters.charAt((letters.indexOf(message.toLowerCase().charAt(i))+key)%letters.length());
			}
			if(type.equals("upper")) {
				encryptedMessage+=(newChar+"").toUpperCase();
			}else {
				encryptedMessage+=newChar;
			}
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/secret.txt");
			fw.write(encryptedMessage);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//Copyright 2020