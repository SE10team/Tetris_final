package seoultech.se.tetris.blocks;

import seoultech.se.tetris.settingScreen.FileInputOutput;

import java.awt.*;

public class Block {
		
	protected int[][] shape;
	protected Color color;
	protected int x,y;
	private int WIDTH = 10;
	public FileInputOutput fileInputOutput = new FileInputOutput();
	public Color[] colors = fileInputOutput.InputColorFile();
	
	public Block() throws Exception {

		shape = new int[][]{
				{1, 1},
				{1, 1}
		};

		color = colors[0];

		x= (WIDTH - width()) / 2 ;
		y= 0;
	}

	
	public int[][] getShape() {
		return shape;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int[][] rotate() {
		int n = shape.length;
		int m = shape[0].length;
		int[][] rotate = new int[m][n];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = shape[n-1-j][i];
			}
		}

		return rotate;
	}

	public void setShape(int[][] rotate) {
		shape = rotate;
	}
	
	public int height() {
		return shape.length;
	}
	
	public int width() {
		if(shape.length > 0)
			return shape[0].length;
		return 0;
	}

	public int getX() {return x;} //위치 잡아주기

	public int getY() {return y;}

	public void moveDown() {y++;} // 이동 함수
	public void moveLeft() {x--;}
	public void moveRight() {x++;}

	public int getBottomEdge() { return y + height(); }

	public int getLeftEdge() {return x;}

	public int getRightEdge() {return x + width();}


}
