package model;

/**
 * Pong paddle.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Paddle {

	public static final int width = 3;
	public static final int height = 30;
	public static final int speed = 15;
	
	private double x, y;
	private int currentSpeed;
	
	// Constructor
	
	public Paddle (double x, double y){
		this.setX(x);
		this.setY(y);
		this.currentSpeed = 0;
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

}
