package pl.sda.Plansza;

import java.awt.*;
import java.util.*;

public class PlanszaApp {

    public static void main(String[] args) {

        SingletonConfig.getInstance().wygenerujApteczki();
        SingletonConfig.getInstance().wygenerujWojownikow();


        System.out.println(SingletonConfig.getInstance().wojownikList.get(0).getPozycjaX());
        System.out.println(SingletonConfig.getInstance().wojownikList.get(0).getPozycjaY());

//        SingletonConfig.getInstance().umiescWojownikaNaPlanszy();
//        SingletonConfig.getInstance().umiescItemNaPlanszy();


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
