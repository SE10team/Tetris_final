package seoultech.se.tetris.settingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScreenSettingScreen extends JFrame{

  public ScreenSettingScreen() {

    FileInputOutput fileInputOutput = new FileInputOutput();

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

    JButton button800800 = new JButton(btnText[0]);
    button800800.setBounds(125, 180, 150, 20);
    add( button800800 );
    button800800.addActionListener(buttonPressed);

    JLabel jLabel2 = new JLabel("1000 X 1000");
    jLabel2.setFont(font);
    jLabel2.setLayout(null);
    jLabel2.setBounds(125,220,150,20);
    add(jLabel2);

    JButton button10001000 = new JButton(btnText[1]);
    button10001000.setBounds(125, 260, 150, 20);
    add( button10001000 );
    button10001000.addActionListener(buttonPressed);

    JLabel jLabel3 = new JLabel("1300 X 1000");
    jLabel3.setFont(font);
    jLabel3.setLayout(null);
    jLabel3.setBounds(125,300,150,20);
    add(jLabel3);

    JButton button12001200 = new JButton(btnText[2]);
    button12001200.setBounds(125, 340, 150, 20);
    add( button12001200 );
    button12001200.addActionListener(buttonPressed);

    JLabel jLabel4 = new JLabel("뒤로가기");
    jLabel4.setFont(font);
    jLabel4.setLayout(null);
    jLabel4.setBounds(125,380,150,20);
    add(jLabel4);

    JButton back = new JButton(btnText[3]);
    back.setBounds(125, 420, 150, 20);
    add( back );
    back.addActionListener(buttonPressed);


    setVisible(true);
  }
}
