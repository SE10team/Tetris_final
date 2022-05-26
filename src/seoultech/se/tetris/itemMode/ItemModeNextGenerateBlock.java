package seoultech.se.tetris.itemMode;

import seoultech.se.tetris.blocks.*;
import seoultech.se.tetris.component.NextGenerateBlock;

import java.util.Random;

import static seoultech.se.tetris.itemMode.ItemModeBoard.countCompleteLines;

public class ItemModeNextGenerateBlock extends NextGenerateBlock {

    public static int currItemBlock;

    public ItemModeNextGenerateBlock() throws Exception {
        nextblock = getRandomBlock();
    }

    public Block getRandomBlock() throws Exception {

        currItemBlock = 3;

        Random rnd = new Random(System.currentTimeMillis());
        if ((countCompleteLines != 0) && (countCompleteLines % 10 == 0)) {
            int block = rnd.nextInt(5);
            currItemBlock = block;
            countCompleteLines = 0;
            return
                    switch (block) {
                        case 0 -> new WeightBlock();
                        case 1 -> new OneBlock();
                        case 2 -> new LineBlock();
                        case 3 -> new BombBlock();
                        default -> new ClearBlock();
                    };
        } else {
            int block = rnd.nextInt(7);
            return
                    switch (block) {
                        case 0 -> new IBlock();
                        case 1 -> new JBlock();
                        case 2 -> new LBlock();
                        case 3 -> new ZBlock();
                        case 4 -> new SBlock();
                        case 5 -> new TBlock();
                        default -> new OBlock();
                    };
        }
    }
}
