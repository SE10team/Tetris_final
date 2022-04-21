package seoultech.se.tetris.component.Board;

import seoultech.se.tetris.GUI.NextBoard;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;

public class HardBoard extends Board {

    public HardBoard(GameScore gameScore, ScoreBoard scoreBoard, NextGenerateBlock nextGBlock, NextBoard nextBoard) throws Exception {
        super(gameScore, scoreBoard, nextGBlock, nextBoard);
        System.out.println("Hard");
    }

    protected void setInterval() {
        if (completeLines >= levelLines) {
            initInterval -= 120;
            levelLines += pluslevelLines;
            pluslevelLines += 2;
            timer.setDelay(initInterval);
            gameScore.setPlus(3);
            System.out.println("Delay : " + timer.getDelay());
        }
    }

    public void spawnBlock() throws Exception{ // 새로운 블럭 스폰
        curr = nextBlock.getNextblock(); // 새로운 블럭 스폰
        nextBlock.generateHardBlock();
        nextBoard.updateBlock();
    }

    public void clearLines() throws InterruptedException {
        boolean lineFilled;
        int completeRows =0;

        for (int row = HEIGHT -1; row >=0; row--){

            lineFilled = true;

            for(int col = 0; col < WIDTH; col++)
            {
                if(background[row][col] ==null)
                {
                    lineFilled = false;
                    break;
                }
            }

            if(lineFilled)
            {

                clearEvent(row);
                this.paint(this.getGraphics());
                Thread.sleep(150);
                clearLine(row);
                shiftDown(row);
                clearLine(0);
                row++;

                //스코어 증가
                gameScore.hardLine();
                completeLines++;
                completeRows++;
                repaint();
                setInterval();
            }
        }

        if (completeRows >=2) gameScore.multiHardLine(completeRows);
    }
}
