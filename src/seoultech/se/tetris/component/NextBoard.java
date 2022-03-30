package seoultech.se.tetris.component;

import seoultech.se.tetris.blocks.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NextBoard extends JPanel { // 다음 블럭 생성하는 것
    public NextBoard(){
        setBounds(550,400, 200,200);
        setBackground(Color.ORANGE);
        setBackground(Color.CYAN);
    }

    private Block nextblock;

    public Block currblock() { return nextblock; }

    public void getNextblock() { nextblock = getRandomBlock();  } // 필요 있나?

    public Block getRandomBlock() {
        Random rnd = new Random(System.currentTimeMillis());
        int block = rnd.nextInt(7);
        return switch (block) {
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
