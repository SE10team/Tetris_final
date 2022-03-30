package seoultech.se.tetris.component;
import seoultech.se.tetris.blocks.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


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

    private Block curr;
//    private NewBoard nextB;
    int x = 3; //Default Position.
    int y = 0;

    private static final int initInterval = 1000;

    public Board() {
        setBounds(10,20,500,700);
        setBackground(Color.BLACK);

        //Board display setting.
        pane = new JTextPane();
        pane.setEditable(false);
        pane.setBackground(Color.BLACK);
        CompoundBorder border = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 10),
                BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        pane.setBorder(border);
//        this.getContentPane().add(pane, BorderLayout.CENTER);

        //Document default style.
        styleSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(styleSet, 18);
        StyleConstants.setFontFamily(styleSet, "Courier");
        StyleConstants.setBold(styleSet, true);
        StyleConstants.setForeground(styleSet, Color.WHITE);
        StyleConstants.setAlignment(styleSet, StyleConstants.ALIGN_CENTER);

        //Set timer for block drops.
        timer = new Timer(initInterval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDown();
                drawBoard();
            }
        });

        //Initialize board for the game.
        board = new int[HEIGHT][WIDTH]; //보드생성
        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();

        //Create the first block and draw.
//        nextB.getRandomBlock(); // Todo 자바 이렇게 쓰는 게 맞나?
        curr = getRandomBlock(); // 얘도?
        placeBlock();
        drawBoard();
        timer.start();
    }

    public Block getRandomBlock() {
        Random rnd = new Random(System.currentTimeMillis());
        int block = rnd.nextInt(7);
        return switch (block) {
            case 0 -> new IBlock();
            case 1 -> new JBlock();
            case 2 -> new LBlock();
            case 3 -> new ZBlock();
            case 4 -> new SBlock();
            case 5 -> new TBlock();
            default -> new OBlock();
        };
    }

    private void placeBlock() { //x, y 에서 curr의 shape만큼 밑에 Shape를 불러옴
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet styles = new SimpleAttributeSet();
        StyleConstants.setForeground(styles, curr.getColor());
        for(int j=0; j<curr.height(); j++) {
            int rows = y+j == 0 ? 0 : y+j-1;
            int offset = rows * (WIDTH+3) + x + 1;
            doc.setCharacterAttributes(offset, curr.width(), styles, true);
            for(int i=0; i<curr.width(); i++) {
                board[y+j][x+i] = curr.getShape(i, j);
            }
        }
    }

    private void eraseCurr() { //블럭 사라지게 하기 Todo 블럭을 지워서 사라졌다가 다시 생기는 현상
        for(int i=x; i<x+curr.width(); i++) {
            for(int j=y; j<y+curr.height(); j++) {
                board[j][i] = 0;
            }
        }
    }



    protected void moveDown() {
        eraseCurr();
        if(y < HEIGHT - curr.height()) y++;// 바닥을 그냥 최대 array size로 놔서 겹쳐짐 :todo 쌓이게 하려면 board 내부를
//		else if (y != HEIGHT - curr.height() && board[y+curr.height()+1][x]==1){ // 바닥까지 내려갈 때 index값이 넘어서 버림.
//			placeBlock(); // 위치시키고
//			curr = getRandomBlock(); // 새로운 블록 호출
//			x = 3;
//			y = 0;
//
//		}
        else {
            placeBlock(); // 위치시키고

            curr = getRandomBlock(); // 새로운 블록 호출
//            nextB.getRandomBlock();
            x = 3;
            y = 0;
        }
        placeBlock();
    }

    //바닥 체크
    private boolean checkBottom() {
        return true;
    }

    //왼쪽 체크
    private boolean checkLeft() {
        return true;
    }

    //오른쪽 체크
    private boolean checkRight() {
        return true;
    }

    protected void moveRight() {
        eraseCurr();
        if(x < WIDTH - curr.width()) x++;
        placeBlock();
    }

    protected void moveLeft() {
        eraseCurr();
        if(x > 0) {
            x--;
        }
        placeBlock();
    }

    protected void moveToGround() {
        eraseCurr();
        /*
        바닥으로 내력가게끔
        */
        placeBlock();
    }

    public void drawBoard() {
        StringBuffer sb = new StringBuffer();
        for(int t=0; t<WIDTH+2; t++) sb.append(BORDER_CHAR);
        sb.append("\n");
        for(int i=0; i < board.length; i++) {
            sb.append(BORDER_CHAR);
            for(int j=0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    sb.append("O");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(BORDER_CHAR);
            sb.append("\n");
        }
        for(int t=0; t<WIDTH+2; t++) sb.append(BORDER_CHAR);
        pane.setText(sb.toString());
        StyledDocument doc = pane.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), styleSet, false);
        pane.setStyledDocument(doc);
    }

    public void reset() {
        this.board = new int[20][10];
    }

    public void showPopup() {
        int input = JOptionPane.showConfirmDialog(this, "게임을 중단하시겠습니까? 중단될 경우, 게임의 데이터가 유실됩니다.", "confirm", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            drawBoard();
        }
    }

    public class PlayerKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    moveDown();
                    drawBoard();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    drawBoard();
                    break;
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    drawBoard();
                    break;
                case KeyEvent.VK_UP:
                    eraseCurr();
                    curr.rotate();
                    drawBoard();
                    break;
                case KeyEvent.VK_SPACE:
                    moveToGround();
                    drawBoard();
                    break;
                case KeyEvent.VK_ESCAPE:
                    timer.stop();
                    drawBoard();
                    showPopup();
                    timer.start();
                    break;
                }
            }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}