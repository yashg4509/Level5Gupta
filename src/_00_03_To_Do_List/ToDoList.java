package _00_03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	ArrayList<String> tasks = new ArrayList<>();

	void setup() {
		frame = new JFrame("To Do List");
		panel = new JPanel();
		add = new JButton("Add Task");
		view = new JButton("View Tasks");
		remove = new JButton("Remove Task");
		save = new JButton("Save List");
		load = new JButton("Load List");

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 75);
		frame.add(panel);

		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);

		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String addTask = JOptionPane.showInputDialog("What task would you like to add?");
			tasks.add(addTask);
		}

		if (e.getSource() == view) {
			JOptionPane.showMessageDialog(null, "Your tasks include: " + tasks);
		}

		if (e.getSource() == remove) {
			String removeItem = JOptionPane.showInputDialog("What would you like to remove?");
			if (tasks.contains(removeItem)) {
				tasks.remove(tasks.indexOf(removeItem));
			} else {
				JOptionPane.showMessageDialog(null, "Sorry! That is not on your To Do List!");
			}
		}

		if (e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_00_03_To_Do_List/savedtaskslists.txt");

				/*
				 * NOTE: To append to a file that already exists, add true as a second parameter
				 * when calling the FileWriter constructor. (e.g. FileWriter fw = new
				 * FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				 */
				String taskS = tasks.toString();
				fw.write(taskS);

				fw.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		}

		if (e.getSource() == load) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_00_03_To_Do_List/savedtaskslists.txt"));
				for (int i = 0; i < tasks.size(); i++) {
					String line = br.readLine();
					tasks.add(line);
				}
				for (int i = 0; i < tasks.size(); i++) {
					JOptionPane.showMessageDialog(null, tasks.get(i));
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException l) {
				// TODO Auto-generated catch block
				l.printStackTrace();
			}
		}
	}
}
