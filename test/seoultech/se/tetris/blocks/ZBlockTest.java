package seoultech.se.tetris.blocks;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ZBlockTest {

    public FileInputOutput fileInputOutput = new FileInputOutput();
    public Color[] colors = fileInputOutput.InputColorFile();

    ZBlock block = new ZBlock();

    ZBlockTest() throws Exception {
    }

    @Test
    void getShape() {
        for (int i = 0; i < 2; i++) {
            int[] row = block.getShape()[i];
            int[][] expected = {{1, 1, 0}, {0, 1, 1}};
            assertArrayEquals(expected[i], row);
        }
    }

    @Test
    void getColor() {
        assertEquals(colors[0], block.getColor());
    }

}