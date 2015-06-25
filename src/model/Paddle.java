package model;

/**
 * Pong paddle.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Paddle {

	public static final int PADDLE_WIDTH = 30;
	public static final int PADDLE_HEIGHT = 100;
	public static final double PADDLE_SPEED = 15.0;

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

	public Paddle(int x, int y) {
		setX(x);
		setY(y);
	}

	// Getters and setters for the position

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
