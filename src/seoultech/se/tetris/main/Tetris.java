package seoultech.se.tetris.main;


import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.PlayScreen;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.Board;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.settingScreen.SettingScreen;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Tetris extends JFrame { // 게임 전체 화면

  private Board mainBoard;

  public static void main(String[] args) throws Exception {
//		Tetris tetris = new Tetris();
//		tetris.setVisible(true);

    // 시작 화면 틀고싶으면 밑에 주석을 풀어주세여

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        StartScreen startScreen = new StartScreen();
      }
    });


//      EventQueue.invokeLater(new Runnable() {
//        public void run() {
//          SettingScreen settingScreen = new SettingScreen();
//        }
//      });


  }

  public Tetris() throws Exception {
    super("Tetris");
    System.out.println("시작");
    // 맥 (유빈)
    final String colorFilename = "/Users/home/Desktop/colorSetting.ser";
    final String keySettingFilename = "/Users/home/Desktop/keySetting.ser";
    final String screenSizeFilename = "/Users/home/Desktop/screenSizeSetting.ser";

    // 윈도우 (윤재)
//   private final String colorFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/colorSetting.ser";
//   private final String keySettingFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/keySetting.ser";
//   private final String screenSizeFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/screenSizeSetting.ser";

    FileInputOutput fileInputOutput = new FileInputOutput();
    if (!(new File((colorFilename)).exists())) {
      fileInputOutput.OutputColorFileNotForBlind();
    }
    if (!(new File((keySettingFilename)).exists())) {
      fileInputOutput.OutputKeySettingFileToArrow();
    }
    if (!(new File((screenSizeFilename)).exists())) {
      fileInputOutput.OutputScreenSize800800();
    }

    int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();

    setSize(screenSizeArr[0],screenSizeArr[1]); // 전체 화면 크기
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
    setLayout(null); // 레이아웃 설정
    setBackground(Color.WHITE);

    GameScore score = new GameScore();
    ScoreBoard scoreBoard = new ScoreBoard(score);

    NextGenerateBlock nextBlock = new NextGenerateBlock();
    NextBoard nextBoard = new NextBoard(nextBlock);
    mainBoard = new Board(score, scoreBoard, nextBlock, nextBoard);

    add(mainBoard);
    add(scoreBoard);
    add(nextBoard);


  }
}

