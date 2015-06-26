package model;

import java.awt.event.KeyEvent;

/**
 * Pong paddle.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Paddle {

	public static final int WIDTH = Board.WIDTH / 32;
	public static final int HEIGHT = Board.HEIGHT / 6;
	public static final int PADDLE_SPEED = Board.HEIGHT / 40;

	// Paddle's direction for speed

	public static final boolean PADDLE_DIRECTION_UP = true;
	public static final boolean PADDLE_DIRECTION_DOWN = false;

	// Paddle's variables

	private int x, y;

	// Constructor

	public Paddle(boolean isPlayerOne) {
		setX(isPlayerOne);
		y = Board.HEIGHT / 2 - HEIGHT / 2;
	}

	private void setX(boolean isPlayerOne) {
		x = isPlayerOne ? Board.WIDTH / 80
				: (Board.WIDTH - WIDTH - Board.WIDTH / 80);
	}

	// Getters for the position

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void movePaddle(boolean isPaddleDirectionUp) {
		y += isPaddleDirectionUp ? PADDLE_SPEED : -PADDLE_SPEED;
		if (y < 0)
			y = 0;
		if (y > Board.HEIGHT - HEIGHT)
			y = Board.HEIGHT - HEIGHT;
	}

}
