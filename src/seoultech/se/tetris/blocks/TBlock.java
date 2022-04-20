package seoultech.se.tetris.blocks;

public class TBlock extends Block {

	public TBlock() throws Exception{
		shape = new int[][] { 
			{0, 1, 0},
			{1, 1, 1}
		};

		color = colors[6];
	}
}
