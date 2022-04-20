package seoultech.se.tetris.settingScreen;

import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.settingScreen.SettingScreen;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeySettingScreen extends JFrame {

  JButton[] jButtons;
  PlayerKeyListener playerKeyListener;
  FileInputOutput fileInputOutput;

  public KeySettingScreen() {

    fileInputOutput = new FileInputOutput();
    playerKeyListener = new PlayerKeyListener(this);

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "W, A, S, D 키로 조작") {

              fileInputOutput.OutputKeySettingWithWASD();

        } else if (e.getActionCommand() == "화살표 방향키로 조작") {

              fileInputOutput.OutputKeySettingFileToArrow();

        } else if (e.getActionCommand() == "뒤로가기") {
              setVisible(false);
              try {
                SettingScreen settingScreen = new SettingScreen();
              } catch (Exception ex) {
                ex.printStackTrace();
              }
        }
      }
    };


    setTitle("조작키 설정 화면");
    setSize(400, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로
    jButtons = new JButton[3];

    String[] btnText = {"W, A, S, D 키로 조작", "화살표 방향키로 조작", "뒤로가기"};

    JLabel jLabel1 = new JLabel("W, A, S, D 키로 조작");
    Font font = new Font("Arial", Font.PLAIN, 15);
    jLabel1.setFont(font);
    jLabel1.setLayout(null);
    jLabel1.setBounds(125,140,150,20);
    add(jLabel1);

    jButtons[0] = new JButton(btnText[0]);
    jButtons[0].setBounds(125, 180, 150, 25);
    add( jButtons[0] );
    buttonAction(jButtons[0]);
    jButtons[0].addActionListener(buttonPressed);

    JLabel jLabel2 = new JLabel("화살표 방향키로 조작");
    jLabel2.setFont(font);
    jLabel2.setLayout(null);
    jLabel2.setBounds(125,220,150,20);
    add(jLabel2);

    jButtons[1] = new JButton(btnText[1]);
    jButtons[1].setBounds(125, 260, 150, 25);
    add( jButtons[1] );
    buttonAction(jButtons[1]);
    jButtons[1].addActionListener(buttonPressed);

    JLabel jLabel3 = new JLabel("뒤로가기");
    jLabel3.setFont(font);
    jLabel3.setLayout(null);
    jLabel3.setBounds(125,300,150,20);
    add(jLabel3);

    jButtons[2] = new JButton(btnText[2]);
    jButtons[2].setBounds(125, 340, 150, 25);
    add( jButtons[2] );
    buttonAction(jButtons[2]);
    jButtons[2].addActionListener(buttonPressed);


    setVisible(true);
  }

  public void buttonAction(JButton jButton) {
    Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>( jButton.getFocusTraversalKeys(
      KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS ) );
    set.add( KeyStroke.getKeyStroke( "UP" ) );
    jButton.setFocusTraversalKeys(
      KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set );

    Set<AWTKeyStroke> set2 = new HashSet<AWTKeyStroke>( jButton.getFocusTraversalKeys(
      KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS ) );
    set2.add( KeyStroke.getKeyStroke( "DOWN" ) );
    jButton.setFocusTraversalKeys(
      KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set2 );

    jButton.addKeyListener(playerKeyListener);
  }

  public class PlayerKeyListener extends Component implements KeyListener {
    KeySettingScreen keySettingScreen;
    PlayerKeyListener(KeySettingScreen keySettingScreen) {
      this.keySettingScreen = keySettingScreen;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == jButtons[0]) {

          fileInputOutput.OutputKeySettingWithWASD();

        } else if (e.getSource() == jButtons[1]) {

          fileInputOutput.OutputKeySettingFileToArrow();

        } else if (e.getSource() == jButtons[2]) {

          keySettingScreen.setVisible(false);
          try {
            SettingScreen settingScreen = new SettingScreen();
          } catch (Exception ex) {
            ex.printStackTrace();
          }

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
