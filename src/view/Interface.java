package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

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
	private ArrayList<PaddleAction> moveActions;

	private static final int IFW = WHEN_IN_FOCUSED_WINDOW;

	private static final KeyStroke PRESS_W = KeyStroke.getKeyStroke(
			KeyEvent.VK_W, 0, false);
	private static final KeyStroke RELEASE_W = KeyStroke.getKeyStroke(
			KeyEvent.VK_W, 0, true);
	private static final KeyStroke PRESS_S = KeyStroke.getKeyStroke(
			KeyEvent.VK_S, 0, false);
	private static final KeyStroke RELEASE_S = KeyStroke.getKeyStroke(
			KeyEvent.VK_S, 0, true);
	private static final KeyStroke PRESS_UP = KeyStroke.getKeyStroke(
			KeyEvent.VK_UP, 0, false);
	private static final KeyStroke RELEASE_UP = KeyStroke.getKeyStroke(
			KeyEvent.VK_UP, 0, true);
	private static final KeyStroke PRESS_DOWN = KeyStroke.getKeyStroke(
			KeyEvent.VK_DOWN, 0, false);
	private static final KeyStroke RELEASE_DOWN = KeyStroke.getKeyStroke(
			KeyEvent.VK_DOWN, 0, true);

	private static final int UP_TIMER_DELAY = 90;
	private Timer upTimer;

	public Interface() {
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		restart();
		playerOnePaddle = new Paddle(true);
		playerTwoPaddle = new Paddle(false);
		moveActions = new ArrayList<PaddleAction>();

		InputMap inputMap = getInputMap(IFW);

		inputMap.put(PRESS_W, "LEFT_UP_PRESSED");
		inputMap.put(RELEASE_W, "LEFT_UP_RELEASED");
		inputMap.put(PRESS_S, "LEFT_DOWN_PRESSED");
		inputMap.put(RELEASE_S, "LEFT_DOWN_RELEASED");
		inputMap.put(PRESS_UP, "RIGHT_UP_PRESSED");
		inputMap.put(RELEASE_UP, "RIGHT_UP_RELEASED");
		inputMap.put(PRESS_DOWN, "RIGHT_DOWN_PRESSED");
		inputMap.put(RELEASE_DOWN, "RIGHT_DOWN_RELEASED");

		ActionMap actionMap = getActionMap();

		actionMap.put("LEFT_UP_PRESSED", new PaddleAction(playerOnePaddle,
				Paddle.UP, this, false));
		actionMap.put("LEFT_UP_RELEASED", new PaddleAction(playerOnePaddle,
				Paddle.UP, this, true));
		actionMap.put("LEFT_DOWN_PRESSED", new PaddleAction(playerOnePaddle,
				Paddle.DOWN, this, false));
		actionMap.put("LEFT_DOWN_RELEASED", new PaddleAction(playerOnePaddle,
				Paddle.DOWN, this, true));
		actionMap.put("RIGHT_UP_PRESSED", new PaddleAction(playerTwoPaddle,
				Paddle.UP, this, false));
		actionMap.put("RIGHT_UP_RELEASED", new PaddleAction(playerTwoPaddle,
				Paddle.UP, this, true));
		actionMap.put("RIGHT_DOWN_PRESSED", new PaddleAction(playerTwoPaddle,
				Paddle.DOWN, this, false));
		actionMap.put("RIGHT_DOWN_RELEASED", new PaddleAction(playerTwoPaddle,
				Paddle.DOWN, this, true));
	}

	private void restart() {
		playerOneScore = playerTwoScore = 0;
	}

	private void drawBoard(Graphics g) {
		drawHorizontalLine(g, 50);
		drawHorizontalLine(g, Board.HEIGHT - 50);
		drawMidLine(g);
	}

	private void drawHorizontalLine(Graphics g, int y) {
		g.drawLine(0, y, Board.WIDTH, y);
	}

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

	private class PaddleAction extends AbstractAction {

		private Paddle paddle;
		private boolean direction;
		private Interface pongInterface;
		private boolean isKeyReleased;

		private PaddleAction(Paddle paddle, boolean direction,
				Interface pongInterface, boolean isKeyReleased) {
			this.paddle = paddle;
			this.direction = direction;
			this.pongInterface = pongInterface;
			this.isKeyReleased = isKeyReleased;
		}

		private void moveAndRepaint() {
			paddle.move(direction);
			pongInterface.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!isKeyReleased) {
				if (upTimer != null && upTimer.isRunning()) {
					return;
				}
				moveAndRepaint();
				upTimer = new Timer(UP_TIMER_DELAY, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						moveAndRepaint();
					}

				});
				upTimer.start();
			} else {
				if (upTimer != null && upTimer.isRunning()) {
					upTimer.stop();
					upTimer = null;
				}
			}
		}

	}
}