package seoultech.se.tetris.GUI;

import seoultech.se.tetris.component.GameScore;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel { // Score 현황을 그리는 곳
    private JLabel scoreDisplay,text;
    private Font font,font2;
    private GameScore gameScore;

    public ScoreBoard(GameScore gameScore){
        this.gameScore = gameScore;

        /*배경 설정*/
        setLayout(new GridLayout(2,1));
        setBounds(580,100, 200,100);

        /*컴포넌트 설정*/
        scoreDisplay = new JLabel(); // 점수 보여주는 객체
        text = new JLabel("Score"); // 그냥 글자

        /*폰트 설정*/
        font = new Font("Roboto", Font.BOLD, 30); // 스코어 표시 폰트 설정
        scoreDisplay.setFont(font);
        scoreDisplay.setForeground(Color.BLACK);
        font2 = new Font("Roboto", Font.BOLD, 40); // Score Text 표시 폰트 설저
        text.setFont(font2);
        text.setForeground(Color.RED);

        /*화면에 add*/
        this.add(text); // Score 표시
        this.add(scoreDisplay); // 점수 표시


    }

    public void updateScore(){
        String total = Integer.toString(gameScore.getTotal_score());
        scoreDisplay.setText(total);
    }
}