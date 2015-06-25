package controller;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import view.Interface;

public class Game {
	
	private static JFrame pongFrame;
	
	private static void setFrame(){
		pongFrame = new JFrame("Pong");
		pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pongFrame.setSize(800, 600);
		pongFrame.setLocation(250, 50);
		pongFrame.setResizable(false);
		pongFrame.add(new Interface());
		pongFrame.setVisible(true);
	}

	public static void main(String[] args) {
		setFrame();
	}
}
