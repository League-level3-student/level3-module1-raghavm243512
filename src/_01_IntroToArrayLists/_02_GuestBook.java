package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	JFrame window;
	JPanel panel;
	JButton add;
	JButton view;
	ArrayList<String> names;
	public static void main(String[] args) {
		new _02_GuestBook().start();
	}
	public void start() {
		names = new ArrayList<String>();
		window = new JFrame("");
		panel = new JPanel();
		add =new JButton();
		view = new JButton();
		add.setText("add");
		view.setText("view");
		panel.add(add);
		panel.add(view);
		add.addActionListener(this);
		view.addActionListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton)e.getSource();
		if (buttonClicked==add) {
			names.add(JOptionPane.showInputDialog("Enter a name"));
		} else if (buttonClicked==view) {
			String a = "";
			for (String i : names) {
				a+=i;
				a+="\n";
			}
			JOptionPane.showMessageDialog(null, a);
		}
		
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	
	
}
