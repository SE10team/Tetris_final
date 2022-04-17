package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class TBlock extends Block {

	public TBlock() {
		shape = new int[][] { 
			{0, 1, 0},
			{1, 1, 1}
		};
		color = colorSetting.getTblock();
	}
}
