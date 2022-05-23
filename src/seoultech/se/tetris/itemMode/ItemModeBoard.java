package seoultech.se.tetris.itemMode;

import seoultech.se.tetris.GUI.HighScoreScreen;
import seoultech.se.tetris.GUI.MatchScreen;
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
import java.util.Arrays;

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

    // 대전모드 용
    public ItemModeBoard(MatchScreen matchScreen, GameScore gameScore, ScoreBoard scoreBoard, ItemModeNextGenerateBlock itemModeNextGenerateBlock, ItemModeNextBoard nextBoard, ItemScoreCsv itemScoreCsv) throws Exception
    {
        super();

        this.gameScore = gameScore;
        this.scoreBoard = scoreBoard;
        this.itemScoreCsv = itemScoreCsv;
        this.matchScreen = matchScreen;
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

        // 배열 초기화
        Arrays.fill(filledRows, false);

        //키 리스너
        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();


        fileInputOutput = new FileInputOutput();
        keySettingArr = fileInputOutput.InputKeyFile();
    }

    // 아이템모드 용
    public ItemModeBoard(ItemModePlayScreen itemPlayScreen, GameScore gameScore, ScoreBoard scoreBoard, ItemModeNextGenerateBlock itemModeNextGenerateBlock, ItemModeNextBoard nextBoard, ItemScoreCsv itemScoreCsv) throws Exception{
        super();

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

        // 배열 초기화
        Arrays.fill(filledRows, false);

        //키 리스너
        playerKeyListener = new PlayerKeyListener();
        addKeyListener(playerKeyListener);
        setFocusable(true);
        requestFocus();


        fileInputOutput = new FileInputOutput();
        keySettingArr = fileInputOutput.InputKeyFile();

    }

    /* One 블럭이 닿았을 때 처리 */
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

    /*WeightBlock이 닿았을 때 처리 */
    public void whenWeightBlockTouchingBottom() throws Exception {

        if(!checkBottom()){
            for (int x = curr.getTopEdge(); x < gridRows; x++) {
                for (int y = curr.getLeftEdge(); y < curr.getRightEdge(); y++) {
                    background[x][y] = null;
                }
                curr.moveDown();
                gameScore.playScore(); // 스코어 증가
                scoreBoard.updateScore(); // 점수 보여주기~
            }
            clearLines();
        }
//        curr.moveDown();
//        gameScore.playScore(); // 스코어 증가
//        scoreBoard.updateScore(); // 점수 보여주기~
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



//    public void clearLines() throws InterruptedException {
//        boolean lineFilled;
//        int completeRows =0;
//
//        for (int row = HEIGHT -1; row >=0; row--){
//
//            lineFilled = true;
//
//            for(int col = 0; col < WIDTH; col++)
//            {
//                if(background[row][col] ==null)
//                {
//                    lineFilled = false;
//                    break;
//                }
//            }
//
//            if(lineFilled) // 한 행 채워지면
//            {
//                clearEvent(row); // 삭제 Event 효과
//                this.paint(this.getGraphics());
//                Thread.sleep(100);
//                clearLine(row); // background Color를 Null로
//                shiftDown(row); // 행을 아래로
//                clearLine(0);
//                row++; // 행 확인
//
//
//                gameScore.line();
//                completeLines++;
//                countCompleteLines = completeLines;
//                completeRows++;
//                repaint();
//                setInterval();
//            }
//        }
//
//        if (completeRows >=2) gameScore.multiLine(completeRows);
//    }

//    /*clear처리*/
//    protected void clearLine(int row) { // 일반 clearLine
//        for(int i = 0; i < WIDTH; i++)
//        {
//            background[row][i] = null;
//        }
//    }


    protected void clearLine2(int col) throws InterruptedException { // Bomb Block, 한 열 없앰
        for(int i = 0; i < HEIGHT; i++) // 처리
        {
            background[i][col] = null;
        }
    }

    protected void clearLine3() { // Clear Block, 모든 블록 없앰

        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++)
            {
                background[j][i] = null;
            }
        }

    }

//    /*이벤트 효과*/
//    protected void clearEvent(int row) { // 삭제 이벤트 효과
//        for(int i = 0; i < WIDTH; i++)
//        {
//            background[row][i] = Color.LIGHT_GRAY;
//        }
//
//        System.out.println("ClearEvent");
//
//    }

    protected void shiftDown(int row) { // 행을 아래로
        for(int r = row; r >0; r--){
            for (int col = 0; col < WIDTH; col++)
            {
                background[r][col] = background[r-1][col];
            }
        }
    }

    protected void setInterval() {
        if (initInterval > 100) {
            if (completeLines >= levelLines) {
                initInterval -= 100;
                levelLines += pluslevelLines;
                pluslevelLines += 2;
                timer.setDelay(initInterval);
                gameScore.setPlus(2);
                System.out.println("Delay : " + timer.getDelay());
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
                if(shape[row][col]==1 || shape[row][col]==2 || shape[row][col]==3 || shape[row][col]==4 || shape[row][col]==5 )
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
                else if(shape[row][col]==2){ // 2인 경우
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    nextBoard.drawOne(g, x + (gridCellSize/3), y+ (gridCellSize - gridCellSize/3)); // 글자
                }
                else if(shape[row][col]==3){ // 2인 경우
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    nextBoard.drawGridLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==4){ // 3인 경우 BombBlock;
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    nextBoard.drawBombLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
                else if(shape[row][col]==5){ // 4인 경우 cLearBlock;
                    int x = (curr.getX() + col)*gridCellSize;
                    int y = (curr.getY() + row)*gridCellSize;

                    drawGridSquare(g, color, x, y);
                    nextBoard.drawClearLine(g, x + (gridCellSize/4), y+ (gridCellSize - gridCellSize/4));
                }
            }
        }
    }

    protected void drawBackground(Graphics g) { // background 그리기
        Color color; // 색칠해야 하는 부분

        for (int row = 0; row < HEIGHT; row++)
        {
            for (int col = 0; col < WIDTH; col++)
            {
                color = background[row][col];

                if (color != null)
                {
                    int x = col * gridCellSize; // 즉 열의 위치*cell 한 칸 크기
                    int y = row * gridCellSize; // 행의 위치*cell 한 칸 크기

                    drawGridSquare(g,color, x, y ); // 이건 바탕 검정 화면 그리는 거임
                }
            }
        }
    }

    protected void drawGridSquare(Graphics g, Color color, int x , int y) { //블럭 그리기(painting) - 색칠
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize); //블럭 그리고
        g.setColor(Color.BLACK);
        g.drawRect(x, y, gridCellSize, gridCellSize); // 테두리 그리기
    }


    public void spawnBlock() throws Exception{ // 새로운 블럭 스폰
        curr = itemModeNextGenerateBlock.getNextblock();
        itemModeNextGenerateBlock.generateBlock();
        nextBoard.updateBlock();
    }

    public void makeGameOverbackground(){ // 색을 background로 넘겨줘야 함!
        Color color;

        for (int row = 0; row < HEIGHT; row++)
        {
            for (int col = 0; col < WIDTH; col++)
            {
                color = background[row][col];

                if (color != null)
                    background[row][col] = Color.gray;
            }
        }
    }

    public boolean isBlockOutOfBounds(){

        for(int col = 0; col < WIDTH; col++)
        {
            if(background[2][col] != null) return true;
        }

        return false;
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

    // 이름을 사용자 입력에 대한 예외 처리
    public String inputDialog(){
        String name = JOptionPane.showInputDialog(this,"Congratulations! Enter your English name!"); // 입력 요구
        while(name == null || name.equals(name.toUpperCase())){ // null 값과 한글 입력의 경우
            name = JOptionPane.showInputDialog(this, "영어 이름 입력하라구요! 왜 말을 안 들어!", "이럴 줄 알았다", JOptionPane.WARNING_MESSAGE);
        }
        return name;
    }


    /*중요*/
    public void moveBlockDown() throws Exception { //블럭이 바닥일 때 처리
        int row = 0;
        int col = 0;
        if(!checkBottom()) {
            if(isBlockOutOfBounds()) // 맨 위에 닿으면 종료
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

            /*아이템 삭제 처리 */
            if(curr.getThisBlock()==1){ // 일반 블록 및 무게추
                whenWeightBlockTouchingBottom();
                curr = new NullBlock();
            } else if (curr.getThisBlock() == 2) { // OneBlock
                whenOneBlockTouchedBottom();
                curr = new NullBlock(); // OneBlock 없애주기
            }
            if(curr.getThisBlock()==3){ // LineBlock
                row = whenLineBlockTouchingBottom();
            }
            if(curr.getThisBlock()==4){ // BombBlock
                col = curr.getX();
                clearLine2(col); // 열 삭제
                curr = new NullBlock(); // BombBlock 없애주기
            }
            if(curr.getThisBlock()==5){ // ClearBlock
                clearLine3(); // 모두 삭제
                curr = new NullBlock(); // ClearBlock 없애주기
            }

            if(matchScreen != null)
                saveBackground(); //temp에 들어가고

            moveBlockToBackground(); // 데이터 보내기
            if(curr.getThisBlock()==3){ // LineBlock 자체도 백그라운드를 넘겨주는 시간이 필요
                clearLine(row);
//                clearEvent(row); 아이템 이벤트 추가
                shiftDown(row);
            }

            checkLineFilled(); // 채운 줄 확인하고 toss에 채운 줄 넣어주기
            spawnBlock(); // 블럭 옮겨주고
            clearLines(); // 채운 줄 없애주고
            if(matchScreen != null)
                matchScreen.sendWaitingLines(this);
            repaint();
        }
        curr.moveDown(); // 키보드 조종

        if (curr.getThisBlock() == 2) {
            background[curr.getY()][curr.getX()] = null;
            repaint();
        }
        gameScore.playScore(); // 스코어 증가
        scoreBoard.updateScore(); // 점수 보여주기~
        repaint();
    }

    public void checkLineFilled() throws InterruptedException {
        boolean lineFilled;
        int completeRows = 0;

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
                filledRows[row] = true;

                //스코어 증가
                gameScore.line();
                completeLines++;
                countCompleteLines = completeLines;
                completeRows++;
                repaint();
                setInterval();
            }
        }

        // 콤보 터졌을 때
        if (completeRows >=2){
            gameScore.multiLine(completeRows);
            waitingClearLines(completeRows);
        }
    }

    public void moveBlockRight() { // 오른쪽 이동
        if(isBlockOutOfBounds()) return;

        if(!checkRight()) return;
        curr.moveRight();
        repaint();
    }

    public void moveBlockLeft() { // 왼쪽 이동
        if(isBlockOutOfBounds()) return;
        if(!checkLeft()) return;
        curr.moveLeft();
        repaint();
    }

    public void dropBlock() throws Exception {
        while (checkBottom()) {
            moveBlockDown();
        }
        int row = 0;
        int col = 0;
        if(!checkBottom()) {
            if(isBlockOutOfBounds()) // 맨 위에 닿으면 종료
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

            /*아이템 삭제 처리 */
            if(curr.getThisBlock()==1){ // 일반 블록 및 무게추
                whenWeightBlockTouchingBottom();
                curr = new NullBlock();
            } else if (curr.getThisBlock() == 2) { // OneBlock
                whenOneBlockTouchedBottom();
                curr = new NullBlock(); // OneBlock 없애주기
            }
            if(curr.getThisBlock()==3){ // LineBlock
                row = whenLineBlockTouchingBottom();
            }
            if(curr.getThisBlock()==4){ // BombBlock
                col = curr.getX();
                clearLine2(col); // 열 삭제
                curr = new NullBlock(); // BombBlock 없애주기
            }
            if(curr.getThisBlock()==5){ // ClearBlock
                clearLine3(); // 모두 삭제
                curr = new NullBlock(); // ClearBlock 없애주기
            }

            if(matchScreen != null)
                saveBackground(); //temp에 들어가고

            moveBlockToBackground(); // 데이터 보내기
            if(curr.getThisBlock()==3){ // LineBlock 자체도 백그라운드를 넘겨주는 시간이 필요
                clearLine(row);
//                clearEvent(row); 아이템 이벤트 추가
                shiftDown(row);
            }

            checkLineFilled(); // 채운 줄 확인하고 toss에 채운 줄 넣어주기
            spawnBlock(); // 블럭 옮겨주고
            clearLines(); // 채운 줄 없애주고
            if(matchScreen != null)
                matchScreen.sendWaitingLines(this);
            repaint();
        }
        repaint();
    }

    public void rotateBlock() { // 블럭 회전
        if(!checkBottom())return;
        if(isBlockOutOfBounds()) return;
        if (checkRotate(curr.rotate())) curr.setShape(curr.rotate());
        if(!checkRight())
        {
            if(!checkLeft()) return;
        }
        repaint();

    }

    //rotate 자리에 !null 있는지 체크
    protected boolean checkRotate(int[][] shape) {

        int w = curr.width();
        int h = curr.height();

        for(int row =0; row < w; row++ )
        {
            for(int col = 0; col < h; col++)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX();
                    int y = row + curr.getY();
                    if(x < WIDTH && y<HEIGHT){
                        if(background[y][x] != null) return false;
                    }
                    else if(x >= WIDTH && checkLeft()) moveBlockLeft();
                    else return false;

                }
            }
        }

        return true;
    }

    //바닥 체크
    protected boolean checkBottom() {
        if (curr.getBottomEdge() == HEIGHT){
            return false; // 멈추는거
        }

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int col =0; col < w; col++ )
        {
            for(int row = h-1; row >= 0; row--)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX();
                    int y = row + curr.getY() +1;
                    if(background[y][x] != null) return false;
                }
            }
        }

        return true;
    }

    //왼쪽 체크
    protected boolean checkLeft() {
        if(curr.getLeftEdge() ==0) return false;

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int row =0; row < h; row++ )
        {
            for(int col = 0; col < w; col++)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX() -1 ;
                    int y = row + curr.getY();
                    if(background[y][x] != null) return false;
                }
            }
        }
        return true;
    }

    //오른쪽 체크
    protected boolean checkRight() {
        if(curr.getRightEdge() == WIDTH ) return false;

        int[][]shape = curr.getShape();
        int w = curr.width();
        int h = curr.height();

        for(int row =0; row < h; row++ )
        {
            for(int col = w-1; col >=0; col--)
            {
                if(shape[row][col] !=0)
                {
                    int x = col + curr.getX() +1 ;
                    int y = row + curr.getY();
                    if(background[y][x] != null) return false;
                }
            }
        }

        return true;
    }

    public void showPopup() {
        int input = JOptionPane.showConfirmDialog(this, "게임을 중단하시겠습니까? 중단될 경우, 게임의 데이터가 유실됩니다.", "confirm", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            repaint();
        }
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