package seoultech.se.tetris.GUI;


import seoultech.se.tetris.scoreData.dao.ItemScoreCsv;
import seoultech.se.tetris.scoreData.dao.NormalScoreCsv;
import seoultech.se.tetris.startScreen.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HighScoreScreen extends JFrame { // 스코어 보드
    JPanel pane1 = new JPanel(); // 화면
    JPanel pane2 = new JPanel(); // 화면
    JLabel title = new JLabel("HIGH SCORE PLAYER"); // 제목
    JLabel t = new JLabel(); // 분류
    JLabel myScore;
    JButton btn1 = new JButton("HOME"); // 뒤로 가기
    JButton btn2 = new JButton("아이템 모드"); // item 모드로
    JButton btn3 = new JButton("일반 모드");
    JLabel text = new JLabel();
    NormalScoreCsv csv;
    ItemScoreCsv csv2;

    // 폰트 설정
    Font font = new Font("Pixel Emulator", Font.BOLD, 35); // 스코어 표시 폰트 설정
    Font font2 = new Font("Pixel Emulator", Font.PLAIN, 25); // 분류
    Font font3 = new Font("Pixel Emulator", Font.PLAIN, 20); // 점수
    Font font4 = new Font("Pixel Emulator", Font.BOLD, 35); // 내 점수

    // 그냥 스코어 보드 생성
    public HighScoreScreen(){
        super("전체 스코어 보드"); // 게임 실행시 이름
        this.csv = new NormalScoreCsv();
        this.csv2 = new ItemScoreCsv();

        // Frame 레이아웃
        setSize(600,700); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setResizable(false); // 창의 크기 변경 못함
        setContentPane(new ImagePanel());
        setLocationRelativeTo(null); //화면 중앙에 생성

        title.setFont(font);
        t.setFont(font2);
        t.setForeground(Color.WHITE); // 색깔

        // 타이틀
        title.setForeground(Color.RED);
        title.setBounds(70,40,500,50);
        add(title);

        // 버튼 추가
        btn1.setBounds(10,600,100,20);
        btn1.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
            public void actionPerformed(ActionEvent e){
                JButton btn1 = (JButton) e.getSource();
                if(btn1.getText().equals("HOME")) // 홉버튼을 눌렀을 때
                    setVisible(false);
                    StartScreen startScreen = new StartScreen();
            }
        });
        add(btn1);
        // 버튼 추가
        btn2.setBounds(450,600,100,20);
        btn2.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
            public void actionPerformed(ActionEvent e){
                JButton btn2 = (JButton) e.getSource();
                if(btn2.getText().equals("아이템 모드")){
                    pane1.setVisible(false);
                    btn2.setVisible(false);
                    pane2.setVisible(true);
                    btn3.setVisible(true);
                }

            }
        });
        add(btn2);
        // 버튼 추가
        btn3.setBounds(450,600,100,20);
        btn3.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
            public void actionPerformed(ActionEvent e){
                JButton btn3 = (JButton) e.getSource();
                if(btn3.getText().equals("일반 모드")){
                    pane2.setVisible(false);
                    btn3.setVisible(false);
                    pane1.setVisible(true);
                    btn2.setVisible(true);
                }

            }
        });
        add(btn3);
        //초기화
        btn3.setVisible(false);
        normalBoard();
        itemBoard();
        pane2.setVisible(false);

    }

    // 게임 종료 후 일반 모드
    public HighScoreScreen(NormalScoreCsv normal) throws Exception{
        super("스코어 보드"); // 게임 실행시 이름
        this.csv = normal;

        // Frame 레이아웃
        setSize(600,700); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setResizable(false); // 창의 크기 변경 못함
        setContentPane(new ImagePanel());
        setLocationRelativeTo(null); //화면 중앙에 생성

        title.setFont(font);
        t.setFont(font2);
        t.setForeground(Color.WHITE); // 색깔

        // 내 점수
        myScore = new JLabel("SCORE: "+csv.getScore().getN_score());
        myScore.setBounds(300,600,500,50);
        myScore.setFont(font4);
        myScore.setForeground(Color.ORANGE);

        // 타이틀
        title.setForeground(Color.RED);
        title.setBounds(70,40,500,50);
        add(title);

        // 스코어 판 레이아웃 설정
        pane1.setLayout(new GridLayout(0,4,2,0)); // 레이아웃 설정 - 열은 무조건 4열 행이 늘어나는 경우
        pane1.setBackground(new Color(0,0,0,150)); // 검은 배경
        pane1.setBounds(20,100,550,500); // 위치
        List<List<String>> records = csv.readCSVFile();

        // 분류
        t = new JLabel("RANK");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("SCORE");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("NAME");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.RIGHT);
        pane1.add(t);
        t = new JLabel("Lev");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.RIGHT);
        pane1.add(t);


        for(int i=0; i < records.size(); i++){
            // 글자 설정 - 번호
            text = new JLabel((i+1)+"");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            // 스코어 보드 하이라이트
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            //스코어
            text = new JLabel(records.get(i).get(1));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            // 스코어 보드 하이라이트
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            //이름
            text = new JLabel(records.get(i).get(0));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            // 스코어 보드 하이라이트
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            // 레벨
            text = new JLabel(records.get(i).get(2));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            // 스코어 보드 하이라이트
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);; // 난이도

        }


        // 없는 경우
        for(int i=records.size(); i < 10; i++){
            // 글자 설정 - 번호
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //스코어
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //이름
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);
            pane1.add(text);
        }

        // 버튼 추가
        btn1.setBounds(10,600,100,20);
        btn1.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
            public void actionPerformed(ActionEvent e){
                JButton btn1 = (JButton) e.getSource();
                if(btn1.getText().equals("HOME")) // 홉버튼을 눌렀을 때
                    setVisible(false);
                StartScreen startScreen = new StartScreen();
            }
        });
        add(btn1);


        add(pane1);
        add(title);
        add(myScore);

    }

    // 게임 종료 후 아이템 모드
    public HighScoreScreen(ItemScoreCsv item) throws Exception{
        super("스코어 보드"); // 게임 실행시 이름
        this.csv2 = item;

        // Frame 레이아웃
        setSize(600,700); // 전체 화면 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정
        setLayout(null); // 레이아웃 설정
        setResizable(false); // 창의 크기 변경 못함
        setContentPane(new ImagePanel());
        setLocationRelativeTo(null); //화면 중앙에 생성

        // 타이틀
        title.setForeground(Color.RED);
        title.setBounds(70,40,500,50);
        add(title);

        // 내 점수
        myScore = new JLabel("SCORE: "+csv2.getScore().getN_score());
        myScore.setBounds(300,600,500,50);
        myScore.setFont(font4);
        myScore.setForeground(Color.ORANGE);

        // 스코어 판 레이아웃 설정
        pane1.setLayout(new GridLayout(0,3,2,0)); // 레이아웃 설정 - 열은 무조건 4열 행이 늘어나는 경우
        pane1.setBackground(new Color(0,0,0,150)); // 검은 배경
        pane1.setBounds(20,100,550,500); // 위치
        List<List<String>> records = csv2.readCSVFile();

        // 분류
        t = new JLabel("RANK");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("SCORE");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("NAME");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.CENTER);
        pane1.add(t);


        for(int i=0; i < records.size(); i++){
            // 글자 설정 - 번호
            text = new JLabel((i+1)+"");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            if(csv2.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            //스코어
            text = new JLabel(records.get(i).get(1));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            //이름
            text = new JLabel(records.get(i).get(0));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
        }

        // 없는 경우
        for(int i=records.size(); i < 10; i++){
            // 글자 설정 - 번호
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //스코어
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //이름
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);
            pane1.add(text);
        }

        btn1.setBounds(10,600,100,20);
        btn1.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
            public void actionPerformed(ActionEvent e){
                JButton btn1 = (JButton) e.getSource();
                if(btn1.getText().equals("HOME")) // 홉버튼을 눌렀을 때
                    setVisible(false);
                StartScreen startScreen = new StartScreen();
            }
        });
        add(btn1);


        add(pane1);
        add(title);
        add(myScore);

    }

    // 스코어 보드 메뉴에서 클릭시 나올 부분
    public void normalBoard(){
        // 스코어 판 레이아웃 설정
        pane1.setLayout(new GridLayout(0,4,2,0)); // 레이아웃 설정 - 열은 무조건 4열 행이 늘어나는 경우
        pane1.setBackground(new Color(0,0,0,150)); // 검은 배경
        pane1.setBounds(20,100,550,500); // 위치
        List<List<String>> records = csv.readCSVFile();

        // 분류
        t = new JLabel("RANK");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("SCORE");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane1.add(t);
        t = new JLabel("NAME");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.RIGHT);
        pane1.add(t);
        t = new JLabel("Lev");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.RIGHT);
        pane1.add(t);


        for(int i=0; i < records.size(); i++){
            // 글자 설정 - 번호
            text = new JLabel((i+1)+"");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //스코어
            text = new JLabel(records.get(i).get(1));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //이름
            text = new JLabel(records.get(i).get(0));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            pane1.add(text);
            // 레벨
            text = new JLabel(records.get(i).get(2));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            pane1.add(text);; // 난이도

        }


        // 없는 경우
        for(int i=records.size(); i < 10; i++){
            // 글자 설정 - 번호
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //스코어
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane1.add(text);
            //이름
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            pane1.add(text);
            // 레벨
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.RIGHT);
            pane1.add(text);; // 난이도
        }

        add(pane1);
        pane1.setVisible(true);
        add(title);
    }

    // 스코어 보드 아이템 보드
    public void itemBoard(){
        // 스코어 판 레이아웃 설정
        pane2.setLayout(new GridLayout(0,3,2,0)); // 레이아웃 설정 - 열은 무조건 4열 행이 늘어나는 경우
        pane2.setBackground(new Color(0,0,0,150)); // 검은 배경
        pane2.setBounds(20,100,550,500); // 위치
        List<List<String>> records = csv2.readCSVFile();

        // 분류
        t = new JLabel("RANK");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane2.add(t);
        t = new JLabel("SCORE");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        pane2.add(t);
        t = new JLabel("NAME");
        t.setForeground(Color.WHITE);
        t.setFont(font2);
        t.setHorizontalAlignment(JLabel.CENTER);
        pane2.add(t);


        for(int i=0; i < records.size(); i++){
            // 글자 설정 - 번호
            text = new JLabel((i+1)+"");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            if(csv2.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane1.add(text);
            //스코어
            text = new JLabel(records.get(i).get(1));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane2.add(text);
            //이름
            text = new JLabel(records.get(i).get(0));
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);
            if(csv.getHighlight() == i){
                text.setOpaque(true); // 백그라운드 설정을 위해
                text.setBackground(new Color(255,255,0,200));
            }
            pane2.add(text);
        }

        // 없는 경우
        for(int i=records.size(); i < 10; i++){
            // 글자 설정 - 번호
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane2.add(text);
            //스코어
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            pane2.add(text);
            //이름
            text = new JLabel("---");
            text.setFont(font3);
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);
            pane2.add(text);
        }

        add(pane2);
        add(title);

    }
}


class ImagePanel extends JComponent { // 이미지 추가를 위한 클래스
    private Image image = new ImageIcon(HighScoreScreen.class.getResource("../image/score_background.png")).getImage();;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
