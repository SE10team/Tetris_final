package seoultech.se.tetris.startScreen;

import javax.swing.*;
import java.awt.*;

public class StartScreenTitle extends JPanel {

  public StartScreenTitle() {
    JLabel jLabel = new JLabel("Tetris");
    Font font = new Font("Arial", Font.BOLD, 40);
    jLabel.setFont(font);
    jLabel.setLayout(null);
    add(jLabel);
    setVisible(true);
  }
}
