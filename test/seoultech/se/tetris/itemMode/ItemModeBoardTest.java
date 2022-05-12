//package seoultech.se.tetris.itemMode;
//
//import org.junit.jupiter.api.Test;
//import seoultech.se.tetris.GUI.NextBoard;
//import seoultech.se.tetris.GUI.PlayScreen;
//import seoultech.se.tetris.GUI.ScoreBoard;
//import seoultech.se.tetris.blocks.Block;
//import seoultech.se.tetris.component.Board.Board;
//import seoultech.se.tetris.component.GameScore;
//import seoultech.se.tetris.component.NextGenerateBlock;
//import seoultech.se.tetris.scoreData.dao.ItemScoreCsv;
//import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
//import seoultech.se.tetris.scoreData.model.Score;
//import seoultech.se.tetris.settingScreen.FileInputOutput;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ItemModeBoardTest {
//
//  ItemModePlayScreen itemModePlayScreen = new ItemModePlayScreen();
//  GameScore gameScore = new GameScore();
//  ScoreBoard scoreBoard = new ScoreBoard(gameScore);
//  ItemModeNextGenerateBlock nextGenerateBlock = new ItemModeNextGenerateBlock();
//  ItemModeNextBoard nextBoard = new ItemModeNextBoard(nextGenerateBlock);
//  ItemScoreCsv itemScoreCsv = new ItemScoreCsv();
//
//  ItemModeBoard board = new ItemModeBoard(itemModePlayScreen, gameScore, scoreBoard, nextGenerateBlock, nextBoard, itemScoreCsv);
//
//  Block curr = new Block();
//  Graphics g;
//
//  FileInputOutput fileInputOutput = new FileInputOutput();
//  int[] keySettingArr;
//  ItemModeBoardTest() throws Exception {
//  }
//
//
//  @Test
//  void whenOneBlockTouchedBottom() throws Exception {
//    board.whenOneBlockTouchedBottom();
//  }
//
//  @Test
//  void whenWeightBlockTouchingBottom() throws Exception {
//    board.whenWeightBlockTouchingBottom();
//  }
//
//  @Test
//  void whenLineBlockTouchingBottom() throws Exception {
//    board.whenLineBlockTouchingBottom();
//  }

//  @Test
//  void clearLines() throws InterruptedException {
//    board.clearLines();
//  }

//  @Test
//  void clearLine2() {
////    board.clearLine2(0);
//  }
//
//  @Test
//  void moveBlockToBackground() {
//    board.moveBlockToBackground();
//  }

//  @Test
//  void spawnBlock() throws Exception {
//    board.spawnBlock();
//  }
//
//  @Test
//  void gameOverScore() {
//    board.gameOverScore();
//  }

//  @Test
//  void moveBlockDown() throws Exception {
//    board.moveBlockDown();
//  }

//  @Test
//  void clearLine3() {
//    board.clearLine3();
//  }



//  @Test
//  void key_0() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(keySettingArr[0]));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[0]);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//
//
//  @Test
//  void key_1() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(keySettingArr[1]));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[1]);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//
//  @Test
//  void key_2() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(keySettingArr[2]));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[2]);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//
//  @Test
//  void key_Enter() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(KeyEvent.VK_SPACE));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_SPACE);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//
//  @Test
//  void key_ESCAPE() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(KeyEvent.VK_ESCAPE));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,KeyEvent.VK_ESCAPE);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//
//  @Test
//  void key_3() throws IOException, ClassNotFoundException {
//    ItemModeBoard.PlayerKeyListener playerKeyListener = (ItemModeBoard.PlayerKeyListener) board.playerKeyListener;
//
//    keySettingArr = fileInputOutput.InputKeyFile();
//
//    JButton jButtons = new JButton(String.valueOf(keySettingArr[3]));
//    KeyEvent keyEvent = new KeyEvent(jButtons,0,0,1,keySettingArr[3]);
//
//    playerKeyListener.keyPressed(keyEvent);
//    playerKeyListener.keyReleased(keyEvent);
//  }
//}