package seoultech.se.tetris.itemMode;

import seoultech.se.tetris.GUI.HighScoreScreen;
import seoultech.se.tetris.blocks.*;
import seoultech.se.tetris.component.Board.Board;
import seoultech.se.tetris.component.GameScore;
import seoultech.se.tetris.GUI.ScoreBoard;
import seoultech.se.tetris.scoreData.dao.ItemScoreCsv;
import seoultech.se.tetris.scoreData.model.ItemScore;
import seoultech.se.tetris.settingScreen.FileInputOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ItemModeBoard extends Board {

    private Font font;
    private Font font2; // 블록 글자
    // 다른 클래스
    private ItemModeNextGenerateBlock itemModeNextGenerateBlock;
    private ItemModeNextBoard nextBoard;

    int[] keySettingArr;

    private static int completeLines;
    public static int countCompleteLines = completeLines;
    private int gridRows;
    private ItemScoreCsv itemScoreCsv;
    private ItemModePlayScreen itemModePlayScreen;

    public ItemModeBoard(ItemModePlayScreen itemPlayScreen, GameScore gameScore, ScoreBoard scoreBoard, ItemModeNextGenerateBlock itemModeNextGenerateBlock, ItemModeNextBoard nextBoard, ItemScoreCsv itemScoreCsv) throws Exception{

        this.gameScore = gameScore;
        this.scoreBoard = scoreBoard;
        this.itemScoreCsv = itemScoreCsv;
        this.itemModePlayScreen = itemPlayScreen;
        fileInputOutput = new FileInputOutput();

        int[] locationArr = fileInputOutput.InputScreenSizeFile();

        //보드 설정
        setBounds(locationArr[2], locationArr[3], 350, 700);
        this.gameScore = gameScore;
        this.scoreBoard = scoreBoard;
        setBackground(Color.BLACK);

        gridCellSize = getBounds().width / WIDTH; //네모네모 크기 설정
        gridRows = this.getBounds().height / gridCellSize;

        /*컴포넌트 설정*/
        text = new JLabel("Game Over"); // 글자
        text.setBounds(100,300, 250,120);

        /*폰트 설정*/
        font = new Font("Pixel Emulator", Font.BOLD, 60); // 폰트 설정
        text.setForeground(Color.RED);
        text.setFont(font);
        text.setVisible(false);
        this.add(text); // 글자 표시

        font2 = new Font("Pixel Emulator", Font.PLAIN, 20); // 폰트 설정

        background = new Color[HEIGHT][WIDTH];
        WeightBlock weightBlock = new WeightBlock();

        //Set timer for block drops.
        timer = new Timer(initInterval, e -> {
            try {
                moveBlockDown();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        timer.start();
        this.itemModeNextGenerateBlock = itemModeNextGenerateBlock;
        this.nextBoard = nextBoard;
        spawnBlock();

        //키 리스너
        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();


        fileInputOutput = new FileInputOutput();
        keySettingArr = fileInputOutput.InputKeyFile();

    }

    public void whenOneBlockTouchedBottom() throws Exception {

        if(!checkBottom()){

            moveBlockToBackground();
            if (curr.getY() < 19) {
                background[curr.getY() + 1][curr.getX()] = null;
                background[curr.getY()][curr.getX()] = null;
                background[curr.getY() - 1][curr.getX()] = null;
                if (curr.getX() - 1 > 0) {
                    background[curr.getY()][curr.getX() - 1] = null;
                    background[curr.getY() + 1][curr.getX() - 1] = null;
                    background[curr.getY() - 1][curr.getX() - 1] = null;
                }
                if (curr.getX() + 1 < 10) {
                    background[curr.getY()][curr.getX() + 1] = null;
                    background[curr.getY() + 1][curr.getX() + 1] = null;
                    background[curr.getY() - 1][curr.getX() + 1] = null;
                }
            } else {
                background[curr.getY()][curr.getX()] = null;
                background[curr.getY() - 1][curr.getX()] = null;

                if (curr.getX() + 1 < 10) {
                    background[curr.getY()][curr.getX() + 1] = null;
                    background[curr.getY() - 1][curr.getX() + 1] = null;
                }
                if (curr.getX() - 1 > 0) {
                    background[curr.getY()][curr.getX() - 1] = null;
                    background[curr.getY() - 1][curr.getX() - 1] = null;
                }

            }

            gameScore.playScore();
            scoreBoard.updateScore();
        }
        repaint();

    }

    public void whenWeightBlockTouchingBottom() throws Exception {

        if(!checkBottom()){
            for (int x = curr.getBottomEdge(); x < gridRows; x++) {
                for (int y = curr.getLeftEdge(); y < curr.getRightEdge(); y++) {
                    background[x][y] = null;
                }
                curr.moveDown();
                gameScore.playScore(); // 스코어 증가
                scoreBoard.updateScore(); // 점수 보여주기~

            }
            clearLines();
        }
        repaint();
    }

    // Line Block touch Bottom
    public int whenLineBlockTouchingBottom() throws Exception {
        int thisRow = 0;

        if(!checkBottom()) { // 뭔가 부딪혔을 때
             moveBlockToBackground(); // 옮겨
            for (int row = 0; row < curr.height(); row++) {
                for (int col = 0; col < curr.width(); col++) {
                    if (curr.getShape()[row][col] == 3) { // 2인 경우
                        thisRow = curr.getY() + row;
                        return thisRow;
                    }
                }
            }
        }
        return 0;
    }



    public void clearLines() throws InterruptedException {
        boolean lineFilled;
        int completeRows =0;

        for (int row = HEIGHT -1; row >=0; row--){

            lineFilled = true;

            for(int col = 0; col < WIDTH; col++)
            {
                if(background[row][col] ==null)
                {
                    lineFilled = false;
                    break;
                }
            }

            if(lineFilled)
            {
                clearEvent(row);
                this.paint(this.getGraphics());
                Thread.sleep(100);
                clearLine(row);
                shiftDown(row);
                clearLine(0);
                row++;


                gameScore.line();
                completeLines++;
                countCompleteLines = completeLines;
                completeRows++;
                repaint();
                setInterval();
            }
        }

        if (completeRows >=2) gameScore.multiLine(completeRows);
    }
    private void clearLine2(int col) {
        for(int i = 0; i < HEIGHT; i++)
        {
            background[i][col] = null;
        }
    }
    private void clearLine3() {
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++)
            {
                background[j][i] = null;
            }
        }

    }
    protected void moveBlockToBackground(){ //블럭 background로 보내기
        int[][] shape = curr.getShape();
        int h = curr.height();
        int w = curr.width();

        int xPos = curr.getX();
        int yPos = curr.getY();

        Color color = curr.getColor();

        for (int row=0; row< h; row++)
        {
            for (int col = 0; col < w; col++)
            {
                if(shape[row][col]==1 || shape[row][col]==3 || shape[row][col]==4 || shape[row][col]==5 )
                {
                    background[row + yPos][col + xPos] = color; // 여기서 블럭 색깔을...
                }

            }
        }
    }


    /*그리기 담당*/
    protected void placeBlock(Graphics g) { // 블럭 그리기

        Color color = curr.getColor();
        int[][] shape = curr.getShape();

        for (int row = 0; row < curr.height(); row++) {
            for (int col = 0; col < curr.width(); col++) {
                if (shape[row][col]==1) { // 1인 겨우
                    int x = (curr.getX() + col) * gridCellSize;
                    int y = (curr.getY() + row) * gridCellSize;

                    drawGridSquare(g,color, x, y);
                }
                else if(shape[row][col]==3){ // 2인 경우
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawGridLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==4){ // 3인 경우 BombBlock;
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawBombLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==5){ // 4인 경우 cLearBlock;
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    drawClearLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
            }
        }
    }

    // 글자를 입력해주기 위한 거
    private void drawGridLine(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("L",x,y);
    }
    private void drawBombLine(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.setFont(font2);
        g.drawString("B",x,y);
    }
    private void drawClearLine(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("C",x,y);
    }

    public void spawnBlock() throws Exception{ // 새로운 블럭 스폰
        curr = itemModeNextGenerateBlock.getNextblock();
        itemModeNextGenerateBlock.generateBlock();
        nextBoard.updateBlock();
    }

    // 스코어 받고 저장하는 메소드
    public void gameOverScore(){
        int temp = gameScore.getTotal_score();
        if(itemScoreCsv.getRecords().isEmpty()){ // 비어 있으면
            // 이름 입력 및 예외 처리
            String name = inputDialog();
            ItemScore itemScore = new ItemScore(name,temp);

            this.itemScoreCsv = new ItemScoreCsv(itemScore);
            itemScoreCsv.finalScoreEmpty(); // 파일에 저장
        }
        else{
            int isRank = itemScoreCsv.isRank(temp);
            if(isRank != 11){
                //저장 가능하면
                String name = inputDialog();
                ItemScore itemScore = new ItemScore(name,temp);

                this.itemScoreCsv = new ItemScoreCsv(itemScore, isRank);
                itemScoreCsv.finalScoreNotEmpty(); // 파일에 저장
            }
            else{
                // 불가능하면
                String name = "";
                ItemScore itemScore = new ItemScore(name,temp);

                this.itemScoreCsv = new ItemScoreCsv(itemScore, isRank);
                itemScoreCsv.finalScoreNotEmpty(); // 파일에 저장
            }
        }
    }

    protected void moveBlockDown() throws Exception { //블럭 내리기
        int row = 0;
        int col = 0;
        if(!checkBottom()) {
            if(isBlockOutOfBounds())
            {
                timer.stop();
                repaint();
                System.out.println("Game Over");
                this.makeGameOverbackground(); // 종료
                text.setVisible(true);
                gameOverScore(); // 스코어 처리
                // 스코어 보드 화면 보여주기
                HighScoreScreen highScoreScreen = new HighScoreScreen(itemScoreCsv);
                highScoreScreen.setVisible(true);
                itemModePlayScreen.setVisible(false);
                return;
            }
            if(curr.getThisBlock()==1){
                whenWeightBlockTouchingBottom();
                curr = new NullBlock();
            } else if (curr.getThisBlock() == 2) {
                whenOneBlockTouchedBottom();
                curr = new NullBlock();
            }
            if(curr.getThisBlock()==3){
                row = whenLineBlockTouchingBottom();
            }
            if(curr.getThisBlock()==4){
                //moveBlockToBackground();
                col = curr.getX();
                clearLine2(col);
            }
            if(curr.getThisBlock()==5){
                moveBlockToBackground();
            }

            moveBlockToBackground();
            clearLines();
            if(curr.getThisBlock()==3){
                clearLine(row);
            }
            if(curr.getThisBlock()==5){
                clearLine3();
            }
            spawnBlock();
            clearLines();

            repaint();
        }
        curr.moveDown();

        if (curr.getThisBlock() == 2) {
            background[curr.getY()][curr.getX()] = null;
            repaint();
        }
        gameScore.playScore(); // 스코어 증가
        scoreBoard.updateScore(); // 점수 보여주기~
        repaint();
    }

    /* 사용자의 키보드 입력에 대한 메소드 */
    public class PlayerKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == keySettingArr[1]) {
                try {
                    moveBlockDown();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == keySettingArr[3]) {
                moveBlockRight();
            } else if (e.getKeyCode() == keySettingArr[2]) {
                moveBlockLeft();
            } else if (e.getKeyCode() == keySettingArr[0]) {
                rotateBlock();
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    dropBlock();
//                    moveBlockToBackground();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                timer.stop();
                repaint();
                showPopup();
                timer.start();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}