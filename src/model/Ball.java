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
		x = Board.BOARD_WIDTH / 2;
		y = Board.BOARD_HEIGHT / 2;
		speedX = 15.0;
		speedY = 0.0;
	}

	// Reflection mechanism for the paddles

	public void reflectOnPaddle(double paddleSpeed) {
		speedX *= -1.0;
		speedY += 0.1 * paddleSpeed;
	}

}
