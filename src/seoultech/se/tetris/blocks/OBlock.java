package seoultech.se.tetris.blocks;

public class OBlock extends Block {

	public OBlock() throws Exception{
		shape = new int[][] { 
			{1, 1}, 
			{1, 1}
		};

		color = getColorFromFile.colors[4];
	}
}
