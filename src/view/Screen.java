package view;

import javax.swing.JPanel;

/**
 * Pong screen.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Screen {

	private JPanel pongPanel;
	private int playerOneScore;
	private int playerTwoScore;
	
	public Screen(){
		restart();
		pongPanel = new JPanel();
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
	
	public JPanel getPongPanel(){
		return pongPanel;
	}
	
}