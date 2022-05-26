package seoultech.se.tetris.settingScreen;

import seoultech.se.tetris.GUI.StyledButtonUI;
import seoultech.se.tetris.main.Tetris;
import seoultech.se.tetris.scoreData.dao.ItemScoreCsv;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
import seoultech.se.tetris.startScreen.StartScreen;
import seoultech.se.tetris.startScreen.StartScreenMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SettingScreenMenu extends JPanel {

  JButton[] buttons;
  PlayerKeyListener playerKeyListener;
  SettingScreen settingScreen;

  public SettingScreenMenu(SettingScreen settingScreen) {
    this.settingScreen = settingScreen;

    playerKeyListener = new PlayerKeyListener();

    String[] btnText = {"게임 화면 크기 조절", "게임 조작 키 설정", "스코어 보드 기록 초기화", "색맹 모드", "게임 난이도 선택", "설정 초기화", "메인 화면으로"};
    buttons = new JButton[7];
    setBackground(new Color(0,0,0,0));

    for (int i = 0; i < 7; i++) {
      buttons[i] = new JButton(btnText[i]);
      buttons[i].setUI(new StyledButtonUI());
      buttons[i].setSize(190,30);
      buttons[i].setFont(new Font("나눔", Font.BOLD, 15));
      add(buttons[i]);

      Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>( buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS ) );
      set.add( KeyStroke.getKeyStroke( "UP" ) );
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set );

      Set<AWTKeyStroke> set2 = new HashSet<AWTKeyStroke>( buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS ) );
      set2.add( KeyStroke.getKeyStroke( "DOWN" ) );
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set2 );

      buttons[i].addKeyListener(playerKeyListener);
    }


  }

  public class PlayerKeyListener extends Component implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == buttons[0]) {

          settingScreen.setVisible(false);
          ScreenSettingScreen settingScreen = new ScreenSettingScreen();

        } else if (e.getSource() == buttons[1]) {

          settingScreen.setVisible(false);
          KeySettingScreen keySettingScreen = new KeySettingScreen();

        } else if (e.getSource() == buttons[2]) {

          NormalScoreCsv normalScoreCsv = new NormalScoreCsv();
          ItemScoreCsv itemScoreCsv = new ItemScoreCsv();
          normalScoreCsv.resetCsv();
          itemScoreCsv.resetCsv();
          System.out.println("스코어 보드 기록 초기화 버튼을 눌렀음");
          // 추후 추가 예정

        } else if (e.getSource() == buttons[3]) {
          if (settingScreen.colorCount % 2 == 0) {
            settingScreen.fileInputOutput.OutputColorFileForBlind();
            settingScreen.colorCount++;

          } else {
            settingScreen.fileInputOutput.OutputColorFileNotForBlind();
            settingScreen.colorCount++;
          }

        } else if (e.getSource() == buttons[4]) {

          settingScreen.setVisible(false);
          GameDifficultyScreen gameDifficultyScreen = new GameDifficultyScreen();

        } else if (e.getSource() == buttons[5]) {

          //색맹모드 초기화
          settingScreen.fileInputOutput.OutputColorFileNotForBlind();
          settingScreen.colorCount = 0;
          //조작키 설정 초기화
          settingScreen.fileInputOutput.OutputKeySettingFileToArrow();
          //화면 크기 초기화
          settingScreen.fileInputOutput.OutputScreenSize800800();

          settingScreen.fileInputOutput.OutputModeSetting(2);

        } else if (e.getSource() == buttons[6]) {
          settingScreen.setVisible(false);
          StartScreen startScreen = new StartScreen();

        }

      } else if (e.getKeyCode() != KeyEvent.VK_ENTER || e.getKeyCode() != KeyEvent.VK_DOWN || e.getKeyCode() != KeyEvent.VK_UP) {
        JOptionPane.showConfirmDialog(this, "엔터와 위아래 화살표를 눌러주세요", "confirm", JOptionPane.INFORMATION_MESSAGE);
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
  }
}
