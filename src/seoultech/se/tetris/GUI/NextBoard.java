package seoultech.se.tetris.GUI;

import seoultech.se.tetris.blocks.*;
import seoultech.se.tetris.component.NextGenerateBlock;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NextBoard extends JPanel { // 다음 블럭을 그리는 곳

    private int gridCellSize;
    private NextGenerateBlock nextBlock;
    private Block nextOne;
    private int cellDivider;

    public NextBoard(NextGenerateBlock nextBlock){
        setBounds(550,400, 200,200);
        setBackground(Color.BLACK);
        setBorder(getBorder());
        setLayout(null);

        this.nextBlock = nextBlock;
    }

    @Override
    public void paintComponent(Graphics g) { //컴포넌트 그리기
        super.paintComponent(g);

        updateBlock();
        placeBlock(g);
    }

    public void updateBlock(){
        nextOne = nextBlock.getNextblock();
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
            }
        }
    }

    private void drawGridSquare(Graphics g, Color color, int x , int y) { //블럭 그리기(painting)
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize); //블럭 그리고
        g.setColor(Color.BLACK);
        g.drawRect(x, y, gridCellSize, gridCellSize); // 테두리 그리기
    }

}
