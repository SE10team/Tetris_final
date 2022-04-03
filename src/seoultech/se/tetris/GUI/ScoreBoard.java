package seoultech.se.tetris.GUI;

import seoultech.se.tetris.component.GameScore;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel { // Score 현황을 그리는 곳
    private JLabel scoreDisplay;
    private Font font;
    private GameScore gameScore;

    public ScoreBoard(GameScore gameScore){
        this.gameScore = gameScore;

        scoreDisplay = new JLabel(); // 점수 표시
        font = new Font("Roboto", Font.BOLD, 30); // 폰트 설정

        /*배경 설정*/
        setBounds(550,100, 200,100);
        setBackground(Color.MAGENTA);

    }

    public void updateScore(){
        scoreDisplay.setText("Score: "+ gameScore.getTotal_score());
    }
}