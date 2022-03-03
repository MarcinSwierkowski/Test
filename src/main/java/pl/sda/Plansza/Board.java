package pl.sda.Plansza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 400;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Image ball;
    private Timer timer;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/main/java/pl/sda/Plansza/ball.png");
        ball = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
    }

    private void drawBall(Graphics g) {
//        int count=0;
//        for (Wojownik wojownik : SingletonConfig.getInstance().wojownikList) {
//            x = SingletonConfig.getInstance().wojownikList.get(count++).getPozycjaX();
//            y = SingletonConfig.getInstance().wojownikList.get(count).getPozycjaY();
//        }

        for (int j = 0; j <SingletonConfig.getInstance().iloscWojownikow ; j++) {
            if(SingletonConfig.getInstance().wojownikList.get(j).getLifeLevel()>0) {
                x = SingletonConfig.getInstance().wojownikList.get(j).getPozycjaX();
                y = SingletonConfig.getInstance().wojownikList.get(j).getPozycjaY();
                g.drawImage(ball, x, y, this);
            }
        }
            Toolkit.getDefaultToolkit().sync();
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

                for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
                    element.idz();
                    SingletonConfig.getInstance().sprawdzKonfliktyGraczy();
                    SingletonConfig.getInstance().sprawdzIluZyje();
                }
            repaint();
        }
    }
}