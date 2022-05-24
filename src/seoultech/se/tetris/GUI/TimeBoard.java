package seoultech.se.tetris.GUI;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TimeBoard extends JPanel { // Score 현황을 그리는 곳
    protected JLabel timeDisplay = new JLabel();
    protected JLabel timeText = new JLabel("Time");
    private Font font;

    public TimeBoard() throws IOException, ClassNotFoundException {

        FileInputOutput fileInputOutput = new FileInputOutput();
        int[] locationArr = fileInputOutput.InputScreenSizeFile();

        /*배경 설정*/
        setLayout(new FlowLayout(FlowLayout.LEFT, 80,0));

        /*폰트 설정*/
        font = new Font("Pixel Emulator", Font.BOLD, 100); // 스코어 표시 폰트 설정
        timeDisplay.setFont(font);
        timeDisplay.setForeground(Color.BLACK);
        font = new Font("Pixel Emulator", Font.BOLD, 80); // 스코어 표시 폰트 설정
        timeText.setFont(font);
        timeText.setForeground(Color.ORANGE);

    }


}
