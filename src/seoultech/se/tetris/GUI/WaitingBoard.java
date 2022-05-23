package seoultech.se.tetris.GUI;

import seoultech.se.tetris.blocks.Block;
import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class WaitingBoard extends JPanel {

    private int gridCellSize;
    private int cellDivider = 10;
    protected Board FromBoard;
    protected ArrayList<Color[]> tossBackground;

    public WaitingBoard(Board FromBoard) throws IOException, ClassNotFoundException {

        FileInputOutput fileInputOutput = new FileInputOutput();
        int[] locationArr = fileInputOutput.InputScreenSizeFile();

        setBounds(450,500, 200,200);
        setBackground(Color.BLACK);
        setBorder(getBorder());
        setLayout(null);

        this.FromBoard = FromBoard;
    }

    @Override
    public void paintComponent(Graphics g) { //컴포넌트 그리기
        super.paintComponent(g);

        updateTossBoard();
        placeWaitingBoard(g);
    }

    public void updateTossBoard(){
        tossBackground = FromBoard.tossBackground;
        repaint();
    }

    private void placeWaitingBoard(Graphics g) { // 블럭 그리기

        gridCellSize = getBounds().width / cellDivider;

        Color color;

        for(int row = tossBackground.size()-1 ; row >=0 ; row--)
        {
            for(int col =0 ; col < 10; col++ )
            {
                if (tossBackground.get(row)[col] != null)
                {
                    tossBackground.get(row)[col] = Color.gray;
                    color = tossBackground.get(row)[col];

                    int x = col * gridCellSize;
                    int y = (10 - tossBackground.size() + row) * gridCellSize;

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
