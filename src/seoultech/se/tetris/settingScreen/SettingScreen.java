package seoultech.se.tetris.settingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingScreen extends JFrame {

  public SettingScreen() {

    // "게임 화면 크기 조절", "게임 조작 키 설정", "스코어 보드 기록 초기화", "색맹 모드", "설정 초기화"
    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "게임 화면 크기 조절") {
          setVisible(false);
          // 추후 추가 예정
        } else if (e.getActionCommand() == "게임 조작 키 설정") {
          System.out.println("게임 조작 키 설정 버튼을 눌렀음");
          setVisible(false);

          // 추후 추가 예정
        } else if (e.getActionCommand() == "스코어 보드 기록 초기화") {
          System.out.println("스코어 보드 기록 초기화 버튼을 눌렀음");
          // 추후 추가 예정
        } else if (e.getActionCommand() == "색맹 모드") {
          System.out.println("색맹 모드 버튼을 눌렀음");
          // 추후 추가 예정
        } else if (e.getActionCommand() == "설정 초기화") {
          System.exit(0);
          System.out.println("설정 초기화 버튼을 눌렀음");
          // 추후 추가 예정
        }
      }
    };

    setTitle("설정 화면");
    setSize(800, 800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로

    SettingScreenMenu settingScreenMenu = new SettingScreenMenu();
    settingScreenMenu.setBounds(130,190,145,300);
    for (int i = 0; i < settingScreenMenu.buttons.length; i++) {
       settingScreenMenu.buttons[i].addActionListener(buttonPressed);
    }
    add(settingScreenMenu);

    setVisible(true);
  }
}
