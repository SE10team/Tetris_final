package seoultech.se.tetris.GUI;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JComponent { // 이미지 추가를 위한 클래스
    private Image image = new ImageIcon(HighScoreScreen.class.getResource("../image/background.png")).getImage();;
    private Image changeImg;
    public ImagePanel(){
        changeImg = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    }

    public ImagePanel(int w, int h){
        changeImg = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(changeImg, 0, 0, this);
    }
}
