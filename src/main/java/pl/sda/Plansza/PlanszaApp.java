package pl.sda.Plansza;

import java.awt.*;
import java.util.*;

public class PlanszaApp {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MyFrame();
            }
        });

        SingletonConfig.getInstance().wygenerujApteczki();
        SingletonConfig.getInstance().wygenerujWojownikow();

        SingletonConfig.getInstance().umiescWojownikaNaPlanszy();
        SingletonConfig.getInstance().umiescItemNaPlanszy();


//        for (int i = 0; i < 500; i++) {
//            for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
//                element.idz();
//            }
//
//            SingletonConfig.getInstance().sprawdzKonfliktyGraczy();
//            SingletonConfig.getInstance().sprawdzKtoNieZyje();
//        }

       // SingletonConfig.getInstance().pokarzZywych();

    }

}
