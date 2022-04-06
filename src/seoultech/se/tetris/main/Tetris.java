package seoultech.se.tetris.main;


import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.Board;
import seoultech.se.tetris.settingScreen.SettingScreen;
import seoultech.se.tetris.startScreen.StartScreen;

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
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          StartScreen startScreen = new StartScreen();
        }
      });

      /*EventQueue.invokeLater(new Runnable() {
        public void run() {
          SettingScreen settingScreen = new SettingScreen();
        }
      });*/

  }

}