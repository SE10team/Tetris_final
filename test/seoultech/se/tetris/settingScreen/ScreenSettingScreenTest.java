package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ScreenSettingScreenTest {

    String[] btnText = {"800 X 800", "1000 X 1000", "1300 X 1000", "뒤로가기"};


    FileInputOutput fileInputOutput = new FileInputOutput();
    ScreenSettingScreen screenSettingScreen = new ScreenSettingScreen();

    @Test
    void button_800800() throws IOException, ClassNotFoundException {
        fileInputOutput.OutputScreenSize800800();


        ScreenSettingScreen.PlayerKeyListener playerKeyListener = screenSettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[0]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);



    }

    @Test
    void button_Arrow() throws IOException, ClassNotFoundException {
        fileInputOutput.OutputScreenSize10001000();


        ScreenSettingScreen.PlayerKeyListener playerKeyListener = screenSettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[1]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_13001300() throws IOException, ClassNotFoundException {
        fileInputOutput.OutputScreenSize13001000();

        ScreenSettingScreen.PlayerKeyListener playerKeyListener = screenSettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[2]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    void button_Back() throws IOException, ClassNotFoundException {


        ScreenSettingScreen.PlayerKeyListener playerKeyListener = screenSettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[3]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }
}