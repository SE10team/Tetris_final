package seoultech.se.tetris.GUI;

import javax.swing.*;
import java.awt.*;


public class TimeInputScreen extends JFrame{
    public static void main(String args[]){
        TimeInputScreen timeInputScreen = new TimeInputScreen();
        timeInputScreen.setVisible(true);
    }
    public TimeInputScreen() {
        super("시간 제한 대전 모드의 시간을 정한다"); // 게임 실행시 이름
        // Frame 레이아웃
        setSize(500, 500); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setResizable(false); // 창의 크기 변경 못함
        setContentPane(new ImagePanel());
        setLocationRelativeTo(null); //화면 중앙에 생성

        String[] time = {"1","2","3","4","5"};
        JComboBox strCombo= new JComboBox(time);
        strCombo.setSize(500,100);
        strCombo.setLocation(100,100);
        add(strCombo);


    }
    class ImagePanel extends JComponent { // 이미지 추가를 위한 클래스
        private Image image = new ImageIcon(HighScoreScreen.class.getResource("../image/timeImage.jpg")).getImage();;
        Image changeImg = image.getScaledInstance(500,500, Image.SCALE_SMOOTH);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(changeImg, 0, 0, this);
        }
}


}
