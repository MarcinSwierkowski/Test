package pl.sda.Plansza;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingletonConfig {

    private static final SingletonConfig instance = new SingletonConfig();

    public SingletonConfig() {}

    public static SingletonConfig getInstance(){
        return instance;
    }

    int rozmiarPlanszyX = 400;
    int rozmiarPlanszyY = 400;

    int iloscWojownikow = 10;
    int iloscApteczek = 5;
    int iloscPulapek = 5;

    private String[][] plansza = new String[rozmiarPlanszyX][rozmiarPlanszyY];

    public String[][] getPlansza() {
        return plansza;
    }

    List<Items> itemsList = new ArrayList<>();
    List<Wojownik> wojownikList = new ArrayList<>();

    public void wygenerujApteczki(){
        Random random = new Random();
        for (int i = 1; i <= iloscApteczek; i++) {
            String nazwa="Apteczka_"+i;
            String symbol="A";
            int pojemnosc = 30;
            int typ = 1;
            int pozycjaX = random.nextInt(rozmiarPlanszyX);
            int pozycjaY = random.nextInt(rozmiarPlanszyY);
            Items items = new Items(nazwa,symbol,pozycjaX,pozycjaY,typ,pojemnosc);
            itemsList.add(items);
        }
    }

    public void wygenerujWojownikow(){
        Random random = new Random();
        for (int i = 1; i <= iloscWojownikow; i++) {
            String nazwa="Wojownik_"+i;
            String symbol="\u001B[31mW\u001B[0m";
            int lifeLevel = 100;
            int power = random.nextInt(30);
            int pozycjaX = random.nextInt(rozmiarPlanszyX);
            int pozycjaY = random.nextInt(rozmiarPlanszyY);
            Wojownik wojownik = new Wojownik(pozycjaX,pozycjaY,nazwa,symbol,lifeLevel,power);
            wojownikList.add(wojownik);
        }
    }

    public void umiescItemNaPlanszy() {
        for (Items element : itemsList) {
            plansza[element.getPozycjaX()][element.getPozycjaY()] = element.getSymbol();
        }
    }

    public void umiescWojownikaNaPlanszy() {
        for (Wojownik element : wojownikList) {
            plansza[element.getPozycjaX()][element.getPozycjaY()] = element.getSymbol();
        }
    }

    public void sprawdzKonfliktyGraczy() {

        for (int i = 0; i < wojownikList.size() - 1; i++) {
            for (int j = i + 1; j < wojownikList.size(); j++) {

                if (czyJestKonflikt(wojownikList.get(i),wojownikList.get(j))) {

                    int powerNapastnika = wojownikList.get(i).getPower();
                    int powerOfiary = wojownikList.get(j).getPower();

                    int aktualnyLifeLevelOfiary = wojownikList.get(j).getLifeLevel();
                    int aktualnyLifeLevelNapastnika = wojownikList.get(j).getLifeLevel();

                    // System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                    wojownikList.get(j).setLifeLevel(aktualnyLifeLevelOfiary - powerNapastnika);    // narazie nie ma premii dla atakującego
                    wojownikList.get(i).setLifeLevel(aktualnyLifeLevelNapastnika - powerOfiary);
                    //System.out.println("Wojna" + npcList.get(i) + ":" + npcList.get(j));
                }
            }
        }
    }

    private boolean czyJestKonflikt(Wojownik wojownik, Wojownik wojownik1) {
        return (wojownik.getPozycjaX()== wojownik1.getPozycjaX() && wojownik.getPozycjaY()==wojownik1.getPozycjaY());
    }

    public void pokarzZywych() {
        System.out.println("Gracze którzy przeżyli grę:");
        for (Wojownik element : wojownikList) {
            System.out.println(element);
        }
    }

    public void sprawdzKtoNieZyje() {
        wojownikList.removeIf(n -> n.getLifeLevel() <= 0);
    }


    public void wyczyscPlansze(){
        for (int i = 0; i < rozmiarPlanszyY; i++) {
            for (int j = 0; j < rozmiarPlanszyX; j++) {
                plansza[j][i]=null;
            }
        }
    }


}
