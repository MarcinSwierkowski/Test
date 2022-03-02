package pl.sda.Gfx;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
    public MyPanel() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // prostokat
        Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 40, 40);
        // kolo
        for (int i = 0; i < 10; i++) {

            Ellipse2D circle = new Ellipse2D.Double(i+100, i+100, 60, 70);
            g2d.draw(circle);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        g2d.draw(rectangle);

    }
}