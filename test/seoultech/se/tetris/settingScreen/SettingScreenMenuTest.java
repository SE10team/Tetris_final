package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SettingScreenMenuTest {

    String[] btnText = {"게임 화면 크기 조절", "게임 조작 키 설정", "스코어 보드 기록 초기화", "색맹 모드", "게임 난이도 선택", "설정 초기화", "메인 화면으로"};

    SettingScreen settingScreen = new SettingScreen();
    SettingScreenMenu settingScreenMenu = new SettingScreenMenu(settingScreen);

    @Test
    void button_Size() throws IOException, ClassNotFoundException {

        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[0]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);



    }

    @Test
    void button_Key() throws IOException, ClassNotFoundException {


        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[1]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_DOWN );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_ScoreBoard() throws IOException, ClassNotFoundException {

        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[2]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_Color() throws IOException, ClassNotFoundException {

        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[3]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_Difficulty() throws IOException, ClassNotFoundException {


        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[4]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_Setting() throws IOException, ClassNotFoundException {

        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[5]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_Back() throws IOException, ClassNotFoundException {

        SettingScreenMenu.PlayerKeyListener playerKeyListener = settingScreenMenu.playerKeyListener;

        JButton jButtons = new JButton(btnText[6]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

}