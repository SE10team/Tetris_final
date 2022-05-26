package seoultech.se.tetris.component.Board;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.PlayScreen;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.blocks.Block;
import seoultech.se.tetris.blocks.IBlock;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.settingScreen.KeySettingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    PlayScreen playScreen = new PlayScreen();
    GameScore gameScore = new GameScore();
    ScoreBoard scoreBoard = new ScoreBoard(gameScore);
    NextGenerateBlock nextGenerateBlock = new NextGenerateBlock();
    NextBoard nextBoard = new NextBoard(nextGenerateBlock);
    NormalScoreCsv normalScoreCsv = new NormalScoreCsv();

    Board mainBoard = new Board(playScreen, gameScore, scoreBoard, nextGenerateBlock, nextBoard, normalScoreCsv);

    Block curr = new Block();
    Graphics g;

    FileInputOutput fileInputOutput = new FileInputOutput();
    int[] keySettingArr;


    BoardTest() throws Exception {
    }

    @Test
    void paintComponent() {
        mainBoard.paintComponent(g);
    }


    @Test
    void clearLine() {
        mainBoard.clearLine(19);
    }



    @Test
    void clearEvent() {
        mainBoard.clearEvent(19);
    }

    @Test
    void shiftDown() {
        mainBoard.shiftDown(19);
    }

    @Test
    void setInterval() {
        mainBoard.completeLines = 10;
        mainBoard.levelLines = 7;
        mainBoard.setInterval();
    }

    @Test
    void moveBlockToBackground() {
        mainBoard.moveBlockToBackground();
    }


    @Test
    void drawGridSquare() {
        mainBoard.drawGridSquare(g, Color.WHITE, 5,15);
    }

    @Test
    void spawnBlock() throws Exception {
        mainBoard.spawnBlock();
    }

    @Test
    void makeGameOverbackground() {
        mainBoard.background[8][5] = Color.BLUE;
        mainBoard.makeGameOverbackground();
    }

    @Test
    void isBlockOutOfBounds() {
        mainBoard.isBlockOutOfBounds();
    }


    @Test
    void moveBlockRight() {
        mainBoard.background[2][4] = Color.BLUE;
        mainBoard.moveBlockRight();
    }

    @Test
    void moveBlockLeft() {
        mainBoard.background[2][4] = Color.BLUE;
        mainBoard.moveBlockLeft();
    }

    @Test
    void rotateBlock() {
        mainBoard.rotateBlock();
    }

    @Test
    void checkRotate() throws Exception {
        curr = new IBlock();

        mainBoard.checkRotate(curr.getShape());
    }

    @Test
    void checkBottom() {
        mainBoard.checkBottom();
    }

    @Test
    void checkLeft() {
        mainBoard.checkLeft();
    }

    @Test
    void checkRight() {
        mainBoard.checkRight();
    }

//    @Test
//    void showPopup() {
//        mainBoard.showPopup();
//    }

    @Test
    void key_0() throws IOException, ClassNotFoundException {
        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;

        keySettingArr = fileInputOutput.InputKeyFile();

        JButton jButtons = new JButton(String.valueOf(keySettingArr[0]));
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[0]);

        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);
    }


    @Test
    void key_1() throws IOException, ClassNotFoundException {
        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;

        keySettingArr = fileInputOutput.InputKeyFile();

        JButton jButtons = new JButton(String.valueOf(keySettingArr[1]));
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[1]);

        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);
    }

    @Test
    void key_2() throws IOException, ClassNotFoundException {
        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;

        keySettingArr = fileInputOutput.InputKeyFile();

        JButton jButtons = new JButton(String.valueOf(keySettingArr[2]));
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[2]);

        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);
    }

    @Test
    void key_Enter() throws IOException, ClassNotFoundException {
        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;

        keySettingArr = fileInputOutput.InputKeyFile();

        JButton jButtons = new JButton(String.valueOf(KeyEvent.VK_SPACE));
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_SPACE);

        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);
    }

//    @Test
//    void key_ESCAPE() throws IOException, ClassNotFoundException {
//        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;
//
//        keySettingArr = fileInputOutput.InputKeyFile();
//
//        JButton jButtons = new JButton(String.valueOf(KeyEvent.VK_ESCAPE));
//        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ESCAPE);
//
//        playerKeyListener.keyPressed(keyEvent);
//        playerKeyListener.keyReleased(keyEvent);
//    }

    @Test
    void key_3() throws IOException, ClassNotFoundException {
        Board.PlayerKeyListener playerKeyListener = (Board.PlayerKeyListener) mainBoard.playerKeyListener;

        keySettingArr = fileInputOutput.InputKeyFile();

        JButton jButtons = new JButton(String.valueOf(keySettingArr[3]));
        KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[3]);

        playerKeyListener.keyPressed(keyEvent);
        playerKeyListener.keyReleased(keyEvent);
    }


}