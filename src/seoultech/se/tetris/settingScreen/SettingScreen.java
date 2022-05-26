package seoultech.se.tetris.settingScreen;

import seoultech.se.tetris.GUI.ImagePanel;
import seoultech.se.tetris.GUI.TimeWaitScreen;
import seoultech.se.tetris.scoreData.dao.ItemScoreCsv;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingScreen extends JFrame {

  static int colorCount = 0;
  FileInputOutput fileInputOutput = new FileInputOutput();
  SettingScreenMenu settingScreenMenu;

  public SettingScreen() {

    settingScreenMenu = new SettingScreenMenu(this);

    // "게임 화면 크기 조절", "게임 조작 키 설정", "스코어 보드 기록 초기화", "색맹 모드", "설정 초기화"
    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "게임 화면 크기 조절") {

              setVisible(false);
              ScreenSettingScreen settingScreen = new ScreenSettingScreen();
              // 추후 추가 예정

        } else if (e.getActionCommand() == "게임 조작 키 설정") {

              setVisible(false);
              KeySettingScreen keySettingScreen = new KeySettingScreen();

        } else if (e.getActionCommand() == "스코어 보드 기록 초기화") {

            NormalScoreCsv normalScoreCsv = new NormalScoreCsv();
            ItemScoreCsv itemScoreCsv = new ItemScoreCsv();
            normalScoreCsv.resetCsv();
            itemScoreCsv.resetCsv();
            System.out.println("스코어 보드 기록 초기화 버튼을 눌렀음");

        } else if (e.getActionCommand() == "색맹 모드") {

              if (colorCount % 2 == 0) {
                fileInputOutput.OutputColorFileForBlind();
                colorCount++;
              } else {
                fileInputOutput.OutputColorFileNotForBlind();
                colorCount++;
              }

        } else if (e.getActionCommand() == "게임 난이도 선택") {

          setVisible(false);
          GameDifficultyScreen gameDifficultyScreen = new GameDifficultyScreen();
          gameDifficultyScreen.setVisible(true);


        } else if (e.getActionCommand() == "설정 초기화") {

              //색맹모드 초기화
              fileInputOutput.OutputColorFileNotForBlind();
              colorCount = 0;
              //조작키 설정 초기화
              fileInputOutput.OutputKeySettingFileToArrow();
              //화면 크기 초기화
              fileInputOutput.OutputScreenSize800800();
              // 스코어 보드 초기화
              NormalScoreCsv normalScoreCsv = new NormalScoreCsv();
              ItemScoreCsv itemScoreCsv = new ItemScoreCsv();
              normalScoreCsv.resetCsv();
              itemScoreCsv.resetCsv();

              fileInputOutput.OutputModeSetting(2);

        } else if (e.getActionCommand() == "메인 화면으로") {

              setVisible(false);
              StartScreen startScreen = new StartScreen();

        }
      }
    };

    setTitle("설정 화면");
    setSize(400, 450);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로
    setContentPane(new ImagePanel());



    SettingScreenMenu settingScreenMenu = new SettingScreenMenu(this);
    settingScreenMenu.setBounds(80,100,230,300);
    for (int i = 0; i < settingScreenMenu.buttons.length; i++) {
       settingScreenMenu.buttons[i].addActionListener(buttonPressed);
    }
    add(settingScreenMenu);

    setVisible(true);
  }
}
