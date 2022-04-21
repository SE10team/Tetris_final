package seoultech.se.tetris.settingScreen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class FileInputOutput {

  // 경로설정 바꿀곳!

  // 맥 (유빈)
//  private final String colorFilename = "/Users/home/Desktop/colorSetting.ser";
//  private final String keySettingFilename = "/Users/home/Desktop/keySetting.ser";
//  private final String screenSizeFilename = "/Users/home/Desktop/screenSizeSetting.ser";

//  // 윈도우 (윤재)
   private final String colorFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/colorSetting.ser";
   private final String keySettingFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/keySetting.ser";
   private final String screenSizeFilename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/screenSizeSetting.ser";

//   // 윈도우 (의정)
//   private final String colorFilename = "C:/Users/USER/OneDrive - 서울과학기술대학교/Tetris_final/colorSetting.ser";
//   private final String keySettingFilename = "C:/Users/USER/OneDrive - 서울과학기술대학교/Tetris_final/keySetting.ser";
//   private final String screenSizeFilename = "C:/Users/USER/OneDrive - 서울과학기술대학교/Tetris_final/screenSizeSetting.ser";



  public Color[] InputColorFile() throws IOException, ClassNotFoundException {
      Color[] colors = new Color[7];
      FileInputStream fileInputStream = new FileInputStream(colorFilename);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      Object object = objectInputStream.readObject();
      objectInputStream.close();
      HashMap<String, Color> hashMap = (HashMap<String, Color>) object;
      Iterator<String> iterator = hashMap.keySet().iterator();
      while (iterator.hasNext()) {
        String block = iterator.next();
        Color color = hashMap.get(block);
        if (Objects.equals(block, "iblock")) {
          colors[0] = color;
        } else if (Objects.equals(block, "jblock")) {
          colors[1] = color;
        } else if (Objects.equals(block, "lblock")) {
          colors[2] = color;
        } else if (Objects.equals(block, "oblock")) {
          colors[3] = color;
        } else if (Objects.equals(block, "sblock")) {
          colors[4] = color;
        } else if (Objects.equals(block, "tblock")) {
          colors[5] = color;
        } else if (Objects.equals(block, "zblock")) {
          colors[6] = color;
        }
      }
    return colors;
  }

  public int[] InputKeyFile() throws IOException, ClassNotFoundException {
    Integer[] keys = new Integer[4];
    int[] returnKeys = new int[4];
      FileInputStream fileInputStream = new FileInputStream(keySettingFilename);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      Object object = objectInputStream.readObject();
      objectInputStream.close();
      HashMap<String, Integer> hashMap = (HashMap<String, Integer>) object;
      Iterator<String> iterator = hashMap.keySet().iterator();
      while (iterator.hasNext()) {
        String key = iterator.next();
        Integer keyValue = hashMap.get(key);
        if (Objects.equals(key, "UP")) {
          keys[0] = keyValue;
        } else if (Objects.equals(key, "DOWN")) {
          keys[1] = keyValue;
        } else if (Objects.equals(key, "LEFT")) {
          keys[2] = keyValue;
        } else if (Objects.equals(key, "RIGHT")) {
          keys[3] = keyValue;
        }
      }

    returnKeys[0] = keys[0];
    returnKeys[1] = keys[1];
    returnKeys[2] = keys[2];
    returnKeys[3] = keys[3];
    return returnKeys;
  }

  public int[] InputScreenSizeFile() throws IOException, ClassNotFoundException {
    int[] screenSizeArr = new int[8];
    FileInputStream fileInputStream = new FileInputStream(screenSizeFilename);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Object object = objectInputStream.readObject();
    objectInputStream.close();
    HashMap<String, Integer> hashMap = (HashMap<String, Integer>) object;
    Iterator<String> iterator = hashMap.keySet().iterator();
    while (iterator.hasNext()) {
      String name = iterator.next();
      Integer size = hashMap.get(name);
      if (Objects.equals(name, "size800width")) {
        screenSizeArr[0] = size;
      } else if (Objects.equals(name, "size800height")) {
        screenSizeArr[1] = size;
      } else if (Objects.equals(name, "playScreenX")) {
        screenSizeArr[2] = size;
      } else if (Objects.equals(name, "playScreenY")) {
        screenSizeArr[3] = size;
      } else if (Objects.equals(name, "scoreX")) {
        screenSizeArr[4] = size;
      } else if (Objects.equals(name, "scoreY")) {
        screenSizeArr[5] = size;
      } else if (Objects.equals(name, "nextBlockX")) {
        screenSizeArr[6] = size;
      } else if (Objects.equals(name, "nextBlockY")) {
        screenSizeArr[7] = size;
      }
    }
    return screenSizeArr;
  }



  public void OutputColorFileNotForBlind() {
    try {
      File colorSettingFile = new File(colorFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }

      FileOutputStream fileOutputStream = new FileOutputStream(colorFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Color> hashMap = new HashMap<>();
      hashMap.put("iblock", Color.CYAN);
      hashMap.put("jblock", Color.BLUE);
      hashMap.put("lblock", Color.ORANGE);
      hashMap.put("oblock", Color.YELLOW);
      hashMap.put("sblock", Color.GREEN);
      hashMap.put("tblock", Color.MAGENTA);
      hashMap.put("zblock", Color.RED);

      System.out.println(hashMap);

      objectOutputStream.writeObject(hashMap);
      objectOutputStream.close();
    } catch (
      IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputColorFileForBlind() {
    try {
      File colorSettingFile = new File(colorFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(colorFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Color> hashMap = new HashMap<>();
      hashMap.put("iblock", new Color(0,161,117));
      hashMap.put("jblock", new Color(231,159,0));
      hashMap.put("lblock", new Color(88,179,234));
      hashMap.put("oblock", new Color(240,228,67));
      hashMap.put("sblock", new Color(0,113,177));
      hashMap.put("tblock", new Color(253,67,0));
      hashMap.put("zblock", new Color(206,120,167));

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputKeySettingFileToArrow() {
    //조작키 설정 초기화
    try {
      File colorSettingFile = new File(keySettingFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(keySettingFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("UP", KeyEvent.VK_UP);
      hashMap.put("DOWN", KeyEvent.VK_DOWN);
      hashMap.put("LEFT", KeyEvent.VK_LEFT);
      hashMap.put("RIGHT", KeyEvent.VK_RIGHT);

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputKeySettingWithWASD() {
    try {
      File colorSettingFile = new File(keySettingFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(keySettingFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("UP", KeyEvent.VK_W);
      hashMap.put("DOWN", KeyEvent.VK_S);
      hashMap.put("LEFT", KeyEvent.VK_A);
      hashMap.put("RIGHT", KeyEvent.VK_D);

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputScreenSize800800() {
    try {
      File colorSettingFile = new File(screenSizeFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(screenSizeFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("size800width", 800);
      hashMap.put("size800height", 800);
      hashMap.put("playScreenX", 30);
      hashMap.put("playScreenY", 25);
      hashMap.put("scoreX", 580);
      hashMap.put("scoreY", 100);
      hashMap.put("nextBlockX", 550);
      hashMap.put("nextBlockY", 400);

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputScreenSize10001000() {
    try {
      File colorSettingFile = new File(screenSizeFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(screenSizeFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("size800width", 1000);
      hashMap.put("size800height", 1000);
      hashMap.put("playScreenX", 130);
      hashMap.put("playScreenY", 65);
      hashMap.put("scoreX", 680);
      hashMap.put("scoreY", 100);
      hashMap.put("nextBlockX", 650);
      hashMap.put("nextBlockY", 500);

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  public void OutputScreenSize13001000() {
    try {
      File colorSettingFile = new File(screenSizeFilename);
      if (colorSettingFile.exists()) {
        if (colorSettingFile.delete()) {
          System.out.println("성공적으로 파일 삭제");
        } else {
          System.out.println("파일 삭제 실패");
        }
      }
      FileOutputStream fileOutputStream = new FileOutputStream(screenSizeFilename);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("size800width", 1300);
      hashMap.put("size800height", 1000);
      hashMap.put("playScreenX", 170);
      hashMap.put("playScreenY", 65);
      hashMap.put("scoreX", 800);
      hashMap.put("scoreY", 100);
      hashMap.put("nextBlockX", 800);
      hashMap.put("nextBlockY", 500);

      objectOutputStream.writeObject(hashMap);
      System.out.println(hashMap);
      objectOutputStream.close();
    } catch (IOException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

}
