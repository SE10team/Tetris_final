package seoultech.se.tetris.component;

import seoultech.se.tetris.GUI.ScoreBoard;

public class GameScore {
    /*field*/
    private int total_score; // 최종 점수
    private int plus; // 최종 가산 점수
    private int speed; // 속도가 증가함에 따라
    //private int state; // game state에 따라 점수가 자동으로 증가 되어야 함

    /*construct*/
    public GameScore() // 기본 생성자
    {
        this.total_score = 0; // 최종 점수
        this.plus = 1;
        this.speed = 0;
    }

    public GameScore(int total_score, int plus) { // Level이 올라가면 호출
        this.total_score = total_score;
        this.plus = plus;
        this.speed = 0;
    }

    public void playScore(){
        total_score += plus;
    } // 게임이 진행될 때 자동으로 추가되는 점수
    public void setPlus(int speed){ plus += speed; System.out.println("plus : " + plus);} // 속도가 올라감에 따라 plus를 증가하는 함수
    public void line(){total_score += 10;} // 한 행을 맞췄을 때
    public void multiLine(int line_num){ total_score += 10*line_num*line_num;} // 콤보 점수 - 한 번에 여러 해을 맞췄을 때
    public int getTotal_score() {
        return total_score;
    } // 최종 점수 반환

}