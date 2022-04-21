package seoultech.se.tetris.GUI;


import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.Board.EasyBoard;
import seoultech.se.tetris.component.Board.HardBoard;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;


public class PlayScreen extends JFrame { // 게임 화면을 그리는 곳


	public static void main(String[] args) throws Exception {
		PlayScreen tetris = new PlayScreen();
		tetris.setVisible(true);

	}

	public PlayScreen() throws Exception {
		super("일반 모드 테트리스"); // 게임 실행시 이름

		FileInputOutput fileInputOutput = new FileInputOutput();
		int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();
		int setMode = fileInputOutput.InputModeFile();

		setSize(screenSizeArr[0],screenSizeArr[1]); // 전체 화면 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
		setLayout(null); // 레이아웃 설정
		setBackground(Color.WHITE);


		GameScore score = new GameScore();
		ScoreBoard scoreBoard = new ScoreBoard(score);

		NextGenerateBlock nextBlock = new NextGenerateBlock();
		NextBoard nextBoard = new NextBoard(nextBlock);

		switch (setMode){
			case 1 -> {
				EasyBoard mainBoard = new EasyBoard(score,scoreBoard,nextBlock,nextBoard, new NormalScoreCsv("Easy"));
				add(mainBoard);
			}

			case 2 -> {
				Board mainBoard = new Board(score,scoreBoard,nextBlock,nextBoard, new NormalScoreCsv("Normal"));
				add(mainBoard);
			}
			case 3 -> {
				HardBoard mainBoard = new HardBoard(score,scoreBoard,nextBlock,nextBoard, new NormalScoreCsv("Hard"));
				add(mainBoard);
			}
		}

		add(scoreBoard);
		add(nextBoard);


	}


}