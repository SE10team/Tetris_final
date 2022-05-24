package seoultech.se.tetris.scoreData.dao;

import seoultech.se.tetris.scoreData.model.NormalScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NormalScoreCsv extends ScoreCsv{
    // 파일 경로
    private File f = new File("C:\\Users\\USER\\OneDrive - 서울과학기술대학교\\Tetris_final\\src\\seoultech\\se\\tetris\\scoreData\\resource\\NormalScoreResult.csv");
    private NormalScore score;
    private List<List<String>> records;
    private String level;
    private int highlight;
    // 생성자
    public NormalScoreCsv(){
        super.setFile(f);
        this.records = this.readCSVFile();
    }

    public NormalScoreCsv(String level){
        super.setFile(f);
        this.records = this.readCSVFile();
        this.level = level;
    }

    public NormalScoreCsv(NormalScore score, int highlight){
        super.setFile(f);
        this.score = score;
        this.records = this.readCSVFile();
        this.highlight = highlight;
    }

    public NormalScoreCsv(NormalScore score){
        super.setFile(f);
        this.score = score;
        this.records = this.readCSVFile();
    }

    @Override
    void writerCsv(List<List<String>> r) {
        BufferedWriter bw = null; // 출력 스트림 생성
        try{
            bw = new BufferedWriter(new FileWriter(f,true));
            // 해당 파일의 기존값에 이어쓰려면 위처럼 true를 지정 아니면 false로!

            for(int i=0; i<r.size(); i++){
                String aData = "";
                aData = r.get(i).get(0)+","+r.get(i).get(1)+","+r.get(i).get(2);
                bw.write(aData);
                bw.newLine(); //개행
            }

        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(bw!=null){
                    bw.flush(); // 남아있는 데이터까지 보내주기
                    bw.close(); // 사용한 BufferedWriter를 닫아주기
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //파일에 저장하는 부분
    public void finalScoreEmpty(){
        // 임시 저장용
        List<String> temp = new ArrayList<String>();
        temp.add(score.getName());
        temp.add(Integer.toString(score.getN_score()));
        temp.add(score.getN_difficulty());

        // 아무것도 없으면
        records.add(temp); // 리스트에 추가
        resetCsv(); // 초기화 후
        writerCsv(records); // 적기
    }

    // 파일에 저장하는 부분 2
    public void finalScoreNotEmpty() {// 기존에 값이 있으면
        // 임시 저장용
        List<String> temp = new ArrayList<String>();
        temp.add(score.getName());
        temp.add(Integer.toString(score.getN_score()));
        temp.add(score.getN_difficulty());

        for(int i=0; i< records.size(); i++){
            if(Integer.parseInt(records.get(i).get(1)) <= score.getN_score()){
                // 값이 중간에 있는거 보다 큰 경우
                records.add(i,temp); // 중간에 추가!
                if(records.size() > 10){
                    // 10보다 커진 경우
                    records.remove(records.get(10)); // 마지막꺼 지우기
                }
                resetCsv(); // 초기화 후
                writerCsv(records); // 적기
                return; // 있어야 종료 된다.
            }
        }
        if(records.size() != 10){
            records.add(records.size(),temp); // 중간에 추가!
            resetCsv(); // 초기화 후
            writerCsv(records); // 적기
        }
    }

    // 현재 스코어 보드에 점수에 들어갈 수 있는지 확인
    public int isRank(int temp_score){
        for(int i=0; i< records.size(); i++){
            if(Integer.parseInt(records.get(i).get(1)) <= temp_score){
                // 값이 중간에 있는거 보다 큰 경우
                return i;
            }
        }
        if(records.size() != 10){
            return records.size();
        }
        // 들어갈 자리가 없으면
        return 11;
    }

    @Override
    public void resetCsv(){ // Setting SCreen에 추가하기
        BufferedWriter bw = null; // 출력 스트림 생성
        try{
            bw = new BufferedWriter(new FileWriter(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                bw.close(); // 사용한 BufferedWriter를 닫아주기
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /*Getter*/
    // 난이도 받기
    public String getLevel() {
        return level;
    }

    // 기록용 파일 반환 - 비어있는지 확인용
    public List<List<String>> getRecords() {
        return records;
    }

    // 점수 받기
    public NormalScore getScore() {
        return score;
    }

    // 현재 위치 받기
    public int getHighlight() {
        return highlight;
    }
}
