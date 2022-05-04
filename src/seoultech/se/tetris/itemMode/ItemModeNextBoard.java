package seoultech.se.tetris.itemMode;

import seoultech.se.tetris.blocks.Block;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;

public class ItemModeNextBoard extends JPanel { // 다음 블럭을 그리는 곳

    private int gridCellSize;
    private ItemModeNextGenerateBlock itemModeNextGenerateBlock;
    private Block nextOne;
    private int cellDivider;
    private Font font2; // 블록 글자

    public ItemModeNextBoard(ItemModeNextGenerateBlock itemModeNextGenerateBlock) throws Exception {

        FileInputOutput fileInputOutput = new FileInputOutput();
        int[] locationArr = fileInputOutput.InputScreenSizeFile();

        setBounds(locationArr[6],locationArr[7], 200,200);
        setBackground(Color.BLACK);
        setBorder(getBorder());
        setLayout(null);

        font2 = new Font("Pixel Emulator", Font.PLAIN, 20); // 폰트 설정

        this.itemModeNextGenerateBlock = itemModeNextGenerateBlock;
    }

    @Override
    public void paintComponent(Graphics g) { //컴포넌트 그리기
        super.paintComponent(g);

        updateBlock();
        placeBlock(g);
    }

    public void updateBlock(){
        nextOne = itemModeNextGenerateBlock.getNextblock();
        repaint();
    }

    private void placeBlock(Graphics g) { // 블럭 그리기

        Color color = nextOne.getColor();
        int[][] shape = nextOne.getShape();

        if(nextOne.width() ==4) cellDivider = 6;
        else if(nextOne.width() == 2) cellDivider =4;
        else cellDivider = 5;

        gridCellSize = getBounds().width / cellDivider;

        int wstart = (cellDivider - nextOne.width())/2;
        int hstart = (cellDivider - nextOne.height())/2;

        for (int row = 0; row < nextOne.height(); row++) {
            for (int col = 0; col < nextOne.width(); col++) {
                if (shape[row][col]==1) {
                    int x = (col+wstart) * gridCellSize;
                    int y = (row+hstart) * gridCellSize;

                    drawGridSquare(g, color, x, y);
                }
                else if(shape[row][col]==3){ // 2인 경우
                    int x = (col+wstart) * gridCellSize;
                    int y = (row+hstart) * gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawGridLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==4){ // 3인 경우 BombBlock;
                    int x = (col+wstart) * gridCellSize;
                    int y = (row+hstart) * gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawBombLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==5){ // 4인 경우 cLearBlock;
                    int x = (col+wstart) * gridCellSize;
                    int y = (row+hstart) * gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawClearLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else{
                    //empty
                }
            }
        }
    }

    private void drawGridSquare(Graphics g, Color color, int x , int y) { //블럭 그리기(painting)
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize); //블럭 그리고
        g.setColor(Color.BLACK);
        g.drawRect(x, y, gridCellSize, gridCellSize); // 테두리 그리기
    }

    // 글자를 입력해주기 위한 거
    private void drawGridLine(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("L",x,y);
    }

    private void drawBombLine(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.setFont(font2);
        g.drawString("B",x,y);
    }
    private void drawClearLine(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("C",x,y);
    }

}
