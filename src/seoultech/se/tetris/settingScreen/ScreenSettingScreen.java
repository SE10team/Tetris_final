package seoultech.se.tetris.settingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class ScreenSettingScreen extends JFrame{

  JButton button800800, button10001000, button13001000, back;
  PlayerKeyListener playerKeyListener;
  FileInputOutput fileInputOutput = new FileInputOutput();

  public ScreenSettingScreen() {

    FileInputOutput fileInputOutput = new FileInputOutput();
    playerKeyListener = new PlayerKeyListener(this);

    AbstractAction buttonPressed = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "800 X 800") {

          fileInputOutput.OutputScreenSize800800();

        } else if (e.getActionCommand() == "1000 X 1000") {

          fileInputOutput.OutputScreenSize10001000();

        } else if (e.getActionCommand() == "1300 X 1000") {

          fileInputOutput.OutputScreenSize13001000();

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


    setTitle("화면 크기 설정 화면");
    setSize(400, 600);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null);

    String[] btnText = {"800 X 800", "1000 X 1000", "1300 X 1000", "뒤로가기"};

    JLabel jLabel1 = new JLabel("800 X 800");
    Font font = new Font("Arial", Font.PLAIN, 15);
    jLabel1.setFont(font);
    jLabel1.setLayout(null);
    jLabel1.setBounds(125,140,150,20);
    add(jLabel1);

    button800800 = new JButton(btnText[0]);
    button800800.setBounds(125, 180, 150, 25);
    add( button800800 );
    button800800.addActionListener(buttonPressed);
    button800800.addKeyListener(playerKeyListener);
    buttonAction(button800800);

    JLabel jLabel2 = new JLabel("1000 X 1000");
    jLabel2.setFont(font);
    jLabel2.setLayout(null);
    jLabel2.setBounds(125,220,150,20);
    add(jLabel2);

    button10001000 = new JButton(btnText[1]);
    button10001000.setBounds(125, 260, 150, 25);
    add( button10001000 );
    button10001000.addActionListener(buttonPressed);
    button10001000.addKeyListener(playerKeyListener);
    buttonAction(button10001000);

    JLabel jLabel3 = new JLabel("1300 X 1000");
    jLabel3.setFont(font);
    jLabel3.setLayout(null);
    jLabel3.setBounds(125,300,150,20);
    add(jLabel3);

    button13001000 = new JButton(btnText[2]);
    button13001000.setBounds(125, 340, 150, 25);
    add( button13001000 );
    button13001000.addActionListener(buttonPressed);
    button13001000.addKeyListener(playerKeyListener);
    buttonAction(button13001000);

    JLabel jLabel4 = new JLabel("뒤로가기");
    jLabel4.setFont(font);
    jLabel4.setLayout(null);
    jLabel4.setBounds(125,380,150,20);
    add(jLabel4);

    back = new JButton(btnText[3]);
    back.setBounds(125, 420, 150, 25);
    add( back );
    back.addActionListener(buttonPressed);
    buttonAction(back);
    back.addKeyListener(playerKeyListener);


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
    ScreenSettingScreen screenSettingScreen;
    PlayerKeyListener(ScreenSettingScreen screenSettingScreen) {
      this.screenSettingScreen = screenSettingScreen;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        if (e.getSource() == button800800) {

          fileInputOutput.OutputScreenSize800800();

        } else if (e.getSource() == button10001000) {

          fileInputOutput.OutputScreenSize10001000();

        } else if (e.getSource() == button13001000) {

          fileInputOutput.OutputScreenSize13001000();

        } else if (e.getSource() == back) {

          screenSettingScreen.setVisible(false);
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
