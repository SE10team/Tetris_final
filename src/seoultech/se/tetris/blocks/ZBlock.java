package seoultech.se.tetris.blocks;

public class ZBlock extends Block {

	public ZBlock() throws Exception{
		shape = new int[][] { 
			{1, 1, 0},
			{0, 1, 1}
		};

		color = colors[0];
	}
}
