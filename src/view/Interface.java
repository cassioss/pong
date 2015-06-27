package view;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.Ball;
import model.Board;
import model.Paddle;

/**
 * Pong screen.
 * 
 * @author Cassio dos Santos Sousa
 */
public class Interface extends JPanel {

	private Paddle playerOnePaddle, playerTwoPaddle;
	private Integer playerOneScore, playerTwoScore;

	public Interface() {
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new PongKeyListener());
		restart();
		playerOnePaddle = new Paddle(true);
		playerTwoPaddle = new Paddle(false);
		/*
		 * this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		 * KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "forward");
		 * this.getActionMap().put("forward", new AbstractAction() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * playerOnePaddle.move(Paddle.PADDLE_DIRECTION_UP); repaint(); } });
		 */
	}

	private void restart() {
		playerOneScore = playerTwoScore = 0;
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
		g.drawLine(Board.HALF_WIDTH, Board.UPPER_BOUND, Board.HALF_WIDTH,
				Board.LOWER_BOUND);
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

	private class PongKeyListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			keyPressed(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				playerOnePaddle.move(Paddle.PADDLE_DIRECTION_UP);
				repaint();
				break;
			case KeyEvent.VK_S:
				playerOnePaddle.move(Paddle.PADDLE_DIRECTION_DOWN);
				repaint();
				break;
			case KeyEvent.VK_UP:
				playerTwoPaddle.move(Paddle.PADDLE_DIRECTION_UP);
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				playerTwoPaddle.move(Paddle.PADDLE_DIRECTION_DOWN);
				repaint();
				break;
			}
		}
	}

}