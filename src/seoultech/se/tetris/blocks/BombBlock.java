package seoultech.se.tetris.blocks;

import java.awt.*;
import seoultech.se.tetris.component.NextGenerateBlock;

public class BombBlock extends Block{
  public BombBlock() throws Exception{
    shape = new int[][] {
            {4}
    };
    color = Color.BLACK;

    thisBlock = 4; // 아이템 모드라는 의미인듯?
  }

}
