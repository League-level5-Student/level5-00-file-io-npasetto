package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton add=new JButton();
	JButton view=new JButton();
	JButton remove=new JButton();
	JButton save=new JButton();
	JButton load=new JButton();
	ArrayList<String> tasks=new ArrayList<String>();
	public static void main(String[] args) {
		ToDoList t=new ToDoList();
		t.setup();
	}

	public void setup() {
		add.setPreferredSize(new Dimension(100,30));
		view.setPreferredSize(new Dimension(100,30));
		remove.setPreferredSize(new Dimension(130,30));
		save.setPreferredSize(new Dimension(100,30));
		load.setPreferredSize(new Dimension(100,30));
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.setText("Add Task");
		view.setText("View Tasks");
		remove.setText("Remove Task");
		save.setText("Save Tasks");
		load.setText("Load Tasks");
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton clicked=(JButton) arg0.getSource();
		if(clicked==add) {
			tasks.add(JOptionPane.showInputDialog("Enter a task."));
		}else if(clicked==view) {
			String answer="Tasks:";
			for (String task : tasks) {
				answer+="\n"+task;
			}
			JOptionPane.showMessageDialog(null,answer);
		}
	}
}
