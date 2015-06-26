package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import model.Ball;
import model.Board;
import model.Paddle;

/**
 * Pong screen.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Interface extends JPanel implements KeyListener {

	private Integer playerOneScore;
	private Integer playerTwoScore;
	private Paddle playerOnePaddle = new Paddle(true);
	private Paddle playerTwoPaddle = new Paddle(false);
	private Ball pongBall = new Ball();

	public Interface() {
		setBackground(Color.BLACK);
		restart();
		setFocusable(true);
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

	/**
	 * Draw the pong board. These are only the essentials, so this method is
	 * only called once.
	 * 
	 * @param g
	 */
	private void drawBoard(Graphics g) {
		drawHorizontalLine(g, 50);
		drawHorizontalLine(g, Board.HEIGHT - 50);
		drawMidLine(g);
	}

	/**
	 * Draws an horizontal line at any specific height.
	 * 
	 * @param g
	 * @param y
	 */
	private void drawHorizontalLine(Graphics g, int y) {
		g.drawLine(0, y, Board.WIDTH, y);
	}

	/**
	 * Draws a vertical line at the screen's midpoint.
	 * 
	 * @param g
	 */
	private void drawMidLine(Graphics g) {
		g.drawLine(Board.HALF_WIDTH, Board.SCORE_BOARD_HEIGHT,
				Board.HALF_WIDTH, Board.HEIGHT - Board.SCORE_BOARD_HEIGHT);
	}

	private void drawScoreBoard(Graphics g) {
		int fontSize = Board.SCORE_BOARD_HEIGHT * 3 / 5;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.drawString(playerOneScore.toString(), Board.HALF_WIDTH * 3 / 2,
				fontSize);
		g.drawString(playerTwoScore.toString(), Board.HALF_WIDTH / 2 - fontSize
				/ 2, fontSize);
	}

	private void drawPaddles(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Rectangle2D.Double(playerOnePaddle.getX(), playerOnePaddle
				.getY(), Paddle.WIDTH, Paddle.HEIGHT));
		g2.fill(new Rectangle2D.Double(playerTwoPaddle.getX(), playerTwoPaddle
				.getY(), Paddle.WIDTH, Paddle.HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		drawBoard(g);
		drawScoreBoard(g);
		drawPaddles(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			playerOnePaddle.movePaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_S)
			playerOnePaddle.movePaddle(Paddle.PADDLE_DIRECTION_DOWN);
		else if (e.getKeyCode() == KeyEvent.VK_KP_UP)
			playerTwoPaddle.movePaddle(Paddle.PADDLE_DIRECTION_UP);
		else if (e.getKeyCode() == KeyEvent.VK_KP_DOWN)
			playerTwoPaddle.movePaddle(Paddle.PADDLE_DIRECTION_DOWN);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}