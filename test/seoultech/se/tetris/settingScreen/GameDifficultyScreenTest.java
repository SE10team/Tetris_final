package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameDifficultyScreenTest{

    String[] btnText = {"Easy 모드", "Normal 모드", "Hard 모드", "뒤로가기"};


    FileInputOutput fileInputOutput = new FileInputOutput();
    GameDifficultyScreen gameDifficultyScreen = new GameDifficultyScreen();

//    @Test
//    void button_Easy() throws IOException, ClassNotFoundException {
//        gameDifficultyScreen.fileInputOutput.OutputModeSetting(1);
//
//        int setMode = fileInputOutput.InputModeFile();
//        assertEquals(1, setMode);
//
//        GameDifficultyScreen.PlayerKeyListener playerKeyListener = gameDifficultyScreen.playerKeyListener;
//
//        JButton jButtons = new JButton(btnText[0]);
//        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ENTER );
//
//
//        playerKeyListener.keyPressed(keyEvent);
//        playerKeyListener.keyReleased(keyEvent);
//
//
//
//    }
//
//    @Test
//    void button_Normal() throws IOException, ClassNotFoundException {
//        gameDifficultyScreen.fileInputOutput.OutputModeSetting(2);
//
//        int setMode = fileInputOutput.InputModeFile();
//        assertEquals(2, setMode);
//
//        GameDifficultyScreen.PlayerKeyListener playerKeyListener = gameDifficultyScreen.playerKeyListener;
//
//        JButton jButtons = new JButton("Normal 모드");
//        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,0,KeyEvent.VK_DOWN );
//
//        playerKeyListener.keyPressed(keyEvent);
//
//        playerKeyListener.keyReleased(keyEvent);
//
//    }
//
//    @Test
//    void button_Hard() throws IOException, ClassNotFoundException {
//        gameDifficultyScreen.fileInputOutput.OutputModeSetting(3);
//
//        int setMode = fileInputOutput.InputModeFile();
//        assertEquals(3, setMode);
//
//        GameDifficultyScreen.PlayerKeyListener playerKeyListener = gameDifficultyScreen.playerKeyListener;
//
//        JButton jButtons = new JButton("Hard 모드");
//        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,0,KeyEvent.VK_ENTER );
//
//        playerKeyListener.keyPressed(keyEvent);
//
//        playerKeyListener.keyReleased(keyEvent);
//
//    }




}