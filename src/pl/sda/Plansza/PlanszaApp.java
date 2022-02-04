package pl.sda.Plansza;

import java.util.*;

public class PlanszaApp {

    public static void main(String[] args) {

        SingletonConfig.getInstance().wygenerujApteczki();
        SingletonConfig.getInstance().wygenerujWojownikow();

        SingletonConfig.getInstance().umiescWojownikaNaPlanszy();
        SingletonConfig.getInstance().umiescItemNaPlanszy();


        SingletonConfig.getInstance().rysujPlansze();

        for (int i = 0; i < 500; i++) {
            for (Wojownik element : SingletonConfig.getInstance().wojownikList) {
                element.idz();
            }

            SingletonConfig.getInstance().sprawdzKonfliktyGraczy();
            SingletonConfig.getInstance().sprawdzKtoNieZyje();
        }

        SingletonConfig.getInstance().pokarzZywych();

    }

}
