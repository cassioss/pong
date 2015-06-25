package controller;

import java.awt.Dimension;

import javax.swing.JFrame;

import view.Screen;

public class Game {

    public static void main(String[] args) {
            JFrame frame = new JFrame("Hello");
            frame.setPreferredSize(new Dimension(800, 600));
            frame.add(new Screen());
            frame.pack();
            frame.setVisible(true);
    }
}

