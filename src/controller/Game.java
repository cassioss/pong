package controller;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import model.Board;
import view.Interface;

public class Game {

	private static Dimension screenSize;
	private static Interface ponGUI;
	private static JFrame pongFrame;

	protected static void createAndShowGui() {
		getScreenSize();
		ponGUI = new Interface();
		createFrame();
	}

	private static void getScreenSize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}

	private static int adjustX() {
		double width = screenSize.getWidth();
		int fullWidth = (int) width;
		return (fullWidth - Board.WIDTH) / 2;
	}

	private static int adjustY() {
		double height = screenSize.getHeight();
		int fullHeight = (int) height;
		return (fullHeight - Board.HEIGHT) / 2;
	}

	private static void createFrame() {
		pongFrame = new JFrame("Pong");
		pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pongFrame.getContentPane().add(ponGUI);
		pongFrame.setSize(Board.WIDTH, Board.HEIGHT);
		pongFrame.setLocation(adjustX(), adjustY());
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
