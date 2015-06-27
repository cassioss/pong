package model;

/**
 * Pong board.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Board {

	// Board's dimensions - these are the only two variables in the entire code

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	// Good derivatives

	public static final int HALF_WIDTH = WIDTH / 2;
	public static final int SCORE_BOARD_HEIGHT = HEIGHT / 12;

	// Board's boundaries

	public static final int UPPER_BOUND = SCORE_BOARD_HEIGHT;
	public static final int LOWER_BOUND = HEIGHT - SCORE_BOARD_HEIGHT;

}
