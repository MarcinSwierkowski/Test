package pl.sda.Plansza;

import java.util.*;

public class PlanszaApp {
    public static void main(String[] args) {


        Plansza plansza = new Plansza();
        Wojownik npc1 = new Wojownik(2, 2, "X", 100, 15);
        Wojownik npc2 = new Wojownik(3, 3, "Y", 100, 20);
        Wojownik npc3 = new Wojownik(4, 3, "Z", 100, 8);
        Wojownik npc4 = new Wojownik(1, 0, "P", 100, 5);


        List<Items> itemsList = new ArrayList<>();

        wygenerujApteczki(itemsList);
        umiescItemsNaPlanszy(itemsList,plansza);
        plansza.rysujPlansze();

        System.out.println(itemsList);

        List<Wojownik> npcList = new ArrayList<>();
        npcList.add(npc1);
        npcList.add(npc2);
        npcList.add(npc3);
        npcList.add(npc4);


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


        System.out.println("Wszyscy gracze:");
        System.out.println(npc1);
        System.out.println(npc2);
        System.out.println(npc3);
        System.out.println(npc4);


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

    private static void wygenerujApteczki(List<Items> lista){
        Random random = new Random();
        for (int i = 1; i <= SingletonConfig.getInstance().iloscApteczek; i++) {
           String nazwa="Apteczka_"+i;
           String symbol="A";
           int pojemnosc = 30;
           int typ = 1;
           int pozycjaX = random.nextInt(SingletonConfig.getInstance().rozmiarPlanszyX);
           int pozycjaY = random.nextInt(SingletonConfig.getInstance().rozmiarPlanszyY);
           Items items = new Items(nazwa,symbol,pozycjaX,pozycjaY,typ,pojemnosc);
           lista.add(items);
        }
    }

}
