package model;

/**
 * Pong paddle.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Paddle {

	public static final int PADDLE_WIDTH = 3;
	public static final int PADDLE_HEIGHT = 30;
	public static final double PADDLE_SPEED = 15.0;

	// Paddle's direction for speed

	public static final int PADDLE_DIRECTION_UP = 1;
	public static final int PADDLE_DIRECTION_DOWN = -1;

	// Paddle's variables

	private double x, y;
	private double currentSpeed;

	// Constructor

	public Paddle(double x, double y) {
		setX(x);
		setY(y);
		currentSpeed = 0.0;
	}

	// Getters and setters for the position

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Setter for speed

	public void setCurrentSpeed(int direction) {
		if (direction == PADDLE_DIRECTION_UP)
			currentSpeed = PADDLE_SPEED;
		else if (direction == PADDLE_DIRECTION_DOWN)
			currentSpeed = -PADDLE_SPEED;
		else
			currentSpeed = 0.0;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

}
