package seoultech.se.tetris.GUI;

import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Pair {
    Board first;
    Board second;

    public Pair(Board first, Board second) {
        this.first = first;
        this.second = second;
    }

////    public Board getFirst() {
////        return first;
////    }
////
////    public Board getSecond() {
////        return second;
//    }

    public Board getOthers(Board board) {
        if (board == first)
            return second;
        else
            return first;
    }
}

public class MatchScreen extends JFrame {

    private Pair boards;

    PlayerKeyListener playerKeyListener;

    public Board mainBoard1;
    public Board mainBoard2;

    public static void main(String[] args) throws Exception {
        MatchScreen tetris = new MatchScreen();
        tetris.setVisible(true);

    }

    public MatchScreen() throws Exception {
        super("대전 모드 테트리스"); // 게임 실행시 이름

        FileInputOutput fileInputOutput = new FileInputOutput();
        int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();

        setSize(1525, 1000); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setBackground(Color.WHITE);


        GameScore score1 = new GameScore();
        ScoreBoard scoreBoard1 = new ScoreBoard(score1);
        NextGenerateBlock nextBlock1 = new NextGenerateBlock();
        NextBoard nextBoard1 = new NextBoard(nextBlock1);
        mainBoard1 = new Board(this, score1, scoreBoard1, nextBlock1, nextBoard1);

        mainBoard1.setBounds(50, 50, 350, 700);
        scoreBoard1.setBounds(450, 50, 200, 100);
        nextBoard1.setBounds(450, 200, 200, 200);
        add(mainBoard1);
        add(scoreBoard1);
        add(nextBoard1);

        GameScore score2 = new GameScore();
        ScoreBoard scoreBoard2 = new ScoreBoard(score2);
        NextGenerateBlock nextBlock2 = new NextGenerateBlock();
        NextBoard nextBoard2 = new NextBoard(nextBlock2);
        mainBoard2 = new Board(this, score2, scoreBoard2, nextBlock2, nextBoard2);

        mainBoard2.setBounds(800, 50, 350, 700);
        scoreBoard2.setBounds(1200, 50, 200, 100);
        nextBoard2.setBounds(1200, 200, 200, 200);
        add(mainBoard2);
        add(scoreBoard2);
        add(nextBoard2);

        WaitingBoard waitingBoard1 = new WaitingBoard(mainBoard2);
        waitingBoard1.setBounds(450, 500, 200, 200);
        WaitingBoard waitingBoard2 = new WaitingBoard(mainBoard1);
        waitingBoard2.setBounds(1200, 500, 200, 200);

        add(waitingBoard1);
        add(waitingBoard2);

        boards = new Pair(mainBoard1, mainBoard2);



        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();

    }

    public void sendWaitingLines(Board board) {

        board.getWaitingLines(boards.getOthers(board).tossBackground);
        boards.getOthers(board).clearWaitingLines();
    }

    public class PlayerKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            // 오른쪽 보드
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                try {
                    if(!mainBoard2.isBlockOutOfBounds()) mainBoard2.moveBlockDown();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                mainBoard2.moveBlockRight();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                mainBoard2.moveBlockLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                mainBoard2.rotateBlock();
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    if(!mainBoard2.isBlockOutOfBounds()){
                        mainBoard2.dropBlock();
//                        moveBlockToBackground();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                mainBoard1.timer.stop();
                mainBoard2.timer.stop();
                repaint();
                mainBoard1.showPopup();
                mainBoard2.timer.start();
                mainBoard1.timer.start();

            }




            // 왼쪽 보드
            else if (e.getKeyCode() == KeyEvent.VK_S) {
                try {
                    if(!mainBoard1.isBlockOutOfBounds()) mainBoard1.moveBlockDown();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                mainBoard1.moveBlockRight();
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                mainBoard1.moveBlockLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                mainBoard1.rotateBlock();
            } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                try {
                    if(!mainBoard1.isBlockOutOfBounds()){
                        mainBoard1.dropBlock();
//                        moveBlockToBackground();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
