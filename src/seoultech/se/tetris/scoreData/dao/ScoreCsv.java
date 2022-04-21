package seoultech.se.tetris.scoreData.dao;

import seoultech.se.tetris.scoreData.model.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


abstract class ScoreCsv { // writer 부분을 다르게 한 추상화 클래스
    // 필드
    private File file;

    // 생성자
    public ScoreCsv(){

    }
    public ScoreCsv(File file){
        this.file = file;
    }
    // 메소드
    abstract void writerCsv(List<List<String>> r); // 추상메소드
    abstract void resetCsv(); // 추상 메소드

    public List<List<String>> readCSVFile(){ // 일반메소드
        List<List<String>> records = new ArrayList<>(); // 마지막으로 들어 온 애는 첫 번째로 나간다.
        BufferedReader br = null;
        String line =""; // 콤마 제거를 위한 String

        try{
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){ // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 주를 ,로 나누어 배열에 저장 후 리스트로 변환
                aLine = Arrays.asList(lineArr);
                records.add(aLine);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }


    public void setFile(File file) {
        this.file = file;
    }
}
