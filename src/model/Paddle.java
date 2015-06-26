package model;

import java.awt.event.KeyEvent;

/**
 * Pong paddle.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Paddle {

	public static final int PADDLE_WIDTH = Board.WIDTH / 32;
	public static final int PADDLE_HEIGHT = Board.HEIGHT / 6;
	public static final int PADDLE_SPEED = Board.HEIGHT / 40;

	// Paddle's direction for speed

	public static final boolean PADDLE_DIRECTION_UP = true;
	public static final boolean PADDLE_DIRECTION_DOWN = false;

	// Paddle's identifiers

	public static final boolean PADDLE_LEFT = true;
	public static final boolean PADDLE_RIGHT = false;

	// Paddle's variables

	private int x, y;
	private double currentSpeed;

	// Constructor

	public Paddle(boolean isPlayerOne, int y) {
		setX(isPlayerOne);
		this.y = y;
	}

	private void setX(boolean isPlayerOne) {
		x = isPlayerOne ? Board.WIDTH / 80
				: (Board.WIDTH - PADDLE_WIDTH - Board.WIDTH / 80);
	}

	// Getters for the position

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Key listeners

	public void keyPressedForLeftPaddle(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			movePaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_S)
			movePaddle(Paddle.PADDLE_DIRECTION_DOWN);
	}

	public void keyPressedForRightPaddle(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			movePaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			movePaddle(Paddle.PADDLE_DIRECTION_DOWN);
	}

	private void movePaddle(boolean isPaddleDirectionUp) {
		y += isPaddleDirectionUp ? PADDLE_SPEED : -PADDLE_SPEED;
		if (y < 0)
			y = 0;
		if (y > Board.HEIGHT)
			y = Board.HEIGHT;
	}

}
