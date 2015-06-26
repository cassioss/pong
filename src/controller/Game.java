package controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Paddle;
import view.Interface;

public class Game extends JFrame {

	private Interface ponGUI = new Interface();

	protected void setFrame() {
		this.setTitle("Pong");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocation(250, 50);
		this.setResizable(false);
		this.getContentPane().add(ponGUI);
		this.setVisible(true);
		ponGUI.requestFocus();
	}

	protected void runTheBall() {
		while (true) {

		}
	}
}
