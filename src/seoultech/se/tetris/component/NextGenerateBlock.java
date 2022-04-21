package seoultech.se.tetris.component;

import seoultech.se.tetris.blocks.*;

import java.util.Random;

public class NextGenerateBlock extends Block {

    private Block nextblock;

    public NextGenerateBlock() throws Exception {
        nextblock = getRandomBlock();
    }

    public Block getNextblock() {
        return nextblock;
    }

    //normal
    public void generateBlock() throws Exception {
        nextblock = getRandomBlock();
        // 오차 범위 확인
    }

    //easy
    public void generateEasyBlock() throws Exception {
        nextblock = getEasyRandomBlock();
    }

    //hard
    public void generateHardBlock() throws Exception {
        nextblock = getHardRandomBlock();
    }


    public Block getRandomBlock() throws Exception {
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

    //EasyBoard에 사용
    public Block getEasyRandomBlock() throws Exception {
        Random rnd = new Random(System.currentTimeMillis());
        int block = rnd.nextInt(36);
        return
                switch ((int)block/5) {
                    case 0 -> new OBlock();
                    case 1 -> new JBlock();
                    case 2 -> new LBlock();
                    case 3 -> new ZBlock();
                    case 4 -> new SBlock();
                    case 5 -> new TBlock();
                    default -> new IBlock();
                };
    }

    public Block getHardRandomBlock() throws Exception {
        Random rnd = new Random(System.currentTimeMillis());
        int block = rnd.nextInt(34);
        return
                switch ((int)block/5) {
                    case 0 -> new OBlock();
                    case 1 -> new JBlock();
                    case 2 -> new LBlock();
                    case 3 -> new ZBlock();
                    case 4 -> new SBlock();
                    case 5 -> new TBlock();
                    default -> new IBlock();
                };
    }
}
