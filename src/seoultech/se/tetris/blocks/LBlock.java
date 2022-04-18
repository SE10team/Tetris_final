package seoultech.se.tetris.blocks;

public class LBlock extends Block {

	public LBlock() throws Exception{
		shape = new int[][] { 
			{1, 1, 1},
			{1, 0, 0}  ///
		};

		color = getColorFromFile.colors[3];
	}
}
