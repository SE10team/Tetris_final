package seoultech.se.tetris.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class StyledButtonUI extends BasicButtonUI { // 버튼 UI와 관련된 부분

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
       // paintBackground(g, b, b.getModel().isPressed() ? 2 : 0); // 눌러졌을 떄
        paintBackground(g,b,b.getModel().isRollover()? 2 : 0); // 포커스
        super.paint(g, c);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b,
                              Rectangle viewRect, Rectangle textRect, Rectangle iconRect){
        paintBackground(g,b,2);
        paintText(g, b, textRect, b.getText());
    }

    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE.darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);

    }
}
