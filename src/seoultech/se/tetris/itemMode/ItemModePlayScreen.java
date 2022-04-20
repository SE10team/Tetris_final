package seoultech.se.tetris.itemMode;

import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.component.*;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;

import static seoultech.se.tetris.itemMode.ItemModeBoard.completeLines;


public class ItemModePlayScreen extends JFrame { // 게임 화면을 그리는 곳

	private ItemModeBoard mainBoard;

	public ItemModePlayScreen() throws Exception {
		super("아이템 모드 테트리스"); // 게임 실행시 이름

		FileInputOutput fileInputOutput = new FileInputOutput();
		int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();
		setSize(screenSizeArr[0],screenSizeArr[1]); // 전체 화면 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
		setLayout(null); // 레이아웃 설정
		setBackground(Color.WHITE);


		GameScore score = new GameScore();
		ScoreBoard scoreBoard = new ScoreBoard(score);

		ItemModeNextGenerateBlock itemModeNextGenerateBlock = new ItemModeNextGenerateBlock();
		ItemModeNextBoard itemModeNextBoard = new ItemModeNextBoard(itemModeNextGenerateBlock);
		mainBoard = new ItemModeBoard(score, scoreBoard, itemModeNextGenerateBlock, itemModeNextBoard);



		add(mainBoard);
		add(scoreBoard);
		add(itemModeNextBoard);


	}


}