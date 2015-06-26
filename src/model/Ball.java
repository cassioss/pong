package model;

/**
 * Pong ball.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Ball {

	// Ball's dimensions, position and speed

	public static final int radius = 3;
	private int x, y;
	private int speedX, speedY;

	// Constructor

	public Ball() {
		setX(Board.WIDTH / 2);
		setY(Board.SCORE_BOARD_HEIGHT + Board.HEIGHT / 2);
		setSpeedX(15);
		setSpeedY(0);
	}

	// Reflection mechanism for the paddles

	public void reflectOnPaddle(int paddleSpeed) {
		setSpeedX(getSpeedX() * (-1));
		setSpeedY(getSpeedY() + (int) Math.round(0.1 * paddleSpeed));
	}

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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
