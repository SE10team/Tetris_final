package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameDifficultyScreenTest{

    JButton[] jButtons;
    FileInputOutput fileInputOutput = new FileInputOutput();
    GameDifficultyScreen gameDifficultyScreen = new GameDifficultyScreen();

    @Test
    void button_Easy() throws IOException, ClassNotFoundException {
        gameDifficultyScreen.fileInputOutput.OutputModeSetting(1);

        int setMode = fileInputOutput.InputModeFile();
        assertEquals(1, setMode);

        GameDifficultyScreen.PlayerKeyListener playerKeyListener = gameDifficultyScreen.playerKeyListener;

        KeyEvent keyEvent = new KeyEvent(jButtons[0],0,0,0,KeyEvent.VK_ENTER );

//        playerKeyListener.keyPressed();

    }

    @Test
    void button_Normal() throws IOException, ClassNotFoundException {
        gameDifficultyScreen.fileInputOutput.OutputModeSetting(2);

        int setMode = fileInputOutput.InputModeFile();
        assertEquals(2, setMode);

    }

    @Test
    void button_Hard() throws IOException, ClassNotFoundException {
        gameDifficultyScreen.fileInputOutput.OutputModeSetting(3);

        int setMode = fileInputOutput.InputModeFile();
        assertEquals(3, setMode);

    }




}