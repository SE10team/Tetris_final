package seoultech.se.tetris.startScreen;


import seoultech.se.tetris.GUI.PlayScreen;
import seoultech.se.tetris.settingScreen.SettingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class StartScreen extends JFrame {

  StartScreenMenu startScreenMenu;

  public StartScreen() {

    startScreenMenu = new StartScreenMenu(this);

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "일반 모드 게임 시작") {
          setVisible(false);
          PlayScreen playScreen = null; // Tetris -> PlayScreen으로
          try {
            playScreen = new PlayScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          playScreen.setVisible(true);
        } else if (e.getActionCommand() == "아이템 모드 게임 시작") {
          System.out.println("아이템 모드 게임 시작 버튼을 눌렀음");
          // 추후 추가 예정
        } else if (e.getActionCommand() == "게임 설정") {
          setVisible(false);
          try {
            SettingScreen settingScreen = new SettingScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          // 추후 추가 예정
        } else if (e.getActionCommand() == "스코어 보드") {
          System.out.println("스코어 보드 버튼을 눌렀음");
          // 추후 추가 예정
        } else if (e.getActionCommand() == "게임 종료") {
          System.exit(0);
          System.out.println("게임 종료 버튼을 눌렀음");
          // 추후 추가 예정
        }
      }
    };

    setTitle("테트리스 시작 화면");
    setSize(400, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.PINK);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로


    // 테트리스 제목
    StartScreenTitle startScreenTitle = new StartScreenTitle();
    startScreenTitle.setBounds(125,80,150,50);
    add(startScreenTitle);

    // 메뉴 버튼들
//    StartScreenMenu startScreenMenu = new StartScreenMenu();
    startScreenMenu.setBounds(130, 190, 145, 300);
    for (int i = 0; i < startScreenMenu.buttons.length; i++) {
      startScreenMenu.buttons[i].addActionListener(buttonPressed);
    }
    add(startScreenMenu);

    setVisible(true);
  }
}
