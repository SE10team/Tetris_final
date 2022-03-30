package seoultech.se.tetris.score;

public class GameScore {
    /*field*/
    private int total_score; // 최종 점수
    private int plus; // 기본으로 추가 되는 점수
    //private int state; // game state에 따라 점수가 자동으로 증가 되어야 함

    /*construct*/

    public GameScore() // 기본 생성자
    {
        total_score = 0; // 최종 점수
        plus = 5;
    }

    public GameScore(int total_score, int plus) { // Level이 올라가면 호출
        this.total_score = total_score;
        this.plus = plus;
    }

    /*method*/
    public void playScore(){
        total_score += 5; // 자동으로 추가
    } // 게임인 진행될 때 자동으로 추가되는 점수

    /*getter an setter*/

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }
}
