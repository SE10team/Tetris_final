package seoultech.se.tetris.startScreen;

import seoultech.se.tetris.GUI.ItemMatchScreen;
import seoultech.se.tetris.GUI.MatchScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FightModeSelectionScreen extends JFrame {

  FightModeSelectionMenuScreen menuScreen;

  public FightModeSelectionScreen() {
    menuScreen = new FightModeSelectionMenuScreen(this);


    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "일반 대전 모드") {
          setVisible(false);
          try {
            MatchScreen matchScreen = new MatchScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        } else if (e.getActionCommand() == "아이템 대전 모드") {
          setVisible(false);
          try {
            ItemMatchScreen itemMatchScreen = new ItemMatchScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }

        }  else if (e.getActionCommand() == "시간제한 대전 모드") {

        } else if (e.getActionCommand() == "뒤로가기") {
          setVisible(false);
          StartScreen startScreen = new StartScreen();
        }
      }
    };

    setTitle("대전 게임 모드 선택 화면");
    setSize(400, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.PINK);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로

    // 메뉴 버튼들
//    StartScreenMenu startScreenMenu = new StartScreenMenu();
    menuScreen.setBounds(130, 190, 145, 300);
    for (int i = 0; i < menuScreen.buttons.length; i++) {
      menuScreen.buttons[i].addActionListener(buttonPressed);
    }
    add(menuScreen);

    setVisible(true);
  }
}
