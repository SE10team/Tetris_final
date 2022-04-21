package seoultech.se.tetris.startScreen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seoultech.se.tetris.GUI.PlayScreen;

import java.awt.*;
import java.awt.event.InputEvent;

class StartScreenTest {

  @DisplayName("시작 화면 기본 모드 버튼 클릭 테스트")
  @Test
  public void start_screen_no_item_mode_button_click_test() throws Exception {

    // given
    final StartScreen startScreen = new StartScreen();
    final PlayScreen playScreen = new PlayScreen();


    // when
    Robot bot = new Robot();
    bot.mouseMove(135,195);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    //add time between press and release or the input event system may
    //not think it is a click
    try{Thread.sleep(250);}catch(InterruptedException e){}
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


    // then
  }

}