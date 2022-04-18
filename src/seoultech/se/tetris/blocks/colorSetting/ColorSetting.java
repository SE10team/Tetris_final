package seoultech.se.tetris.blocks.colorSetting;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;


public class ColorSetting implements Serializable {

  @Serial
  private static final long serialVersionUID = -5010041579621987124L;

  private Color iblock;
  private Color jblock;
  private Color lblock;
  private Color oblock;
  private Color sblock;
  private Color tblock;
  private Color zblock;

  public ColorSetting() throws Exception {
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
        setIblock(color);
      } else if (Objects.equals(block, "jblock")) {
        setJblock(color);
      } else if (Objects.equals(block, "lblock")) {
        setLblock(color);
      } else if (Objects.equals(block, "oblock")) {
        setOblock(color);
      } else if (Objects.equals(block, "sblock")) {
        setSblock(color);
      } else if (Objects.equals(block, "tblock")) {
        setTblock(color);
      } else if (Objects.equals(block, "zblock")) {
        setZblock(color);
      }
    }
  }

  public Color getIblock() {
    return iblock;
  }

  public void setIblock(Color iblock) {
    this.iblock = iblock;
  }

  public Color getJblock() {
    return jblock;
  }

  public void setJblock(Color jblock) {
    this.jblock = jblock;
  }

  public Color getLblock() {
    return lblock;
  }

  public void setLblock(Color lblock) {
    this.lblock = lblock;
  }

  public Color getOblock() {
    return oblock;
  }

  public void setOblock(Color oblock) {
    this.oblock = oblock;
  }

  public Color getSblock() {
    return sblock;
  }

  public void setSblock(Color sblock) {
    this.sblock = sblock;
  }

  public Color getTblock() {
    return tblock;
  }

  public void setTblock(Color tblock) {
    this.tblock = tblock;
  }

  public Color getZblock() {
    return zblock;
  }

  public void setZblock(Color zblock) {
    this.zblock = zblock;
  }
}
