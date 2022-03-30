package seoultech.se.tetris.component;
import java.awt.Color;

import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;


public class Board extends JPanel {

    private static final long serialVersionUID = 2434035659171694595L;

    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;
    public static final char BORDER_CHAR = 'X';

    private JTextPane pane;
    private int[][] board;
    private KeyListener playerKeyListener;
    private SimpleAttributeSet styleSet;
    private Timer timer;
    int x = 3; //Default Position.
    int y = 0;

    private static final int initInterval = 1000;

    public Board() {
        setBounds(10,20,500,700);
        setBackground(Color.BLACK);
    }
}