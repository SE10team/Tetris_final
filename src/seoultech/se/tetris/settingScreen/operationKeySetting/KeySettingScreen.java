package seoultech.se.tetris.settingScreen.operationKeySetting;

import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.settingScreen.SettingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeySettingScreen extends JFrame {

  public KeySettingScreen() {

    FileInputOutput fileInputOutput = new FileInputOutput();

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "W, A, S, D 키로 조작") {

              fileInputOutput.OutputKeySettingWithWASD();

        } else if (e.getActionCommand() == "화살표 방향키로 조작") {

              fileInputOutput.OutputKeySettingFileToArrow();

        } else if (e.getActionCommand() == "뒤로가기") {
              setVisible(false);
              try {
                SettingScreen settingScreen = new SettingScreen();
              } catch (Exception ex) {
                ex.printStackTrace();
              }
        }
      }
    };


    setTitle("조작키 설정 화면");
    setSize(400, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로

    String[] btnText = {"W, A, S, D 키로 조작", "화살표 방향키로 조작", "뒤로가기"};

    JLabel jLabel1 = new JLabel("W, A, S, D 키로 조작");
    Font font = new Font("Arial", Font.PLAIN, 15);
    jLabel1.setFont(font);
    jLabel1.setLayout(null);
    jLabel1.setBounds(125,140,150,20);
    add(jLabel1);

    JButton wasdButton = new JButton(btnText[0]);
    wasdButton.setBounds(125, 180, 150, 20);
    add( wasdButton );
    wasdButton.addActionListener(buttonPressed);

    JLabel jLabel2 = new JLabel("화살표 방향키로 조작");
    jLabel2.setFont(font);
    jLabel2.setLayout(null);
    jLabel2.setBounds(125,220,150,20);
    add(jLabel2);

    JButton arrowButton = new JButton(btnText[1]);
    arrowButton.setBounds(125, 260, 150, 20);
    add( arrowButton );
    arrowButton.addActionListener(buttonPressed);

    JLabel jLabel3 = new JLabel("뒤로가기");
    jLabel3.setFont(font);
    jLabel3.setLayout(null);
    jLabel3.setBounds(125,300,150,20);
    add(jLabel3);

    JButton back = new JButton(btnText[2]);
    back.setBounds(125, 340, 150, 20);
    add( back );
    back.addActionListener(buttonPressed);


    setVisible(true);
  }
}
