package _03_IntroToStacks;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class _02_TextUndoRedo extends JPanel implements ActionListener, KeyListener{
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	Stack<String> deleted = new Stack<String>();
	Stack<String> text = new Stack<String>();
	Font font = new Font("Serif", Font.PLAIN, 12);
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(font);
		String d = "";
		for (String i : text)
			d+=i;
		g2.drawString(d, 3, 10);
	}
	public _02_TextUndoRedo() {
		JFrame j = new JFrame();
		j.setTitle("");
		j.getContentPane().add(this);
		j.addKeyListener(this);
		j.setSize(1920, 1080);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setResizable(true);
		j.setVisible(true);
		t = new Timer(17, this);
		t.start();
		
	}
	Timer t;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE&&text.size()>0) {
			deleted.push(text.pop());
			
			
		}
		else if (e.getKeyCode()==KeyEvent.VK_ALT&&deleted.size()>0) {
			text.push(deleted.pop());
			
		}
		else if (e.getKeyCode()!=KeyEvent.VK_SHIFT){
			
			text.push(Character.toString(e.getKeyChar()));
			
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
