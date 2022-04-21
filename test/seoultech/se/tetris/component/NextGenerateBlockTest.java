package seoultech.se.tetris.component;

import org.junit.jupiter.api.*;
import seoultech.se.tetris.blocks.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class NextGenerateBlockTest {
    Block block = new Block();
    NextGenerateBlock nextBlock = new NextGenerateBlock();

    int count = 0;
    int count1 = 0;
    int count2 = 0;

    NextGenerateBlockTest() throws Exception {
    }

    @Test
    void getNextblock(){
        assertNotNull(nextBlock.getNextblock());
    }



    @Test
    void generateBlock() throws Exception {
        nextBlock.generateBlock();
        assertNotNull(nextBlock);
    }

    @Test //Easy
    void generateEasyBlock() throws Exception {
        nextBlock.generateEasyBlock();
        assertNotNull(nextBlock);
    }

    @Test //Hard
    void generateHardBlock() throws Exception {
        nextBlock.generateHardBlock();
        assertNotNull(nextBlock);
    }

    @Test
    void getRandomBlock() throws Exception {
        int i = 0;
        while(i < 1000){
            block = nextBlock.getRandomBlock();
            if(block.getShape().length ==1) count++;
            i++;
        }

        float test = count;
        assertEquals(14.3, test/10, 5);
    }

    @Test
    @Order(1)
    void getEasyRandomBlock() throws Exception {
        int i = 0;
        while(i < 1000){
            block = nextBlock.getEasyRandomBlock();
                if(block.getShape().length ==1) count1++;
            i++;
        }

        float test = count1;
        assertEquals(16.7, test/10, 5);
    }

    @Test
    @Order(2)
    void getHardRandomBlock() throws Exception {
        int i = 0;
        while(i < 1000){
            block = nextBlock.getHardRandomBlock();
            if(block.getShape().length ==1) count2++;

            i++;
        }

        float test = count2;
        assertEquals(11.8, test/10, 5);

    }
}