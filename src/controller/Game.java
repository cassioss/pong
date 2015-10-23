package controller;

import model.Board;
import view.Interface;

import javax.swing.*;
import java.awt.*;

public class Game {

    private static Dimension screenSize;
    private static Interface ponGUI;

    protected static void createAndShowGui() {
        getScreenSize();
        ponGUI = new Interface();
        createFrame();
    }

    private static void getScreenSize() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private static int adjustX() {
        double width = screenSize.getWidth();
        int fullWidth = (int) width;
        return (fullWidth - Board.WIDTH) / 2;
    }

    private static int adjustY() {
        double height = screenSize.getHeight();
        int fullHeight = (int) height;
        return (fullHeight - Board.HEIGHT) / 2;
    }

    private static void createFrame() {
        JFrame pongFrame = new JFrame("Pong");
        pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pongFrame.getContentPane().add(ponGUI);
        pongFrame.setSize(Board.WIDTH, Board.HEIGHT);
        pongFrame.setLocation(adjustX(), adjustY());
        pongFrame.setResizable(false);
        pongFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::createAndShowGui);
    }

}
