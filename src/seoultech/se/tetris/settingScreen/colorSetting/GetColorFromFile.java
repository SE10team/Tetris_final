package seoultech.se.tetris.settingScreen.colorSetting;

import seoultech.se.tetris.settingScreen.osChecking.OSValidator;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class GetColorFromFile {
  public Color[] colors = new Color[7];
  public GetColorFromFile() throws IOException, ClassNotFoundException {
//    OSValidator osValidator = new OSValidator();
//    if(osValidator)
    String filename = "/Users/home/Desktop/colorSetting.ser";
    FileInputStream fileInputStream = new FileInputStream(filename);
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
  }
}
