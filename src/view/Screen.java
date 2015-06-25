package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Pong screen.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Screen extends JPanel {

	private int playerOneScore;
	private int playerTwoScore;

	public Screen() {
		setBackground(Color.BLACK);
		restart();
	}

	/**
	 * Restarts the score board.
	 */
	private void restart() {
		playerOneScore = playerTwoScore = 0;
	}

	/**
	 * Increments the score depending on the player.
	 * 
	 * @param isPlayerOne
	 */
	private void incrementScore(boolean isPlayerOne) {
		if (isPlayerOne)
			playerOneScore++;
		else
			playerTwoScore++;
	}

}