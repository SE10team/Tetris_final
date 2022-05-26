package seoultech.se.tetris.startScreen;

import seoultech.se.tetris.GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FightModeSelectionScreen extends JFrame {

  FightModeSelectionMenuScreen menuScreen;

  public FightModeSelectionScreen() {
    menuScreen = new FightModeSelectionMenuScreen(this);

    // Frame 레이아웃
    setLayout(null); // 레이아웃 설정
    this.setContentPane(new FightModeSelectionScreen.ImagePanel());
    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "일반 대전 모드") {
          setVisible(false);
          try {
            MatchScreen matchScreen = new MatchScreen();
            matchScreen.setVisible(true);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        } else if (e.getActionCommand() == "아이템 대전 모드") {
          setVisible(false);
          try {
            ItemMatchScreen itemMatchScreen = new ItemMatchScreen();
            itemMatchScreen.setVisible(true);
          } catch (Exception ex) {
            ex.printStackTrace();
          }

        }  else if (e.getActionCommand() == "시간제한 대전 모드") {
          setVisible(false);
          try {
            TimeWaitScreen timeWaitScreen = new TimeWaitScreen();
            timeWaitScreen.setVisible(true);
          } catch (Exception ex) {
            ex.printStackTrace();
          }

        } else if (e.getActionCommand() == "뒤로가기") {
          setVisible(false);
          StartScreen startScreen = new StartScreen();
        }
      }
    };

    setTitle("대전 게임 모드 선택 화면");
    setSize(500, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.PINK);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로

    // 메뉴 버튼들
//    StartScreenMenu startScreenMenu = new StartScreenMenu();
    menuScreen.setBounds(100, 130, 300, 300);
    for (int i = 0; i < menuScreen.buttons.length; i++) {
      menuScreen.buttons[i].addActionListener(buttonPressed);
    }
    add(menuScreen);

    setVisible(true);
  }

  class ImagePanel extends JComponent { // 이미지 추가를 위한 클래스
    private Image image = new ImageIcon(HighScoreScreen.class.getResource("../image/timeImage.jpg")).getImage();
    Image changeImg = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(changeImg, 0, 0, this);
    }
  }
}
