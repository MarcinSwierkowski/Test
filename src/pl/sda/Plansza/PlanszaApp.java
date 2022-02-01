package pl.sda.Plansza;

import java.util.ArrayList;
import java.util.List;

public class PlanszaApp {
    public static void main(String[] args) {


        Plansza plansza = new Plansza();
        Wojownik npc1 = new Wojownik(2, 2, "X", 100, 15);
        Wojownik npc2 = new Wojownik(3, 3, "Y", 100, 20);
        Wojownik npc3 = new Wojownik(4, 3, "Z", 100, 8);
        Wojownik npc4 = new Wojownik(1, 0, "P", 100, 5);


        List<Wojownik> npcList = new ArrayList<>();
        npcList.add(npc1);
        npcList.add(npc2);
        npcList.add(npc3);
        npcList.add(npc4);


        for (int i = 0; i < 500; i++) {
            for (Wojownik element : npcList) {
                element.idz();}
            sprawdzKonflikty(npcList);
            sprawdzKtoNieZyje(npcList);
        }

        plansza.wyczyscTablice();
        umiescZywychNaPlanszy(npcList,plansza);
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

    private static void sprawdzKtoNieZyje(List<Wojownik> npcList) {
            npcList.removeIf(n->n.getLifeLevel()<=0);
        }

    private static void sprawdzKonflikty(List<Wojownik> npcList) {

        for (int i = 0; i < npcList.size(); i++) {

            int xi = npcList.get(i).getPozycjaX();
            int yi = npcList.get(i).getPozycjaY();

            for (int j = 0; j < npcList.size(); j++) {
                if (i != j) {
                    int xj = npcList.get(j).getPozycjaX();
                    int yj = npcList.get(j).getPozycjaY();
                    if (xi == xj && yi == yj) {
                        int power = npcList.get(i).getPower();
                        int aktualnyLifeLevel = npcList.get(j).getLifeLevel();
                       // System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                        npcList.get(j).setLifeLevel(aktualnyLifeLevel - power);
                       // System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                    }
                }
            }
        }
    }


}
