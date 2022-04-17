package seoultech.se.tetris.blocks;

import seoultech.se.tetris.blocks.colorSetting.ColorSetting;

import java.awt.*;

public class OBlock extends Block {

	public OBlock() {
		shape = new int[][] { 
			{1, 1}, 
			{1, 1}
		};
		color = colorSetting.getOblock();
	}
}
