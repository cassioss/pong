package controller;

import java.awt.AWTEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import model.Board;
import view.Interface;

public class Game {

	protected static void createAndShowGui() {
		Interface ponGUI = new Interface();
		JFrame pongFrame = new JFrame("Pong");
		pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pongFrame.getContentPane().add(ponGUI);
		pongFrame.setSize(Board.WIDTH, Board.HEIGHT);
		pongFrame.setLocation(250, 50);
		pongFrame.setResizable(false);
		pongFrame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}

}
