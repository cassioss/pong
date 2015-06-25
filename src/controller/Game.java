package controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Paddle;
import view.Interface;

public class Game extends JFrame implements KeyListener {

	private void setFrame() {
		this.setName("Pong");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocation(250, 50);
		this.setResizable(false);
		this.add(new Interface());
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			moveLeftPaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_S)
			moveLeftPaddle(Paddle.PADDLE_DIRECTION_DOWN);
		else if (e.getKeyCode() == KeyEvent.VK_UP)
			moveRightPaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			moveRightPaddle(Paddle.PADDLE_DIRECTION_DOWN);
	}

	private void moveLeftPaddle(boolean isPaddleDirectionUp) {
		int direction = isPaddleDirectionUp ? 1 : -1;
	}

	private void moveRightPaddle(boolean isPaddleDirectionUp) {
		int direction = isPaddleDirectionUp ? 1 : -1;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
