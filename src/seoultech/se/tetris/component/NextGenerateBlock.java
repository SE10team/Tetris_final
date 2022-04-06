package seoultech.se.tetris.component;

import seoultech.se.tetris.blocks.*;

import java.util.Random;

public class NextGenerateBlock {

    private Block nextblock;




    public Block getRandomBlock() {
        Random rnd = new Random(System.currentTimeMillis());
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
