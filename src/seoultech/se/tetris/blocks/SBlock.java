package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class SBlock extends Block {

	public SBlock() {
		shape = new int[][] { 
			{0, 1, 1},
			{1, 1, 0}
		};
		color = colorSetting.getSblock();
	}
}
