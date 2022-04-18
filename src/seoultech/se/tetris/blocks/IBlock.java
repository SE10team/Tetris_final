package seoultech.se.tetris.blocks;

public class IBlock extends Block {

	public IBlock() throws Exception{
		shape = new int[][] { 
			{1, 1, 1, 1}
		};

		color = getColorFromFile.colors[1];
	}
}
