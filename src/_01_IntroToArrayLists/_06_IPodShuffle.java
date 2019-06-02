package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle extends JPanel implements ActionListener{
	ArrayList<Song> songs;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
//				Song song = new Song("demo.mp3");
//				song.play();
		JFrame j = new JFrame("songs");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(this);
		j.setVisible(true);
		
		songs = new ArrayList<Song>();
		songs.add(new Song("demo.mp3"));
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}