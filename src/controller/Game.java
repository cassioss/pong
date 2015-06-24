package controller;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Board;
import view.Screen;

public class Game {

	private Screen ponGUI;
	private JFrame pongFrame;

	public Game() {
		ponGUI = new Screen();
		setFrame();
		pongFrame.add(ponGUI.getPongPanel());
	}

	/**
	 * Sets the Pong frame.
	 */
	private void setFrame() {
		pongFrame = new JFrame("Pong");
		pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pongFrame.setSize(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
		pongFrame.setResizable(false);
		pongFrame.setLocation(250, 50);
		pongFrame.setVisible(true);
	}

}
