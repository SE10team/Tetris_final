package seoultech.se.tetris.scoreData.dao;

import seoultech.se.tetris.scoreData.model.ItemScore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemScoreCsv extends ScoreCsv { // 아이템 모드
    // 파일 경로
    private File f = new File("C:\\Users\\USER\\OneDrive - 서울과학기술대학교\\Tetris_final\\src\\seoultech\\se\\tetris\\scoreData\\resource\\ItemScoreResult.csv");
    private ItemScore score;

    // 생성자
    public ItemScoreCsv() {
        super.setFile(f);
    }

    public ItemScoreCsv(ItemScore score) {
        super.setFile(f);
        this.score = score;
    }

    @Override
    void writerCsv(List<List<String>> r) {
        BufferedWriter bw = null; // 출력 스트림 생성
        try {
            bw = new BufferedWriter(new FileWriter(f,true));
            // 해당 파일의 기존값에 이어쓰려면 위처럼 true를 지정 아니면 false로!

            for(int i=0; i<r.size(); i++){
                String aData = "";
                aData = r.get(i).get(0)+","+r.get(i).get(1);
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
            try {
                if (bw != null) {
                    bw.flush(); // 남아있는 데이터까지 보내주기
                    bw.close(); // 사용한 BufferedWriter를 닫아주기
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
    }

    //정렬하는 부분
    public void finalScore(){
        List<List<String>> records = this.readCSVFile();
        List<String> temp = new ArrayList<String>();
        temp.add(score.getName());
        temp.add(Integer.toString(score.getN_score()));

        if(records.isEmpty()){
            // 아무것도 없으면
            records.add(temp); // 리스트에 추가
            resetCsv(); // 초기화 후
            writerCsv(records); // 적기
        }
        else{ // 기존에 값이 있으면
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
                    break; // 있어야 종료 된다.
                }

            }
        }
    }

    @Override
    void resetCsv(){
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
}
