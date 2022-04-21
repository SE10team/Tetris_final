package seoultech.se.tetris.settingScreen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FileInputOutputTest {

  final FileInputOutput fileInputOutput = new FileInputOutput();

  @DisplayName("사용자가 기본 색 모드로 설정해 놓았을 때 컬러 파일 불러오는 경우")
  @Test
  void input_Color_File_Not_For_Color_Blind() throws Exception {

    //given
    fileInputOutput.OutputColorFileNotForBlind();
    Color[] colors;

    //when
    colors = fileInputOutput.InputColorFile();

    //then
    assertEquals(colors[0], Color.CYAN);
    assertEquals(colors[1], Color.BLUE);
    assertEquals(colors[2], Color.ORANGE);
    assertEquals(colors[3], Color.YELLOW);
    assertEquals(colors[4], Color.GREEN);
    assertEquals(colors[5], Color.MAGENTA);
    assertEquals(colors[6], Color.RED);

  }

  @DisplayName("사용자가 색맹 모드로 설정해 놓았을 때 컬러 파일 불러오는 경우")
  @Test
  void input_Color_File_For_Color_Blind() throws Exception {

    //given
    fileInputOutput.OutputColorFileForBlind();
    Color[] colors;

    //when
    colors = fileInputOutput.InputColorFile();

    //then
    assertEquals(colors[0], new Color(0,161,117));
    assertEquals(colors[1], new Color(231,159,0));
    assertEquals(colors[2], new Color(88,179,234));
    assertEquals(colors[3], new Color(240,228,67));
    assertEquals(colors[4], new Color(0,113,177));
    assertEquals(colors[5], new Color(253,67,0));
    assertEquals(colors[6], new Color(206,120,167));

  }

  @DisplayName("사용자가 화살표로 키 셋팅 해놨을 때 키 파일 불러오는 경우")
  @Test
  void input_Key_File_When_Arrow_Setting() throws Exception {

    //given
    fileInputOutput.OutputKeySettingFileToArrow();
    int[] keys;

    //when
    keys = fileInputOutput.InputKeyFile();

    //then
    assertEquals(keys[0], 38);
    assertEquals(keys[1], 40);
    assertEquals(keys[2], 37);
    assertEquals(keys[3], 39);

  }

  @DisplayName("사용자가 WASD로 키 셋팅 해놨을 때 키 파일 불러오는 경우")
  @Test
  void input_Key_File_When_WASD_Setting() throws Exception {

    //given
    fileInputOutput.OutputKeySettingWithWASD();
    int[] keys;

    //when
    keys = fileInputOutput.InputKeyFile();

    //then
    assertEquals(keys[0], 87);
    assertEquals(keys[1], 83);
    assertEquals(keys[2], 65);
    assertEquals(keys[3], 68);

  }

  @DisplayName("스크린 사이즈 800x800일때 파일 불러오는 경우")
  @Test
  void input_Screen_Size_File_When_800x800() throws Exception {

    //given
    fileInputOutput.OutputScreenSize800800();
    int[] sizes;

    //when
    sizes = fileInputOutput.InputScreenSizeFile();

    //then
    assertEquals(sizes[0], 800);
    assertEquals(sizes[1], 800);
    assertEquals(sizes[2], 30);
    assertEquals(sizes[3], 25);
    assertEquals(sizes[4], 580);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 550);
    assertEquals(sizes[7], 400);

  }

  @DisplayName("스크린 사이즈 1000x1000일때 파일 불러오는 경우")
  @Test
  void input_Screen_Size_File_When_1000x1000() throws Exception {

    //given
    fileInputOutput.OutputScreenSize10001000();
    int[] sizes;

    //when
    sizes = fileInputOutput.InputScreenSizeFile();

    //then
    assertEquals(sizes[0], 1000);
    assertEquals(sizes[1], 1000);
    assertEquals(sizes[2], 130);
    assertEquals(sizes[3], 65);
    assertEquals(sizes[4], 680);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 650);
    assertEquals(sizes[7], 500);

  }

  @DisplayName("스크린 사이즈 1300x1000일때 파일 불러오는 경우")
  @Test
  void input_Screen_Size_File_When_1300x1000() throws Exception {

    //given
    fileInputOutput.OutputScreenSize13001000();
    int[] sizes;

    //when
    sizes = fileInputOutput.InputScreenSizeFile();

    //then
    assertEquals(sizes[0], 1300);
    assertEquals(sizes[1], 1000);
    assertEquals(sizes[2], 170);
    assertEquals(sizes[3], 65);
    assertEquals(sizes[4], 800);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 800);
    assertEquals(sizes[7], 500);

  }

  @DisplayName("난이도 설정 파일 Easy 불러오기")
  @Test
  void input_Mode_Setting_File_When_Easy() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(1);
    int setMode;

    //when
    setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(1, setMode);
  }

  @DisplayName("난이도 설정 파일 Normal 불러오기")
  @Test
  void input_Mode_Setting_File_When_Normal() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(2);
    int setMode;

    //when
    setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(2, setMode);
  }

  @DisplayName("난이도 설정 파일 Hard 불러오기")
  @Test
  void input_Mode_Setting_File_When_Hard() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(3);
    int setMode;

    //when
    setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(3, setMode);
  }


  @DisplayName("일반 색 모드 파일 출력하는 경우")
  @Test
  void output_Color_File_Not_For_Blind() throws Exception {

    fileInputOutput.OutputColorFileNotForBlind();

    Color[] colors = fileInputOutput.InputColorFile();

    assertEquals(colors[0], Color.CYAN);
    assertEquals(colors[1], Color.BLUE);
    assertEquals(colors[2], Color.ORANGE);
    assertEquals(colors[3], Color.YELLOW);
    assertEquals(colors[4], Color.GREEN);
    assertEquals(colors[5], Color.MAGENTA);
    assertEquals(colors[6], Color.RED);

  }

  @DisplayName("색맹 모드 파일 출력하는 경우")
  @Test
  void output_Color_File_For_Blind() throws Exception {

    fileInputOutput.OutputColorFileForBlind();

    Color[] colors = fileInputOutput.InputColorFile();

    assertEquals(colors[0], new Color(0,161,117));
    assertEquals(colors[1], new Color(231,159,0));
    assertEquals(colors[2], new Color(88,179,234));
    assertEquals(colors[3], new Color(240,228,67));
    assertEquals(colors[4], new Color(0,113,177));
    assertEquals(colors[5], new Color(253,67,0));
    assertEquals(colors[6], new Color(206,120,167));

  }

  @DisplayName("화살표 키 셋팅 파일 출력하는 경우")
  @Test
  void output_Key_Setting_File_To_Arrow() throws Exception {

    fileInputOutput.OutputKeySettingFileToArrow();

    int[] keys = fileInputOutput.InputKeyFile();

    assertEquals(keys[0], 38);
    assertEquals(keys[1], 40);
    assertEquals(keys[2], 37);
    assertEquals(keys[3], 39);

  }

  @DisplayName("WASD 키 셋팅 파일 출력하는 경우")
  @Test
  void outputKeySettingWithWASD() throws Exception {

    fileInputOutput.OutputKeySettingWithWASD();

    int[] keys = fileInputOutput.InputKeyFile();

    assertEquals(keys[0], 87);
    assertEquals(keys[1], 83);
    assertEquals(keys[2], 65);
    assertEquals(keys[3], 68);

  }

  @DisplayName("화면 사이즈 800x800 파일 출력하는 경우")
  @Test
  void outputScreenSize800800() throws Exception {

    fileInputOutput.OutputScreenSize800800();

    int[] sizes = fileInputOutput.InputScreenSizeFile();

    assertEquals(sizes[0], 800);
    assertEquals(sizes[1], 800);
    assertEquals(sizes[2], 30);
    assertEquals(sizes[3], 25);
    assertEquals(sizes[4], 580);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 550);
    assertEquals(sizes[7], 400);
  }

  @DisplayName("화면 사이즈 1000x1000 파일 출력하는 경우")
  @Test
  void outputScreenSize10001000() throws Exception {

    fileInputOutput.OutputScreenSize10001000();

    int[] sizes = fileInputOutput.InputScreenSizeFile();

    assertEquals(sizes[0], 1000);
    assertEquals(sizes[1], 1000);
    assertEquals(sizes[2], 130);
    assertEquals(sizes[3], 65);
    assertEquals(sizes[4], 680);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 650);
    assertEquals(sizes[7], 500);

  }

  @DisplayName("화면 사이즈 1300x1000 파일 출력하는 경우")
  @Test
  void outputScreenSize13001000() throws Exception {

    fileInputOutput.OutputScreenSize13001000();

    int[] sizes = fileInputOutput.InputScreenSizeFile();

    assertEquals(sizes[0], 1300);
    assertEquals(sizes[1], 1000);
    assertEquals(sizes[2], 170);
    assertEquals(sizes[3], 65);
    assertEquals(sizes[4], 800);
    assertEquals(sizes[5], 100);
    assertEquals(sizes[6], 800);
    assertEquals(sizes[7], 500);

  }

  @DisplayName("난이도 설정 파일 Easy 출력")
  @Test
  void outputModeSettingEasy() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(1);

    //when
    int setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(1, setMode);
  }

  @DisplayName("난이도 설정 파일 Normal 출력")
  @Test
  void outputModeSettingNormal() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(2);
    int setMode;

    //when
    setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(2, setMode);
  }

  @DisplayName("난이도 설정 파일 Hard 출력")
  @Test
  void outputModeSettindHard() throws Exception {

    //given
    fileInputOutput.OutputModeSetting(3);
    int setMode;

    //when
    setMode = fileInputOutput.InputModeFile();

    //then
    assertEquals(3, setMode);
  }

}