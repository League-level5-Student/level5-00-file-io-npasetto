package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		File file=new File("src");
		ArrayList<File> directories=new ArrayList<File>();
		ArrayList<File> newDirectories=new ArrayList<File>();
		directories.add(file);
		while(directories.size()!=0) {
			for (File file2 : directories) {
				File[] newFiles=file2.listFiles();
				for (File file3 : newFiles) {
					String name=file3.getName();
					if(file3.isDirectory()) {
						newDirectories.add(file3);
					}else if(name.substring(name.length()-5).equals(".java")){
						try {
							FileWriter fw=new FileWriter(file3.getAbsolutePath(), true);
							fw.write("//Copyright 2020");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			directories.clear();
			for (File file2 : newDirectories) {
				directories.add(file2);
			}
			newDirectories.clear();
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
}//Copyright 2020//Copyright 2020