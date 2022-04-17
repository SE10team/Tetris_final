package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class ZBlock extends Block {

	public ZBlock() {
		shape = new int[][] { 
			{1, 1, 0},
			{0, 1, 1}
		};
		color = colorSetting.getZblock();
	}
}
