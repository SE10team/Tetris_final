package seoultech.se.tetris.blocks;

public class JBlock extends Block {

	public JBlock() throws Exception{
		shape = new int[][] { 
				{1, 1, 1},
				{0, 0, 1}
		};

		color = colors[2];
	}
}
