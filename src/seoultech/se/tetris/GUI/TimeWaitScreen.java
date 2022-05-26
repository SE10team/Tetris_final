package seoultech.se.tetris.GUI;


import seoultech.se.tetris.startScreen.FightModeSelectionMenuScreen;
import seoultech.se.tetris.startScreen.FightModeSelectionScreen;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;


public class TimeWaitScreen extends JFrame {
    TimeWaitScreen timeWaitScreen;
    JButton[] buttons;
    private PlayerKeyListener playerKeyListener = new PlayerKeyListener();
    public static void main(String args[]) {
        TimeWaitScreen timeWaitScreen = new TimeWaitScreen();
        timeWaitScreen.setVisible(true);
    }

    public TimeWaitScreen( ) {
        super("시간 제한 모드로 승부를 가리자"); // 게임 실행시 이름
        this.timeWaitScreen = this;

        // Frame 레이아웃
        setSize(500, 500); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setResizable(false); // 창의 크기 변경 못함
        setContentPane(new ImageBack());
        setLocationRelativeTo(null); //화면 중앙에 생성

        // 문구
        JLabel text = new JLabel("대 전 규 칙 "); // 분류
        JLabel text2 = new JLabel("3분 동안 싸울 준비가 되었다면 Start를 눌러라.");
        JLabel text3 = new JLabel("점수가 더 높거나 상대가 먼저 죽으면 승리한다.");
        JLabel text4 = new JLabel("쫄리면 뒤로가던지.");
        text.setFont(new Font("궁서체",Font.BOLD, 50));
        text2.setFont(new Font("궁서체",Font.BOLD, 20));
        text3.setFont(new Font("궁서체",Font.BOLD, 20));
        text4.setFont(new Font("궁서체",Font.BOLD, 20));
        text.setForeground(Color.RED); // 색깔
        text2.setForeground(Color.RED);
        text3.setForeground(Color.RED);
        text4.setForeground(Color.RED);
        text.setBounds(100,40,500,60);
        text2.setBounds(10,120,500,60);
        text3.setBounds(10,200,500,60);
        text4.setBounds(150,300,500,60);
        add(text);
        add(text2);
        add(text3);
        add(text4);

        String[] btnText = {"BACK", "START"};
        buttons = new JButton[btnText.length];

        for (int i = 0; i < btnText.length; i++) {
            buttons[i] = new JButton(btnText[i]);
            buttons[i].setUI(new StyledButtonUI());

            if(i == 0){
                buttons[i].setBounds(30, 400, 200, 40);
            }
            else{
                buttons[i].setBounds(250, 400, 200, 40);
            }

            buttons[i].setBackground(Color.WHITE);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setFont(new Font("Pixel Emulator",Font.BOLD, 20));
            add(buttons[i]);

            Set<AWTKeyStroke> set = new HashSet<AWTKeyStroke>(buttons[i].getFocusTraversalKeys(
                    KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
            set.add(KeyStroke.getKeyStroke("RIGHT"));
            buttons[i].setFocusTraversalKeys(
                    KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set);

            Set<AWTKeyStroke> set2 = new HashSet<AWTKeyStroke>(buttons[i].getFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
            set2.add(KeyStroke.getKeyStroke("LEFT"));
            buttons[i].setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set2);

            buttons[i].addKeyListener(playerKeyListener);
        }

        // 버튼 마우스 클릭 처리
        AbstractAction buttonPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "BACK") {
                    setVisible(false);
                    try {
                        FightModeSelectionScreen f = new FightModeSelectionScreen();
                        f.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getActionCommand() == "START") {
                    setVisible(false);
                    try {
                        TimeMatchScreen timeMatchScreen = new TimeMatchScreen();
                        timeMatchScreen.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        };

        for (int i = 0; i < btnText.length; i++) {
            buttons[i].addActionListener(buttonPressed);
        }

    }

    class ImageBack extends JComponent { // 이미지 추가를 위한 클래스
        private Image image = new ImageIcon(HighScoreScreen.class.getResource("../image/timeImage.jpg")).getImage();
        ;
        Image changeImg = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(changeImg, 0, 0, this);
        }
    }

    public class PlayerKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                timeWaitScreen.setVisible(false);
                if (e.getSource() == buttons[1]) {
                    try {
                        TimeMatchScreen timeMatchScreen = new TimeMatchScreen();
                        timeMatchScreen.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getSource() == buttons[0]) {
                    // 뒤로가기
                    try {
                        FightModeSelectionScreen f = new FightModeSelectionScreen();
                        f.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    //empty
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}

