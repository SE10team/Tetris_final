package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class IBlock extends Block {

	public IBlock() {
		shape = new int[][] { 
			{1, 1, 1, 1}
		};
		color = colorSetting.getIblock();
	}
}
