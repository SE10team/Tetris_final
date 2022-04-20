package seoultech.se.tetris.component;

import seoultech.se.tetris.blocks.*;

import java.util.Random;

public class ItemModeNextGenerateBlock {

    private Block nextblock;

    public ItemModeNextGenerateBlock() throws Exception {
        nextblock = getRandomBlock();
    }

    public Block getNextblock() {
        return nextblock;
    }

    public void generateBlock() throws Exception {
        nextblock = getRandomBlock();
    }


    public Block getRandomBlock() throws Exception {
        Random rnd = new Random(System.currentTimeMillis());
        int block = rnd.nextInt(2);
        return
                switch (block) {
                    case 0 -> new OneBlock();
                    default -> new WeightBlock();
                };
    }
}
