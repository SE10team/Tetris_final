package seoultech.se.tetris.settingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class SettingScreenMenu extends JPanel {

  JButton[] buttons;

  public SettingScreenMenu() {

    String[] btnText = {"게임 화면 크기 조절", "게임 조작 키 설정", "스코어 보드 기록 초기화", "색맹 모드", "설정 초기화"};
    buttons = new JButton[5];

    for (int i = 0; i < 5; i++) {
      buttons[i] = new JButton(btnText[i]);
      add(buttons[i]);
      Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>(buttons[i].getFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
      set.add(KeyStroke.getKeyStroke("UP"));
      buttons[i].setFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set);
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
}
