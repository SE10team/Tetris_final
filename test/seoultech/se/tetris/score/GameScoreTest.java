package seoultech.se.tetris.score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameScoreTest {

    @Test
    public void play() {
        GameScore gameScore = new GameScore();
        for(int i=0; i < 10; i++){
            gameScore.playScore();
        }
        assertEquals(gameScore.getTotal_score(),50);
    }
}