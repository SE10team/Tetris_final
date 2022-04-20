package seoultech.se.tetris.scoreData.model;

public class NormalScore extends Score{ // 기본 모드
    private int n_difficulty;

    //생성자
    public NormalScore(String name, int n_score, int n_difficulty) {
        super(name, n_score);
        this.n_difficulty = n_difficulty;
    }

    // Getter and setter

    public int getN_difficulty() {
        return n_difficulty;
    }

    public void setN_difficulty(int n_difficulty) {
        this.n_difficulty = n_difficulty;
    }
}
