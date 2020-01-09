package Interface;

import java.awt.*;

public class BackgroundPanel extends AbsInterfaceContainer {

    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint blueToGreen = new GradientPaint(0, 0, new Color(51, 153, 255), 900, 900,
                new Color(153, 255, 204));
        g2d.setPaint(blueToGreen);
        g2d.fillRect(0, 0, w, h);
    }

}