package general;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private final int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder (Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(33, 150, 243));
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
