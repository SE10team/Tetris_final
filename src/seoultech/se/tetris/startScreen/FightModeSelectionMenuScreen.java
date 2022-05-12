package seoultech.se.tetris.startScreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class FightModeSelectionMenuScreen extends JPanel {

  FightModeSelectionScreen screen;
  private PlayerKeyListener playerKeyListener;
  JButton[] buttons;

  public FightModeSelectionMenuScreen(FightModeSelectionScreen screen) {
    this.screen = screen;
    playerKeyListener = new PlayerKeyListener();

    String[] btnText = {"일반 대전 모드", "아이템 대전 모드", "시간제한 대전 모드", "뒤로가기"};
    buttons = new JButton[btnText.length];

    for (int i = 0; i < btnText.length; i++) {
      buttons[i] = new JButton(btnText[i]);
      add( buttons[i] );

      Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>( buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS ) );
      set.add( KeyStroke.getKeyStroke( "UP" ) );
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set );

      Set<AWTKeyStroke> set2 = new HashSet<AWTKeyStroke>( buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS ) );
      set2.add( KeyStroke.getKeyStroke( "DOWN" ) );
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set2 );

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

        } else if (e.getSource() == buttons[1]) {

        } else if (e.getSource() == buttons[2]) {

        } else if (e.getSource() == buttons[3]) {
          screen.setVisible(false);
          StartScreen startScreen = new StartScreen();
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
