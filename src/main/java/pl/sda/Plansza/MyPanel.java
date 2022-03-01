package pl.sda.Plansza;

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
        String[][] plansza = SingletonConfig.getInstance().getPlansza();

        for (int i = 0; i < 500; i++) {
            for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
                element.idz();
                SingletonConfig.getInstance().umiescWojownikaNaPlanszy();
                for (int y = 0; y < SingletonConfig.getInstance().rozmiarPlanszyY; y++) {
                    for (int x = 0; x < SingletonConfig.getInstance().rozmiarPlanszyX; x++) {
                        if (plansza[y][x] != null) {
                            Ellipse2D circle = new Ellipse2D.Double(x * 10, y * 10, 10, 10);
                            g2d.draw(circle);

                        }
                       // SingletonConfig.getInstance().wyczyscPlansze();
                    }
                }
            }

        }
    }
}