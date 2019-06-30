package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class _02_LogSearch extends JPanel implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	JButton add = new JButton("Add Entry");
	JButton search = new JButton("Search By ID");
	JButton view = new JButton("View All");
	JButton remove = new JButton("Remove");
	HashMap<Integer, String> h = new HashMap<Integer, String>();

	public static void main(String[] args) {
		new  _02_LogSearch();
	}
	public _02_LogSearch() {
		JFrame j = new JFrame();
		j.setTitle("Log");
		j.getContentPane().add(this);
		j.setSize(1920, 1080);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setResizable(true);
		j.setVisible(true);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		this.add(remove);
		this.add(add);
		this.add(search);
		this.add(view);
		t = new Timer(17, this);
		t.start();
	}
	Timer t;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton)e.getSource();
		if (buttonClicked == add){
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Integer ID"));
			String name = JOptionPane.showInputDialog("Enter name");
			h.put(id, name);
		}
		
		if (buttonClicked == search) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Integer ID"));
			String name = h.get(id);
			JOptionPane.showMessageDialog(null, name);
		}
		
		if (buttonClicked == view) {
			String display = "";
			for (int i : h.keySet()) {
				display += "ID " + i + " Name " + h.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, display);
			
		}
		
		if (buttonClicked == remove) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Integer ID"));
			h.remove(id);
		}
		
	}
	
}
