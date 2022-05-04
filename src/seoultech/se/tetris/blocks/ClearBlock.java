package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.NextGenerateBlock;

public class ClearBlock extends Block{

  public ClearBlock() throws Exception{
    NextGenerateBlock nextGenerateBlock = new NextGenerateBlock(); // 생성하고
    Block block = getRandomClearBlock(nextGenerateBlock.getRandomBlock()); // 랜덤으로 문자열 표시 할 부분
    shape = block.shape;
    color = block.color;

    thisBlock = 5; // 아이템 모드라는 의미인듯
  }

}
