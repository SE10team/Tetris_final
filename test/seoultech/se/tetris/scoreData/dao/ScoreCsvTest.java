//package seoultech.se.tetris.scoreData.dao;
//
//import org.junit.jupiter.api.Test;
//import seoultech.se.tetris.scoreData.model.ItemScore;
//import seoultech.se.tetris.scoreData.model.NormalScore;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ScoreCsvTest {
//    ItemScore score = new ItemScore("의정",Nor);
//    NormalScore score2 = new NormalScore("의정",300, 2);
//
//    NormalScoreCsv normalScoreCsv = new NormalScoreCsv(score2);
//    ItemScoreCsv itemScoreCsv = new ItemScoreCsv(score);
//
//
//    @Test
//    void writerAndReaderCsv() {
//        itemScoreCsv.finalScore(); // 쓰기
//        normalScoreCsv.finalScore(); // 쓰기
//
//        List<List<String>> s = itemScoreCsv.readCSVFile(); // 쓰기
//        List<List<String>> s1 = normalScoreCsv.readCSVFile(); // 쓰기
//        assertEquals(false,s.isEmpty());
//        assertEquals(false, s1.isEmpty());
//        assertEquals(300,  Integer.parseInt(s1.get(0).get(1))); //값 비교
//
//        normalScoreCsv.resetCsv();
//        itemScoreCsv.resetCsv();
//        List<List<String>> r_s1 = normalScoreCsv.readCSVFile();
//        List<List<String>> r_s = itemScoreCsv.readCSVFile();
//        assertEquals(true, r_s1.isEmpty());
//        assertEquals(true, r_s.isEmpty());
//    }
//
//
//}