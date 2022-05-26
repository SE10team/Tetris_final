package seoultech.se.tetris.component.Board;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.PlayScreen;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;

import static org.junit.jupiter.api.Assertions.*;

class HardBoardTest {
    PlayScreen playScreen = new PlayScreen();
    GameScore gameScore = new GameScore();
    ScoreBoard scoreBoard = new ScoreBoard(gameScore);
    NextGenerateBlock nextGenerateBlock = new NextGenerateBlock();
    NextBoard nextBoard = new NextBoard(nextGenerateBlock);
    NormalScoreCsv normalScoreCsv = new NormalScoreCsv();

    HardBoard mainBoard = new HardBoard(playScreen, gameScore, scoreBoard, nextGenerateBlock, nextBoard, normalScoreCsv);

    HardBoardTest() throws Exception {
    }


    @Test
    void setInterval() {
        mainBoard.completeLines = 10;
        mainBoard.levelLines = 7;
        mainBoard.setInterval();
    }

    @Test
    void spawnBlock() throws Exception {
        mainBoard.spawnBlock();
    }

//    @Test
//    void clearLines() throws InterruptedException {
//        mainBoard.clearLines();
//    }

}