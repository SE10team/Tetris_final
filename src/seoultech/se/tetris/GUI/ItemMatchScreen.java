package seoultech.se.tetris.GUI;

import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.itemMode.ItemModeBoard;
import seoultech.se.tetris.itemMode.ItemModeNextBoard;
import seoultech.se.tetris.itemMode.ItemModeNextGenerateBlock;
import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class ItemPair {
  ItemModeBoard first;
  ItemModeBoard second;

  public ItemPair(ItemModeBoard first, ItemModeBoard second) {
    this.first = first;
    this.second = second;
  }

//    public Board getFirst() {
//        return first;
//    }
//
//    public Board getSecond() {
//        return second;
//    }

  public ItemModeBoard getOthers(ItemModeBoard board) {
    if (board == first)
      return second;
    else
      return first;
  }
}

public class ItemMatchScreen extends JFrame {

  private ItemPair boards;
  PlayerKeyListener playerKeyListener;
  public ItemModeBoard mainBoard1;
  public ItemModeBoard mainBoard2;
//  ItemScoreCsv scoreCsv; 그냥 GameScore()를 써도 될 것 같아용! 어차피 점수는 보여주기 용이니까?

  public static void main(String[] args) throws Exception {
    ItemMatchScreen tetris = new ItemMatchScreen();
    tetris.setVisible(true);

  }

  public ItemMatchScreen() throws Exception {
    super("아이템 대전 모드 테트리스"); // 게임 실행시 이름

    FileInputOutput fileInputOutput = new FileInputOutput();
    int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();

    setSize(1525, 1000); // 전체 화면 크기
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
    setLayout(null); // 레이아웃 설정
    setBackground(Color.WHITE);


    GameScore score1 = new GameScore();
    ScoreBoard scoreBoard1 = new ScoreBoard(score1);
    ItemModeNextGenerateBlock nextBlock1 = new ItemModeNextGenerateBlock();
    ItemModeNextBoard nextBoard1 = new ItemModeNextBoard(nextBlock1);
//    playScreen = new ItemModePlayScreen();
    mainBoard1 = new ItemModeBoard(this, score1, scoreBoard1, nextBlock1, nextBoard1);

    mainBoard1.setBounds(50, 50, 350, 700);
    scoreBoard1.setBounds(450, 50, 200, 100);
    nextBoard1.setBounds(450, 200, 200, 200);
    add(mainBoard1);
    add(scoreBoard1);
    add(nextBoard1);

    GameScore score2 = new GameScore();
    ScoreBoard scoreBoard2 = new ScoreBoard(score2);
    ItemModeNextGenerateBlock nextBlock2 = new ItemModeNextGenerateBlock();
    ItemModeNextBoard nextBoard2 = new ItemModeNextBoard(nextBlock2);
    mainBoard2 = new ItemModeBoard(this, score2, scoreBoard2, nextBlock2, nextBoard2);

    mainBoard2.setBounds(800, 50, 350, 700);
    scoreBoard2.setBounds(1200, 50, 200, 100);
    nextBoard2.setBounds(1200, 200, 200, 200);
    add(mainBoard2);
    add(scoreBoard2);
    add(nextBoard2);

    WaitingBoard waitingBoard1 = new WaitingBoard(mainBoard2);
    waitingBoard1.setBounds(450, 500, 200, 200);
    WaitingBoard waitingBoard2 = new WaitingBoard(mainBoard1);
    waitingBoard2.setBounds(1200, 500, 200, 200);

    add(waitingBoard1);
    add(waitingBoard2);

    boards = new ItemPair(mainBoard1, mainBoard2);

    playerKeyListener = new PlayerKeyListener();
    addKeyListener(playerKeyListener);
    setFocusable(true);
    requestFocus();
  }

  public void sendWaitingLines(ItemModeBoard board) {

    board.getWaitingLines(boards.getOthers(board).tossBackground);
    boards.getOthers(board).clearWaitingLines();
  }

  public int escPopUp() {
    String[] strings = {"시작 메뉴로", "프로그램 종료", "취소"};
    int input = JOptionPane.showOptionDialog(this, "게임을 중단하시겠습니까? 시작메뉴로 돌아가시려면 \"시작메뉴로\" 버튼을, 게임을 완전히 종료시키시려면 \"프로그램 종료\" 버튼을, 다시 게임을 재개하시려면 \"취소\" 버튼을 눌러주세요.", "confirm", 0, 0, null, strings, strings[2]);
    if (input == 0) {
      setVisible(false);
      StartScreen startScreen = new StartScreen();
    } else if (input == 1) {
      System.exit(0);
    } else {
      repaint();
    }
    return input;
  }


  public class PlayerKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

      // 오른쪽 보드
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        try {
          if(!mainBoard2.isBlockOutOfBounds()) mainBoard2.moveBlockDown();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        mainBoard2.moveBlockRight();
      } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        mainBoard2.moveBlockLeft();
      } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        mainBoard2.rotateBlock();
      } else if (e.getKeyCode() == KeyEvent.VK_COMMA) {
        try {
          if(!mainBoard2.isBlockOutOfBounds()){
            mainBoard2.dropBlock();
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        mainBoard1.timer.stop();
        mainBoard2.timer.stop();
        repaint();
        int input = escPopUp();
        if (input == 1 || input == 2) {
          mainBoard2.timer.start();
          mainBoard1.timer.start();
          mainBoard1.timer.start();
          mainBoard2.timer.start();
        } else {
          mainBoard2.timer.stop();
          mainBoard1.timer.stop();
        }
      }


      // 왼쪽 보드
      else if (e.getKeyCode() == KeyEvent.VK_S) {
        try {
          if(!mainBoard1.isBlockOutOfBounds()) mainBoard1.moveBlockDown();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else if (e.getKeyCode() == KeyEvent.VK_D) {
        mainBoard1.moveBlockRight();
      } else if (e.getKeyCode() == KeyEvent.VK_A) {
        mainBoard1.moveBlockLeft();
      } else if (e.getKeyCode() == KeyEvent.VK_W) {
        mainBoard1.rotateBlock();
      } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
        try {
          if(!mainBoard1.isBlockOutOfBounds()){
            mainBoard1.dropBlock();
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
  }
}
