package view;

import javax.swing.JPanel;

/**
 * Pong screen.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Screen {

	private JPanel pongPanel;

	// Scores

	private int playerOneScore;
	private int playerTwoScore;

	/**
	 * Restarts the score board.
	 */
	private void restart() {
		playerOneScore = playerTwoScore = 0;
	}

}