//package seoultech.se.tetris.component;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.CountDownLatch;
//
//class GameScoreTest {
//    final CountDownLatch latch = new CountDownLatch(5); // Test 결과를 확인하기 위한 용도 즉 countdown()을 다섯 번 호출하면 0이 되서 해당 Test를 종료
//    GameScore score = new GameScore();
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            score.playScore();
//            System.out.print(score.getTotal_score()); // 자동으로 1점씩 증가
//            latch.countDown();
//        }
//    };
//    Timer timer = new Timer();
//    long period = 1000L;
//    long delay = 1000L;
//
//    @Test
//    void TimerScore() { // 자동으로 점수 증가하는 지 확인
//        timer.schedule(task,delay,period);
//        try {
//            latch.await(); // 0이 되면 해당 Test 메소드가 끝나도록 한다.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}