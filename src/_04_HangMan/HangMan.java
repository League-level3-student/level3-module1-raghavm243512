package _04_HangMan;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HangMan extends JPanel implements ActionListener, KeyListener {
	int totalwords;
	Utilities u = new Utilities();
	Stack<String> words = new Stack<String>();
	ArrayList<String> guesses = new ArrayList<String>();
	String display = "";
	String currentword;
	int lives;
	boolean restart;
	Font font = new Font("Serif", Font.PLAIN, 30);

	public static void main(String[] args) {
		new HangMan();
		
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(font);
		g2.setFont(font);
		g2.drawString(display, 100, 100);
		g2.drawString(Integer.toString(lives), 1800, 100);
	}

	public HangMan() {
		JFrame j = new JFrame();
		j.setTitle("HangMan");
		j.getContentPane().add(this);
		j.addKeyListener(this);
		j.setSize(1920, 1080);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setResizable(true);
		j.setVisible(true);

		String s = JOptionPane.showInputDialog("Enter the number of words");
		if (s.equals(""))
			totalwords = 1;
		else
			totalwords = Integer.parseInt(s);
		if (totalwords > u.getTotalWordsInFile("dictionary.txt"))
			totalwords = u.getTotalWordsInFile("dictionary.txt");

		for (int i = 0; i < totalwords; i++) {
			String a = u.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(a))
				words.push(a);
			else
				i--;

		}
		restart = false;
		startgame();
		t = new Timer(17, this);
		t.start();

	}

	public void startgame() {
		if (words.size() == 0)
			JOptionPane.showMessageDialog(null, "You win", "", JOptionPane.INFORMATION_MESSAGE);

		guesses = new ArrayList<String>();
		display = "";
		currentword = words.pop();
		lives = currentword.length() / 2;
		for (int i = 0; i < currentword.length(); i++) {
			display += "_ ";
		}
	}

	Timer t;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		if (currentword.indexOf(Character.toString(e.getKeyChar())) != -1) {
			String temp = display;
			temp = temp.replace(" ", "");
			display = "";
			for (int i = 0; i < currentword.length(); i++) {
				if (Character.toString(currentword.charAt(i)).equals(Character.toString(e.getKeyChar()))) {
					display += Character.toString(e.getKeyChar()) + " ";
				} else if (Character.toString(currentword.charAt(i)).equals(Character.toString(temp.charAt(i)))) {
					display += Character.toString(temp.charAt(i)) + " ";
				} else
					display += "_ ";

			}
			if (!guesses.contains(Character.toString(e.getKeyChar())))
				guesses.add(Character.toString(e.getKeyChar()));
			else
				lives--;
		} else
			lives--;

		if (lives <= 0) {
			int a = JOptionPane.showConfirmDialog(null, "You lose, play again?", "", JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				new HangMan();
			}
			else {
				System.exit(0);
			}
		}
		if (display.replace(" ", "").equals(currentword)) {
			startgame();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
