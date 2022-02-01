package pl.sda.Plansza;

import java.util.*;

public class PlanszaApp {
    public static void main(String[] args) {

        SingletonConfig.getInstance().wygenerujApteczki();
        SingletonConfig.getInstance().wygenerujWojownikow();





        for (int i = 0; i < 500; i++) {
            for (Wojownik element : npcList) {
                element.idz();
            }
            sprawdzKonfliktyGraczy(npcList);
            sprawdzKtoNieZyje(npcList);
        }

        plansza.wyczyscTablice();
        umiescZywychNaPlanszy(npcList, plansza);
        plansza.rysujPlansze();

        pokarzZywych(npcList);




    }

    private static void pokarzZywych(List<Wojownik> npcList) {
        System.out.println("Gracze którzy przeżyli grę:");
        for (Wojownik element : npcList) {
            System.out.println(element);
        }
    }


    private static void umiescZywychNaPlanszy(List<Wojownik> npcList, Plansza plansza) {
        for (Wojownik element : npcList) {
            plansza.tablica[element.getPozycjaX()][element.getPozycjaY()] = element.getNazwa();
        }
    }

    private static void umiescItemsNaPlanszy(List<Items> itemsList, Plansza plansza) {
        for (Items element : itemsList) {
            plansza.tablica[element.getPozycjaX()][element.getPozycjaY()] = element.getSymbol();
        }
    }

    private static void sprawdzKtoNieZyje(List<Wojownik> npcList) {
        npcList.removeIf(n -> n.getLifeLevel() <= 0);
    }

    private static void sprawdzKonfliktyGraczy(List<Wojownik> npcList) {

        for (int i = 0; i < npcList.size() - 1; i++) {
            for (int j = i + 1; j < npcList.size(); j++) {

                if (czyJestKonflikt(npcList.get(i),npcList.get(j))) {

                    int powerNapastnika = npcList.get(i).getPower();
                    int powerOfiary = npcList.get(j).getPower();

                    int aktualnyLifeLevelOfiary = npcList.get(j).getLifeLevel();
                    int aktualnyLifeLevelNapastnika = npcList.get(j).getLifeLevel();

                    // System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                    npcList.get(j).setLifeLevel(aktualnyLifeLevelOfiary - powerNapastnika);    // narazie nie ma premii dla atakującego
                    npcList.get(i).setLifeLevel(aktualnyLifeLevelNapastnika - powerOfiary);
                    //System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                }
            }
        }
    }

    private static boolean czyJestKonflikt(Wojownik wojownik, Wojownik wojownik1) {
        return (wojownik.getPozycjaX()== wojownik1.getPozycjaX() && wojownik.getPozycjaY()==wojownik1.getPozycjaY());
    }



}
