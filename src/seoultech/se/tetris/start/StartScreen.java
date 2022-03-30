package seoultech.se.tetris.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartScreen extends JFrame {

  JButton[] buttons;
  private KeyListener playerKeyListener;

  public StartScreen() {
    setTitle("테트리스 시작 화면");

    setSize(400, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setBackground(Color.PINK);

    JPanel jPanel = new JPanel();

    jPanel.setBackground(Color.PINK);
    jPanel.setBounds(0,0,400,500);
    jPanel.setLayout(null);

    String[] btnText = {"일반 모드 게임 시작", "아이템 모드 게임 시작", "게임 설정", "스코어 보드", "게임 종료"};
    buttons = new JButton[5];
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton(btnText[i]);
      buttons[i].setBackground(new Color(0,0,0,0));
      buttons[i].setVisible(true);
      buttons[i].setBorderPainted(true);
      jPanel.add(buttons[i]);
    }

    int y = 150;
    for (int i = 0; i < buttons.length; i++) {
      buttons[i].setBounds(125, y, 150, 50);
      y += 60;
    }

    JLabel jLabel = new JLabel("Tetris");
    Font font = new Font("Arial", Font.BOLD, 40);
    jLabel.setFont(font);
    jLabel.setLayout(null);
    jLabel.setBounds(145,80,150,40);
    jPanel.add(jLabel, BorderLayout.CENTER);


    getContentPane().add(jPanel);
    setVisible(true);

    playerKeyListener = new PlayerKeyListener();
    addKeyListener(playerKeyListener);
    setFocusable(true);
    requestFocus();

  }

  public class PlayerKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      switch(e.getKeyCode()) {
        case KeyEvent.VK_DOWN:

          break;
        case KeyEvent.VK_UP:

          break;
        default:
          System.out.println("");
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
  }

}
