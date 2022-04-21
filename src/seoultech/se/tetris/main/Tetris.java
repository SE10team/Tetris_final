package seoultech.se.tetris.main;

import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame { // 게임 전체 화면

  public static void main(String[] args) throws Exception {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        StartScreen startScreen = new StartScreen();
      }
    });
  }
}

