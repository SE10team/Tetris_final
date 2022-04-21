package seoultech.se.tetris.blocks;

import org.junit.jupiter.api.Test;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class OneBlockTest {

    public FileInputOutput fileInputOutput = new FileInputOutput();
    public Color[] colors = fileInputOutput.InputColorFile();

    OneBlock block = new OneBlock();

    OneBlockTest() throws Exception {
    }

    @Test
    void getShape() {
        int[] row = block.getShape()[0];
        int[] expected = {1};
        assertArrayEquals(expected, row);
    }

    @Test
    void getColor() {
        assertEquals(Color.PINK, block.getColor());
    }

}