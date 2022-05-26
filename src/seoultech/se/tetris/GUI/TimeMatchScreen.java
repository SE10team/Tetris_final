package seoultech.se.tetris.GUI;

import org.w3c.dom.html.HTMLImageElement;
import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.component.NextGenerateBlock;
import seoultech.se.tetris.settingScreen.FileInputOutput;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TimeMatchScreen extends JFrame {

    private Pair boards;

    PlayerKeyListener playerKeyListener;

    public Board mainBoard1;
    public Board mainBoard2;
    public TimeBoard timeBoard;
    private static int startTime; // 시작 시간
    private static int endTime = 10; // 종료 시간
    public Timer timer; // 타이머
    public int sec = 0; // 현재 시간
    public int temp = 0;

    public static void main(String[] args) throws Exception {
        TimeMatchScreen tetris = new TimeMatchScreen();
        tetris.setVisible(true);

    }

    /*생성자*/
    public TimeMatchScreen() throws Exception {
        super("시간 제한 대전 모드 테트리스"); // 게임 실행시 이름

        FileInputOutput fileInputOutput = new FileInputOutput();
        int[] screenSizeArr = fileInputOutput.InputScreenSizeFile();

        setSize(1525, 1000); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setBackground(Color.WHITE);

        /*시간 표시 */
        timeBoard = new TimeBoard();
        /*타이머 표시*/
        timeBoard.setBounds(250,780,1000,150);
        add(timeBoard);

        /*타이머 시작 */
        timer = new Timer(1000, e -> {
            try {
                timeBoard.add(timeBoard.timeText); // 아이콘 표시
                this.sec = ((int) System.currentTimeMillis() / 1000) - startTime + this.temp;
                timeBoard.timeDisplay.setText(setTime(sec)); // 누적된 초를 시:분:초 로 출력
                timeBoard.add(timeBoard.timeDisplay); // 시간 표시

                /*시간 관련 멈춤*/
                if(sec > 170){ // 시간 얼마 안 남았을 때
                    timeBoard.timeDisplay.setForeground(Color.RED);
                    timeBoard.timeText.setForeground(Color.RED);

                }

                /*timeout*/
                if(sec==endTime){
                    timerOFF();
                    mainBoard1.timer.stop();
                    mainBoard2.timer.stop();
                    endDialog(mainBoard1.gameScore.getTotal_score(), mainBoard2.gameScore.getTotal_score());
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        timerOn(); //시작 시간 측정
        timer.start();

        GameScore score1 = new GameScore();
        ScoreBoard scoreBoard1 = new ScoreBoard(score1);
        NextGenerateBlock nextBlock1 = new NextGenerateBlock();
        NextBoard nextBoard1 = new NextBoard(nextBlock1);

        mainBoard1 = new Board(this, score1, scoreBoard1, nextBlock1, nextBoard1);

        mainBoard1.setBounds(50, 50, 350, 700);
        scoreBoard1.setBounds(450, 50, 200, 100);
        nextBoard1.setBounds(450, 200, 200, 200);
        add(mainBoard1);
        add(scoreBoard1);
        add(nextBoard1);

        GameScore score2 = new GameScore();
        ScoreBoard scoreBoard2 = new ScoreBoard(score2);
        NextGenerateBlock nextBlock2 = new NextGenerateBlock();
        NextBoard nextBoard2 = new NextBoard(nextBlock2);
        mainBoard2 = new Board(this, score2, scoreBoard2, nextBlock2, nextBoard2);

        mainBoard2.setBounds(800, 50, 350, 700);
        scoreBoard2.setBounds(1200, 50, 200, 100);
        nextBoard2.setBounds(1200, 200, 200, 200);
        add(mainBoard2);
        add(scoreBoard2);
        add(nextBoard2);

        WaitingBoard waitingBoard1 = new WaitingBoard(mainBoard2);
        waitingBoard1.setBounds(450, 500, 200, 200);
        WaitingBoard waitingBoard2 = new WaitingBoard(mainBoard1);
        waitingBoard2.setBounds(1200, 500, 200, 200);

        add(waitingBoard1);
        add(waitingBoard2);

        boards = new Pair(mainBoard1, mainBoard2);

        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();


    }

    public void sendWaitingLines(Board board) {

        board.getWaitingLines(boards.getOthers(board).tossBackground);
        boards.getOthers(board).clearWaitingLines();
    }


    public class PlayerKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(sec != endTime){
                // 오른쪽 보드
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    try {
                        if(!mainBoard2.isBlockOutOfBounds()) mainBoard2.moveBlockDown();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mainBoard2.moveBlockRight();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mainBoard2.moveBlockLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mainBoard2.rotateBlock();
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    try {
                        if(!mainBoard2.isBlockOutOfBounds()){
                            mainBoard2.dropBlock();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    mainBoard1.timer.stop();
                    mainBoard2.timer.stop();
                    timerOFF();
                    repaint();
                    mainBoard1.showPopup();
                    mainBoard2.timer.start();
                    mainBoard1.timer.start();
                    timerOn();
                    timer.start();
                }

                // 왼쪽 보드
                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    try {
                        if(!mainBoard1.isBlockOutOfBounds()) mainBoard1.moveBlockDown();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    mainBoard1.moveBlockRight();
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    mainBoard1.moveBlockLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    mainBoard1.rotateBlock();
                } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    try {
                        if(!mainBoard1.isBlockOutOfBounds()){
                            mainBoard1.dropBlock();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            }


        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public void timerOn(){
        // 타이머 켜기
        startTime = (int) System.currentTimeMillis() / 1000;
    }

    public void timerOFF(){
        // 타이머 끄기
        this.temp = ((int) System.currentTimeMillis() / 1000) - startTime;
        System.out.println(temp);
        this.timer.stop();
    }

    public static String setTime(int secs){
        int min, s;
        s = secs % 60;
        min = secs / 60 % 60;

        return String.format("%02d : %02d", min, s);
    }

    // 승자 가리기
    public void endDialog(int s1, int s2){
        int answer = 0;
        //승자구분
        if(s1 > s2){
            answer = JOptionPane.showConfirmDialog(this, "승자는 왼쪽 플레이어 입니다! 시작 화면으로 돌아가시려면 \"예\"버튼, 프로그램을 종료하시려면 \"아니오\"버튼을 눌러주세요.", "confirm", JOptionPane.YES_NO_OPTION);
        }
        else if(s2 > s1){
            answer = JOptionPane.showConfirmDialog(this, "승자는 오른쪽 플레이어 입니다! 시작 화면으로 돌아가시려면 \"예\"버튼, 프로그램을 종료하시려면 \"아니오\"버튼을 눌러주세요.", "confirm", JOptionPane.YES_NO_OPTION);
        }
        else{
            answer = JOptionPane.showConfirmDialog(this, "이런 동점이네요ㅠㅠ 시작 화면으로 돌아가시려면 \"예\"버튼, 프로그램을 종료하시려면 \"아니오\"버튼을 눌러주세요.", "confirm", JOptionPane.YES_NO_OPTION);
        }

        // 옵션 선택 처리
        if (answer == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            StartScreen startScreen = new StartScreen();
        } else {
            System.exit(0);
        }
    }
}
