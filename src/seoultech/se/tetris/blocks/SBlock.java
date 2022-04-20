package seoultech.se.tetris.blocks;

public class SBlock extends Block {

	public SBlock() throws Exception{
		shape = new int[][] { 
			{0, 1, 1},
			{1, 1, 0}
		};

		color = colors[5];
	}
}
