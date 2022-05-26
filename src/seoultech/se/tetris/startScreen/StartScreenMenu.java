package seoultech.se.tetris.startScreen;

import seoultech.se.tetris.GUI.HighScoreScreen;
import seoultech.se.tetris.GUI.PlayScreen;
import seoultech.se.tetris.GUI.StyledButtonUI;
import seoultech.se.tetris.itemMode.ItemModePlayScreen;
import seoultech.se.tetris.main.Tetris;
import seoultech.se.tetris.settingScreen.SettingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class StartScreenMenu extends JPanel {

  StartScreen startScreen;
  private PlayerKeyListener playerKeyListener;
  JButton[] buttons;

  public StartScreenMenu(StartScreen startScreen) {
    this.startScreen = startScreen;
    playerKeyListener = new PlayerKeyListener();

    String[] btnText = {"일반 모드 게임 시작", "아이템 모드 게임 시작", "대전모드 게임 시작", "게임 설정", "스코어 보드", "게임 종료"};
    buttons = new JButton[btnText.length];
    setLayout(new FlowLayout());

    for (int i = 0; i < 6; i++) {
      buttons[i] = new JButton(btnText[i]);
      buttons[i].setUI(new StyledButtonUI());
      buttons[i].requestFocus(); // 포커스 되도록
      buttons[i].setSize(180,30);
      buttons[i].setFont(new Font("나눔", Font.BOLD, 15));
      add(buttons[i]);

      Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>(buttons[i].getFocusTraversalKeys(
              KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
      set.add(KeyStroke.getKeyStroke("UP"));
      buttons[i].setFocusTraversalKeys(
              KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set);


      Set<AWTKeyStroke> set2 = new HashSet<AWTKeyStroke>(buttons[i].getFocusTraversalKeys(
              KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
      set2.add(KeyStroke.getKeyStroke("DOWN"));
      buttons[i].setFocusTraversalKeys(
              KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set2);

      buttons[i].addKeyListener(playerKeyListener);
    }
  }

  public class PlayerKeyListener extends Component implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == buttons[0]) {
          startScreen.setVisible(false);
          try {
            PlayScreen playScreen = new PlayScreen();
            playScreen.setVisible(true);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        } else if (e.getSource() == buttons[1]) {
          startScreen.setVisible(false);
          try {
            ItemModePlayScreen itemModePlayScreen = new ItemModePlayScreen();
            itemModePlayScreen.setVisible(true);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        } else if (e.getSource() == buttons[2]) {
          startScreen.setVisible(false);
          FightModeSelectionScreen screen = new FightModeSelectionScreen();
        } else if (e.getSource() == buttons[3]) {
          startScreen.setVisible(false);
          try {
            SettingScreen settingScreen = new SettingScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        } else if (e.getSource() == buttons[4]) {
          startScreen.setVisible(false);
          HighScoreScreen highScoreScreen = null; // Tetris -> PlayScreen으로
          try {
            highScoreScreen = new HighScoreScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          highScoreScreen.setVisible(true);
        } else if (e.getSource() == buttons[5]) {
          System.exit(0);
        }

      } else if (e.getKeyCode() != KeyEvent.VK_ENTER || e.getKeyCode() != KeyEvent.VK_DOWN || e.getKeyCode() != KeyEvent.VK_UP) {
        JOptionPane.showConfirmDialog(this, "엔터와 위아래 화살표를 눌러주세요", "confirm", JOptionPane.INFORMATION_MESSAGE);
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
  }
}
