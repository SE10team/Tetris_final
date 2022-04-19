package seoultech.se.tetris.settingScreen.operationKeySetting;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class GetKeySetting {

  public Integer[] keys = new Integer[4];
  public GetKeySetting() throws IOException, ClassNotFoundException {
//    OSValidator osValidator = new OSValidator();
//    if(osValidator)
    String filename = "D:/OneDrive/Documents/Assignment/SE_Tetris/Tetris_final/keySetting.ser";
    FileInputStream fileInputStream = new FileInputStream(filename);
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
  }
}
