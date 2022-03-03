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

    int iloscWojownikow = 30;
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
            int pojemnosc = 30;
            int typ = 1;
            int pozycjaX = random.nextInt(rozmiarPlanszyX);
            int pozycjaY = random.nextInt(rozmiarPlanszyY);
            Items items = new Items(nazwa,pozycjaX,pozycjaY,typ,pojemnosc);
            itemsList.add(items);
        }
    }

    public void wygenerujWojownikow(){
        Random random = new Random();
        for (int i = 1; i <= iloscWojownikow; i++) {
            String nazwa="Wojownik_"+i;
            int lifeLevel = 100;
            int power = random.nextInt(30);
            int pozycjaX = random.nextInt(rozmiarPlanszyX);
            int pozycjaY = random.nextInt(rozmiarPlanszyY);
            Wojownik wojownik = new Wojownik(pozycjaX,pozycjaY,nazwa,lifeLevel,power);
            wojownikList.add(wojownik);
        }
    }


    public void sprawdzKonfliktyGraczy() {

        for (int i = 0; i < wojownikList.size() - 1; i++) {
            for (int j = i + 1; j < wojownikList.size(); j++) {

                if (czyJestKonflikt(wojownikList.get(i),wojownikList.get(j))) {
                    if(wojownikList.get(i).getLifeLevel()>0 && wojownikList.get(j).getLifeLevel()>0) {
                        int powerNapastnika = wojownikList.get(i).getPower();
                        int powerOfiary = wojownikList.get(j).getPower();

                        int aktualnyLifeLevelOfiary = wojownikList.get(j).getLifeLevel();
                        int aktualnyLifeLevelNapastnika = wojownikList.get(j).getLifeLevel();

                        System.out.println("Wojna" + wojownikList.get(i) + ":" + wojownikList.get(j));
                        wojownikList.get(j).setLifeLevel(aktualnyLifeLevelOfiary - powerNapastnika);    // narazie nie ma premii dla atakującego
                        wojownikList.get(i).setLifeLevel(aktualnyLifeLevelNapastnika - powerOfiary);
                        System.out.println("Wojna" + wojownikList.get(i) + ":" + wojownikList.get(j));
                        System.out.println("Tylu jescze zyje : "+wojownikList.size());
                    }
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

    public synchronized void sprawdzKtoNieZyje() {
        wojownikList.removeIf(n -> n.getLifeLevel() <= 0);
    }

    public synchronized void sprawdzIluZyje() {
        int count =0;
        for (int i = 0; i < SingletonConfig.getInstance().wojownikList.size(); i++) {
            if (SingletonConfig.getInstance().wojownikList.get(i).getLifeLevel()>=0)
            count++;
        }
        System.out.println("Aktualnie zyje :"+ count);
    }


}
