package seoultech.se.tetris.blocks;

import java.awt.*;

public class OneBlock extends Block{

  public OneBlock() throws Exception{
    shape = new int[][] {
      {1}
    };

    color = Color.PINK;

    thisBlock = 2;
  }
}
