package seoultech.se.tetris.main;


import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.Board;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;

public class Tetris extends JFrame { // 게임 전체 화면
  private JTextPane pane;
  private SimpleAttributeSet styleSet;

  public static void main(String[] args) {
		Tetris tetris = new Tetris();
		tetris.setVisible(true);

    // 시작 화면 틀고싶으면 밑에 주석을 풀어주세여
    /*
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          StartScreen startScreen = new StartScreen();
        }
      });
     */
  }

  public Tetris(){
    super("테스트"); // 게임 실행시 이름
    setSize(800,800); // 전체 화면 크기
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
    setLayout(null); // 레이아웃 설정
    setBackground(Color.WHITE);

    Board mainBoard = new Board();
    ScoreBoard scoreBoard = new ScoreBoard();
    NextBoard nextBoard = new NextBoard();
    add(mainBoard);
    add(scoreBoard);
    add(nextBoard);

  }
}