package seoultech.se.tetris.blocks;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LBlockTest {
    public FileInputOutput fileInputOutput = new FileInputOutput();
    public Color[] colors = fileInputOutput.InputColorFile();

    LBlock block = new LBlock();

    LBlockTest() throws Exception {
    }

    @Test
    void getShape() {
        for (int i = 0; i < 2; i++) {
            int[] row = block.getShape()[i];
            int[][] expected = {{1, 1, 1}, {1, 0, 0}};
            assertArrayEquals(expected[i], row);
        }
    }

    @Test
    void getColor() {
        assertEquals(colors[3], block.getColor());
    }

}