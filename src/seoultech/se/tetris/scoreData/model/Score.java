package seoultech.se.tetris.scoreData.model;

import java.io.Serial;
import java.io.Serializable;

public class Score implements Serializable {
    @Serial
    private static final long serialVersionUID = -4122228911404380772L;
    // 이름, 점수
    private String name;
    private int n_score;

    //생성자 관련
    public Score(){
        //empty
    }

    public Score(String name, int n_score) {
        this.name = name;
        this.n_score = n_score;
    }

    // Getters and Setters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getN_score() {
        return n_score;
    }

    public void setN_score(int n_score) {
        this.n_score = n_score;
    }

}
