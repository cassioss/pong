package model;

/**
 * Pong ball.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Ball {

	// Ball's dimensions, position and speed

	public static final int radius = 3;
	private double x, y;
	private double speedX, speedY;

	// Constructor

	public Ball() {
		setX(Board.BOARD_WIDTH / 2);
		setY(Board.BOARD_HEIGHT / 2);
		setSpeedX(15.0);
		setSpeedY(0.0);
	}

	// Reflection mechanism for the paddles

	public void reflectOnPaddle(double paddleSpeed) {
		setSpeedX(getSpeedX() * -1.0);
		setSpeedY(getSpeedY() + 0.1 * paddleSpeed);
	}

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

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

}
