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
        if ((countCompleteLines != 0) && (countCompleteLines % 1 == 0)) {
            int block = rnd.nextInt(4);
            currItemBlock = block;
            countCompleteLines = 0;
            return
                    switch (block) {
                        case 0 -> new LineBlock();
                        case 1 -> new WeightBlock();
                        case 2 -> new ClearBlock();
                        case 3 -> new OneBlock();
                        default -> new BombBlock();
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
//        int block = rnd.nextInt(5);
//        return
//          switch (block) {
//              case 0 -> new JBlock();
//              case 1 -> new OneBlock();
//              default -> new WeightBlock();
//          };
//        if ((countCompleteLines != 0) && (countCompleteLines % 2 == 0)) {
//            int block = rnd.nextInt(2);
//            currItemBlock = block;
//            countCompleteLines = 0;
//            return
//              switch (block) {
//                  case 0 -> new OneBlock();
//                  default -> new WeightBlock();
//              };
////        } else {
////            int block = rnd.nextInt(7);
////            return
////              switch (block) {
////                  case 0 -> new IBlock();
////                  case 1 -> new JBlock();
////                  case 2 -> new LBlock();
////                  case 3 -> new ZBlock();
////                  case 4 -> new SBlock();
////                  case 5 -> new TBlock();
////                  default -> new OBlock();
////              };
////        }
//        int block = rnd.nextInt(6); // 아이템모드
//        return
//                switch (block) {
//                    case 0 -> new WeightBlock();
//                    case 1 -> new BombBlock();
//                    case 2 -> new ClearBlock();
//                    case 3 -> new OneBlock();
//                    case 4 -> new JBlock();
//                    default -> new LineBlock();
//
//                };
//    }

//        }
//    }