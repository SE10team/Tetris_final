package seoultech.se.tetris.settingScreen.operationKeySetting;

import java.awt.event.KeyEvent;

public class OperationKeys {

  private int up;
  private int down;
  private int left;
  private int right;

  public void initialize() {
    up = KeyEvent.VK_UP;
    down = KeyEvent.VK_DOWN;
    left = KeyEvent.VK_LEFT;
    right = KeyEvent.VK_RIGHT;
  }






  public int getUp() {
    return up;
  }

  public void setUp(int up) {
    this.up = up;
  }

  public int getDown() {
    return down;
  }

  public void setDown(int down) {
    this.down = down;
  }

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public int getRight() {
    return right;
  }

  public void setRight(int right) {
    this.right = right;
  }
}
