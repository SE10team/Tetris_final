package seoultech.se.tetris.settingScreen;

import seoultech.se.tetris.settingScreen.operationKeySetting.KeySettingScreen;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.HashMap;

public class SettingScreen extends JFrame {

  int colorCount = 0;

  public SettingScreen() throws Exception {

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
          KeySettingScreen keySettingScreen = new KeySettingScreen();

          // 추후 추가 예정
        } else if (e.getActionCommand() == "스코어 보드 기록 초기화") {
          System.out.println("스코어 보드 기록 초기화 버튼을 눌렀음");
          // 추후 추가 예정
        } else if (e.getActionCommand() == "색맹 모드") {
          if (colorCount % 2 == 1) {
            try {
              String filename = "/Users/home/Desktop/colorSetting.ser";
              File colorSettingFile = new File(filename);
              if (colorSettingFile.exists()) {
                if (colorSettingFile.delete()) {
                  System.out.println("성공적으로 파일 삭제");
                } else {
                  System.out.println("파일 삭제 실패");
                }
              }
              FileOutputStream fileOutputStream = new FileOutputStream(filename);
              ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
              HashMap<String, Color> hashMap = new HashMap<>();
              hashMap.put("iblock", new Color(0,161,117));
              hashMap.put("jblock", new Color(231,159,0));
              hashMap.put("lblock", new Color(88,179,234));
              hashMap.put("oblock", new Color(240,228,67));
              hashMap.put("sblock", new Color(0,113,177));
              hashMap.put("tblock", new Color(253,67,0));
              hashMap.put("zblock", new Color(206,120,167));

              objectOutputStream.writeObject(hashMap);
              System.out.println(hashMap);
              objectOutputStream.close();
              } catch (IOException fileNotFoundException) {
              fileNotFoundException.printStackTrace();
            }
            colorCount++;
          } else {
            try {
              String filename = "/Users/home/Desktop/colorSetting.ser";
              File colorSettingFile = new File(filename);
              if (colorSettingFile.exists()) {
                if (colorSettingFile.delete()) {
                  System.out.println("성공적으로 파일 삭제");
                } else {
                  System.out.println("파일 삭제 실패");
                }
              }

              FileOutputStream fileOutputStream = new FileOutputStream(filename);
              ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
              HashMap<String, Color> hashMap = new HashMap<>();
              hashMap.put("iblock", Color.CYAN);
              hashMap.put("jblock", Color.BLUE);
              hashMap.put("lblock", Color.ORANGE);
              hashMap.put("oblock", Color.YELLOW);
              hashMap.put("sblock", Color.GREEN);
              hashMap.put("tblock", Color.MAGENTA);
              hashMap.put("zblock", Color.RED);

              System.out.println(hashMap);

              objectOutputStream.writeObject(hashMap);
              objectOutputStream.close();
            } catch (IOException fileNotFoundException) {
              fileNotFoundException.printStackTrace();
            }
            colorCount++;
          }
        } else if (e.getActionCommand() == "설정 초기화") {

          //색맹모드 초기화
          try {
            String filename = "/Users/home/Desktop/colorSetting.ser";
            File colorSettingFile = new File(filename);
            if (colorSettingFile.exists()) {
              if (colorSettingFile.delete()) {
                System.out.println("성공적으로 파일 삭제");
              } else {
                System.out.println("파일 삭제 실패");
              }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            HashMap<String, Color> hashMap = new HashMap<>();
            hashMap.put("iblock", Color.CYAN);
            hashMap.put("jblock", Color.BLUE);
            hashMap.put("lblock", Color.ORANGE);
            hashMap.put("oblock", Color.YELLOW);
            hashMap.put("sblock", Color.GREEN);
            hashMap.put("tblock", Color.MAGENTA);
            hashMap.put("zblock", Color.RED);

            System.out.println(hashMap);

            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
          } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
          }

          //조작키 설정 초기화
          try {
            File colorSettingFile = new File("/Users/home/Desktop/keySetting.ser");
            if (colorSettingFile.exists()) {
              if (colorSettingFile.delete()) {
                System.out.println("성공적으로 파일 삭제");
              } else {
                System.out.println("파일 삭제 실패");
              }
            }
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/home/Desktop/keySetting.ser");
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
        } else if (e.getActionCommand() == "메인 화면으로") {
          setVisible(false);
          StartScreen startScreen = new StartScreen();
          // 추후 추가 예정
        }
      }
    };

    setTitle("설정 화면");
    setSize(400, 450);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로

    SettingScreenMenu settingScreenMenu = new SettingScreenMenu();
    settingScreenMenu.setBounds(120,100,160,300);
    for (int i = 0; i < settingScreenMenu.buttons.length; i++) {
       settingScreenMenu.buttons[i].addActionListener(buttonPressed);
    }
    add(settingScreenMenu);

    setVisible(true);
  }
}
