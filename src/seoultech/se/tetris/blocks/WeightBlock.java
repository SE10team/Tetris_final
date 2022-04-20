package seoultech.se.tetris.blocks;

import java.awt.*;

public class WeightBlock extends Block{

  public WeightBlock() throws Exception{
    shape = new int[][] {
      {0, 1, 1, 0},
      {1, 1, 1, 1}
    };

    color = Color.RED.darker();
  }
}
