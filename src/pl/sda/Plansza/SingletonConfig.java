package pl.sda.Plansza;

import java.util.List;
import java.util.Random;

public class SingletonConfig {

    private static final SingletonConfig instance = new SingletonConfig();

    public SingletonConfig() {}

    public static SingletonConfig getInstance(){
        return instance;
    }

    int rozmiarPlanszyX = 20;
    int rozmiarPlanszyY = 20;

    int iloscWojownikow = 4;
    int iloscApteczek = 5;
    int iloscPulapek = 5;

    String[][] plansza = new String[rozmiarPlanszyX][rozmiarPlanszyY];

    List<Items> itemsList;
    List<Wojownik> wojownikList;

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
            String symbol="W";
            int lifeLevel = 100;
            int power = random.nextInt(30);
            int pozycjaX = random.nextInt(rozmiarPlanszyX);
            int pozycjaY = random.nextInt(rozmiarPlanszyY);
            Wojownik wojownik = new Wojownik(pozycjaX,pozycjaY,nazwa,symbol,lifeLevel,power);
            wojownikList.add(wojownik);
        }
    }

    public void umiescItemNaPlanszy(List<Items> itemsList, String[][] plansza) {
        for (Items element : itemsList) {
            plansza[element.getPozycjaX()][element.getPozycjaY()] = element.getSymbol();
        }
    }

    public void umiescWojownikaNaPlanszy(List<Wojownik> wojownikList, String[][] plansza) {
        for (Wojownik element : wojownikList) {
            plansza[element.getPozycjaX()][element.getPozycjaY()] = element.getSymbol();
        }
    }

}
