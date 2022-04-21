package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KeySettingScreenTest {

    String[] btnText = {"W, A, S, D 키로 조작", "화살표 방향키로 조작", "뒤로가기"};


    FileInputOutput fileInputOutput = new FileInputOutput();
    KeySettingScreen keySettingScreen = new KeySettingScreen();

    @Test
    void button_WASD() throws IOException, ClassNotFoundException {
        fileInputOutput.OutputKeySettingWithWASD();


        KeySettingScreen.PlayerKeyListener playerKeyListener = keySettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[0]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);



    }

    @Test
    void button_Arrow() throws IOException, ClassNotFoundException {
        keySettingScreen.fileInputOutput.OutputKeySettingFileToArrow();


        KeySettingScreen.PlayerKeyListener playerKeyListener = keySettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[1]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_DOWN );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }

    @Test
    void button_Back() throws IOException, ClassNotFoundException {
        keySettingScreen.fileInputOutput.OutputKeySettingFileToArrow();


        KeySettingScreen.PlayerKeyListener playerKeyListener = keySettingScreen.playerKeyListener;

        JButton jButtons = new JButton(btnText[2]);
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );


        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);

    }
}