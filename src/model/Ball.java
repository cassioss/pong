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
		x = Board.width / 2;
		y = Board.height / 2;
		speedX = 15.0;
		speedY = 0.0;
	}

}
