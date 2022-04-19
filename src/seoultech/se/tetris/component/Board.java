package seoultech.se.tetris.component;

import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.blocks.*;
import seoultech.se.tetris.settingScreen.operationKeySetting.GetKeySetting;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.text.SimpleAttributeSet;


public class Board extends JPanel {

    private static final long serialVersionUID = 2434035659171694595L;

    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;
    private int gridCellSize;

    private Color[][] background;


    private int[][] board;
    private KeyListener playerKeyListener;
    private Timer timer;

    // 다른 클래스
    private GameScore gameScore;
    private ScoreBoard scoreBoard;

    private Block curr;

    GetKeySetting getKeySetting;
    int[] keySetting;

    private static final int initInterval = 1000;

    public Board(GameScore gameScore, ScoreBoard scoreBoard) throws Exception {
        this.gameScore = gameScore;
        this.scoreBoard = scoreBoard;

        setBounds(10, 20, 500, 700);
        this.gameScore = gameScore;
        this.scoreBoard = scoreBoard;
        setBounds(30, 25, 350, 700);
        setBackground(Color.BLACK);
        getBorder(); //보드 테두리 설정 : 배경이 검정이라 되는 건지..?

        gridCellSize = getBounds().width / WIDTH; //네모네모 크기 설정

        background = new Color[HEIGHT][WIDTH];

        //Set timer for block drops.
        timer = new Timer(initInterval, e -> {
            try {
                moveBlockDown(); // 블럭 내려보내기
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        timer.start();
        spawnBlock();

        //키 리스너
        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();

        getKeySetting = new GetKeySetting();
        keySetting = new int[4];
        keySetting[0] = getKeySetting.keys[0];
        keySetting[1] = getKeySetting.keys[1];
        keySetting[2] = getKeySetting.keys[2];
        keySetting[3] = getKeySetting.keys[3];


//        //Initialize board for the game.
//        board = new int[HEIGHT][WIDTH]; //보드생성

    }

    @Override
    public void paintComponent(Graphics g) { //컴포넌트 그리기
        super.paintComponent(g);

        drawBackground(g);
        placeBlock(g);
    }

    private void moveBlockToBackground(){
        int[][] shape = curr.getShape();
        int h = curr.height();
        int w = curr.width();

        int xPos = curr.getX();
        int yPos = curr.getY();

        Color color = curr.getColor();

        for (int row=0; row< h; row++)
        {
            for (int col = 0; col < w; col++)
            {
                if(shape[row][col]==1)
                {
                    background[row + yPos][col + xPos] = color;
                }
            }
        }
    }

    private void placeBlock(Graphics g) { // 블럭 그리기

        Color color = curr.getColor();
        int[][] shape = curr.getShape();

        for (int row = 0; row < curr.height(); row++) {
            for (int col = 0; col < curr.width(); col++) {
                if (shape[row][col]==1) {
                    int x = (curr.getX() + col) * gridCellSize;
                    int y = (curr.getY() + row) * gridCellSize;

                    drawGridSquare(g,color, x, y);
                }
            }
        }
    }

    private void drawBackground(Graphics g) {
        Color color;

        for (int row = 0; row < HEIGHT; row++)
        {
            for (int col = 0; col < WIDTH; col++)
            {
                color = background[row][col];

                if (color != null)
                {
                    int x = col * gridCellSize;
                    int y = row * gridCellSize;

                    drawGridSquare(g, color, x, y );
                }
            }
        }
    }

    private void drawGridSquare(Graphics g, Color color, int x , int y) {
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize); //블럭 그리고
        g.setColor(Color.BLACK);
        g.drawRect(x, y, gridCellSize, gridCellSize); // 테두리 그리기
    }

    public void spawnBlock() throws Exception { // 새로운 블럭 스폰
        NextGenerateBlock nextblock = new NextGenerateBlock();
        curr = nextblock.getRandomBlock();
        curr.spawn(WIDTH);
    }


    protected void moveBlockDown() throws Exception { //블럭 내리기
        if(!checkBottom()) {
            moveBlockToBackground();
            spawnBlock();
            repaint();

        }
        curr.moveDown();
            gameScore.playScore(); // 스코어 증가
            scoreBoard.updateScore(); // 점수 보여주기~
        repaint();
    }

    protected void moveBlockRight() { // 오른쪽 이동

        if(!checkRight()) return;

        curr.moveRight();
        repaint();
    }

    protected void moveBlockLeft() { // 왼쪽 이동

        if(!checkLeft()) return;
        curr.moveLeft();
        repaint();
    }

    protected void dropBlock() throws Exception {
        while (checkBottom()) {
            moveBlockDown();
        }
        repaint();
    }

    protected void rotateBlock() {
        curr.rotate();
        repaint();
    }

    //바닥 체크
    private boolean checkBottom() {
        if (curr.getBottomEdge() == HEIGHT){
            return false;
        }

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int col =0; col < w; col++ )
        {
            for(int row = h-1; row >= 0; row--)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX();
                    int y = row + curr.getY() +1;
                    if(background[y][x] != null) return false;
                }
            }
        }

        return true;
    }

    //왼쪽 체크
    private boolean checkLeft() {
        if(curr.getLeftEdge() ==0) return false;

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int row =0; row < h; row++ )
        {
            for(int col = 0; col < w; col++)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX() -1 ;
                    int y = row + curr.getY();
                    if(background[y][x] != null) return false;
                }
            }
        }
        return true;
    }

    //오른쪽 체크
    private boolean checkRight() {
        if(curr.getRightEdge() == WIDTH) return false;

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int row =0; row < h; row++ )
        {
            for(int col = w-1; col >=0; col--)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX() +1 ;
                    int y = row + curr.getY();
                    if(background[y][x] != null) return false;
                }
            }
        }

        return true;
    }

    public void showPopup() {
        int input = JOptionPane.showConfirmDialog(this, "게임을 중단하시겠습니까? 중단될 경우, 게임의 데이터가 유실됩니다.", "confirm", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            repaint();
        }
    }

    /* 사용자의 키보드 입력에 대한 메소드 */
    public class PlayerKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == keySetting[1]) {
                try {
                    moveBlockDown();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == keySetting[3]) {
                moveBlockRight();
            } else if (e.getKeyCode() == keySetting[2]) {
                moveBlockLeft();
            } else if (e.getKeyCode() == keySetting[0]) {
                rotateBlock();
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    dropBlock();
                    repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                timer.stop();
                repaint();
                showPopup();
                timer.start();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}