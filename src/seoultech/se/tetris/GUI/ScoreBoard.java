package seoultech.se.tetris.GUI;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel { // Score 현황을 그리는 곳
    private int cur_score = 0;

    public ScoreBoard(){
        setBounds(550,100, 200,100);
        setBackground(Color.MAGENTA);
    }

    public void setScore(int score){
        TextField textField = new TextField(score);
        add(textField);
    }
}
