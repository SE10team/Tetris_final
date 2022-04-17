package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class LBlock extends Block {

	public LBlock() {
		shape = new int[][] { 
			{1, 1, 1},
			{1, 0, 0}  ///
		};
		color = colorSetting.getLblock();
	}
}
