package seoultech.se.tetris.settingScreen.osChecking;

public class OSValidator {

  private static String OS = System.getProperty("os.name").toLowerCase();

  public OSValidator() {

  }

  public static boolean isWindows() {
    return (OS.indexOf("win") >= 0);
  }

  public static boolean isMac() {
    return (OS.indexOf("mac") >= 0);
  }
}
