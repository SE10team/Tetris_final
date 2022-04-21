package seoultech.se.tetris.settingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class GameDifficultyScreen extends JFrame {

  JButton[] jButtons;
  PlayerKeyListener playerKeyListener;
  FileInputOutput fileInputOutput;

  public GameDifficultyScreen() {

    fileInputOutput = new FileInputOutput();
    playerKeyListener = new PlayerKeyListener(this);

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Easy 모드") {
          fileInputOutput.OutputModeSetting(1);


        } else if (e.getActionCommand() == "Normal 모드") {
          fileInputOutput.OutputModeSetting(2);


        } else if (e.getActionCommand() == "Hard 모드") {
          fileInputOutput.OutputModeSetting(3);


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

    setTitle("게임 난이도 설정 화면");
    setSize(400, 630);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null); // 창 가운데로
    jButtons = new JButton[4];

    String[] btnText = {"Easy 모드", "Normal 모드", "Hard 모드", "뒤로가기"};

    JLabel jLabel1 = new JLabel("Easy 모드");
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

    JLabel jLabel2 = new JLabel("Normal 모드");
    jLabel2.setFont(font);
    jLabel2.setLayout(null);
    jLabel2.setBounds(125,220,150,20);
    add(jLabel2);

    jButtons[1] = new JButton(btnText[1]);
    jButtons[1].setBounds(125, 260, 150, 25);
    add( jButtons[1] );
    buttonAction(jButtons[1]);
    jButtons[1].addActionListener(buttonPressed);

    JLabel jLabel3 = new JLabel("Hard 모드");
    jLabel3.setFont(font);
    jLabel3.setLayout(null);
    jLabel3.setBounds(125,300,150,20);
    add(jLabel3);

    jButtons[2] = new JButton(btnText[2]);
    jButtons[2].setBounds(125, 340, 150, 25);
    add( jButtons[2] );
    buttonAction(jButtons[2]);
    jButtons[2].addActionListener(buttonPressed);

    JLabel jLabel4 = new JLabel("뒤로가기");
    jLabel4.setFont(font);
    jLabel4.setLayout(null);
    jLabel4.setBounds(125,380,150,20);
    add(jLabel4);

    jButtons[3] = new JButton(btnText[3]);
    jButtons[3].setBounds(125, 420, 150, 25);
    add( jButtons[3] );
    buttonAction(jButtons[3]);
    jButtons[3].addActionListener(buttonPressed);


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
    GameDifficultyScreen gameDifficultyScreen;
    PlayerKeyListener(GameDifficultyScreen gameDifficultyScreen) {
      this.gameDifficultyScreen = gameDifficultyScreen;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == jButtons[0]) {

          fileInputOutput.OutputModeSetting(1);

        } else if (e.getSource() == jButtons[1]) {

          fileInputOutput.OutputModeSetting(2);

        } else if (e.getSource() == jButtons[2]) {

          fileInputOutput.OutputModeSetting(3);

        } else if (e.getSource() == jButtons[3]) {

          gameDifficultyScreen.setVisible(false);
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
