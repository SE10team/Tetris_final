package seoultech.se.tetris.settingScreen.operationKeySetting;

import seoultech.se.tetris.main.Tetris;
import seoultech.se.tetris.settingScreen.SettingScreen;
import seoultech.se.tetris.settingScreen.SettingScreenMenu;
import seoultech.se.tetris.startScreen.StartScreenMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class KeySettingScreen extends JFrame {

  public KeySettingScreen() {

    String keySettingFile = "/Users/home/Desktop/keySetting.ser";

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "W, A, S, D 키로 조작") {

          try {
            File colorSettingFile = new File(keySettingFile);
            if (colorSettingFile.exists()) {
              if (colorSettingFile.delete()) {
                System.out.println("성공적으로 파일 삭제");
              } else {
                System.out.println("파일 삭제 실패");
              }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(keySettingFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("UP", KeyEvent.VK_W);
            hashMap.put("DOWN", KeyEvent.VK_S);
            hashMap.put("LEFT", KeyEvent.VK_A);
            hashMap.put("RIGHT", KeyEvent.VK_D);

            objectOutputStream.writeObject(hashMap);
            System.out.println(hashMap);
            objectOutputStream.close();
          } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
          }

        } else if (e.getActionCommand() == "화살표 방향키로 조작") {

          try {
            File colorSettingFile = new File(keySettingFile);
            if (colorSettingFile.exists()) {
              if (colorSettingFile.delete()) {
                System.out.println("성공적으로 파일 삭제");
              } else {
                System.out.println("파일 삭제 실패");
              }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(keySettingFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("UP", KeyEvent.VK_UP);
            hashMap.put("DOWN", KeyEvent.VK_DOWN);
            hashMap.put("LEFT", KeyEvent.VK_LEFT);
            hashMap.put("RIGHT", KeyEvent.VK_RIGHT);

            objectOutputStream.writeObject(hashMap);
            System.out.println(hashMap);
            objectOutputStream.close();
          } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
          }


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
