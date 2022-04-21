package seoultech.se.tetris.blocks;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    public FileInputOutput fileInputOutput = new FileInputOutput();
    public Color[] colors = fileInputOutput.InputColorFile();


    Block block = new Block();

    BlockTest() throws Exception {

    }

    @Test
    void getShape() {
        for (int i = 0; i < 2; i++) {
            int[] row = block.getShape()[i];
            int[] expected = {1, 1};
            assertArrayEquals(expected, row);
        }
    }

    @Test
    void getColor() {
        assertEquals(colors[0], block.getColor());
    }

    @Test
    void rotate() {
        for (int i = 0; i < 2; i++) {
            int[] row = block.getShape()[i];
            int[] expected = {1, 1};
            assertArrayEquals(expected, row);
        }
    }

    @Test
    void setShape() {
        int[][] rotate = {{1,1},{1,1}};
        int[][] rotateShape = block.rotate();
        block.setShape(rotate);
        for (int i = 0; i <2 ; i++)
        {
            int[] rotate1 = rotate[i];
            int[] rotateShape1 = rotateShape[i];
            assertArrayEquals(rotate1, rotateShape1);
        }
    }

    @Test
    void height() {
        assertEquals(2, block.height());
    }

    @Test
    void width() {
        assertEquals(2, block.width());
    }

    @Test
    void getX() {
        assertEquals(4,block.getX());
    }

    @Test
    void getY() {
        assertEquals(0, block.getY());
    }

    @Test
    void moveDown() {
        block.moveDown();
        assertEquals(1,block.getY());
    }

    @Test
    void moveLeft() {
        block.moveLeft();
        assertEquals(3, block.getX());
    }

    @Test
    void moveRight() {
        block.moveRight();
        assertEquals(5,block.getX());
    }

    @Test
    void getBottomEdge() {
        assertEquals(2, block.getBottomEdge());
    }

    @Test
    void getLeftEdge() {
        assertEquals(4, block.getLeftEdge());
    }

    @Test
    void getRightEdge() {
        assertEquals(6, block.getRightEdge());
    }
}