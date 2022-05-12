package seoultech.se.tetris.itemMode;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemModeNextBoardTest {
  ItemModeNextGenerateBlock nextGenerateBlock = new ItemModeNextGenerateBlock();
  ItemModeNextBoard nextBoard = new ItemModeNextBoard(nextGenerateBlock);
  Graphics graphics;

  ItemModeNextBoardTest() throws Exception {
  }

  @Test
  void paintComponent() {
  }

  @Test
  void placeBlock() {

  }


  @Test
  void updateBlock() {
    nextBoard.updateBlock();
  }
}