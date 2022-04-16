package seoultech.se.tetris.startScreen;

import seoultech.se.tetris.component.Board;
import seoultech.se.tetris.main.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StartScreenMenu extends JPanel{

  StartScreen startScreen;
  private PlayerKeyListener playerKeyListener;
  JButton[] buttons;

  public StartScreenMenu(StartScreen startScreen) {
    this.startScreen = startScreen;
    playerKeyListener = new PlayerKeyListener();

    String[] btnText = {"일반 모드 게임 시작", "아이템 모드 게임 시작", "게임 설정", "스코어 보드", "게임 종료"};
    buttons = new JButton[5];

    for (int i = 0; i < 5; i++) {
      buttons[i] = new JButton(btnText[i]);
      add( buttons[i] );
      Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>( buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS ) );
      set.add( KeyStroke.getKeyStroke( "UP" ) );
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set );
      buttons[i].addKeyListener(playerKeyListener);
    }

    InputMap im = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    String rightText = "DOWN";
    im.put(KeyStroke.getKeyStroke(rightText), rightText);
    getActionMap().put(rightText, new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
      }
    });
  }

  public class PlayerKeyListener implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == buttons[0]) {
          startScreen.setVisible(false);
          Tetris tetris = new Tetris();
          tetris.setVisible(true);
        } else if (e.getSource() == buttons[1]) {
          startScreen.setVisible(false);
          Tetris tetris = new Tetris();
          tetris.setVisible(true);
        } else if (e.getSource() == buttons[2]) {
          startScreen.setVisible(false);
          Tetris tetris = new Tetris();
          tetris.setVisible(true);
        } else if (e.getSource() == buttons[3]) {
          startScreen.setVisible(false);
          Tetris tetris = new Tetris();
          tetris.setVisible(true);
        } else if (e.getSource() == buttons[4]) {
          System.exit(0);
        }

      } else {
        System.out.println("");
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
  }
}
