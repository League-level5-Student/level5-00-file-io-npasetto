package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		int key;
		try {
			key=Integer.parseInt(JOptionPane.showInputDialog("Enter a key."));
		}catch(Exception e) {
			e.printStackTrace();
			key=0;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/secret.txt"));
			String line=br.readLine();
			while(line!=null) {
				System.out.println(decrypt(line,key));
				line=br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String decrypt(String message, int key) {
		String decryptedMessage="";
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
				int newIndex=letters.indexOf(message.toLowerCase().charAt(i))-key;
				while(newIndex<0) {
					newIndex+=letters.length();
				}
				newChar=letters.charAt(newIndex%letters.length());
			}
			if(type.equals("upper")) {
				decryptedMessage+=(newChar+"").toUpperCase();
			}else {
				decryptedMessage+=newChar;
			}
		}
		return decryptedMessage;
	}
}

