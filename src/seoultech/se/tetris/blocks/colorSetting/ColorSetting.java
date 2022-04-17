package seoultech.se.tetris.blocks.colorSetting;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;


public class ColorSetting implements Serializable {

  @Serial
  private static final long serialVersionUID = -5010041579621987124L;

  private Color iblock = Color.CYAN;
  private Color jblock = Color.BLUE;
  private Color lblock = Color.ORANGE;
  private Color oblock = Color.YELLOW;
  private Color sblock = Color.GREEN;
  private Color tblock = Color.MAGENTA;
  private Color zblock = Color.RED;

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
