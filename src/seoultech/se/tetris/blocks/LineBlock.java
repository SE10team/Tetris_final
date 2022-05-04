package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.NextGenerateBlock;

import java.awt.*;

public class LineBlock extends Block{
//  public static void main(String args[]) throws Exception {
//    LineBlock lineBlock = new LineBlock();
//    for (int row = 0; row < lineBlock.height(); row++) {
//      for (int col = 0; col < lineBlock.width(); col++) {
//        System.out.println(lineBlock.shape[row][col]);
//      }
//    }
//  }

  public LineBlock() throws Exception{
    NextGenerateBlock nextGenerateBlock = new NextGenerateBlock(); // 생성하고
    Block block = getRandomLineBlock(nextGenerateBlock.getRandomBlock()); // 랜덤으로 문자열 표시 할 부분
    shape = block.shape;
    color = block.color;

    thisBlock = 3; // 아이템 모드라는 의미인듯?
    System.out.println("생성됨");
  }

}
