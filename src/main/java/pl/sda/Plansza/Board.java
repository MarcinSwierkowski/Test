package pl.sda.Plansza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final int B_WIDTH = 410;
    private final int B_HEIGHT = 410;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Timer timer;

    public Board() {

        initBoard();
    }


    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));


        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawWarrior(g);
    }

    private void drawWarrior(Graphics g) {

        for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
            element.rysujWojownika(g,this);
        }
            Toolkit.getDefaultToolkit().sync();
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

                for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
                    element.idz();
                    SingletonConfig.getInstance().sprawdzKonfliktyGraczy();
                }
            //SingletonConfig.getInstance().sprawdzIluZyje();
            SingletonConfig.getInstance().sprawdzKtoNieZyje();
            System.out.println(SingletonConfig.getInstance().wojownikList.size());
            repaint();
        }
    }
}