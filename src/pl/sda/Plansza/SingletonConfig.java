package pl.sda.Plansza;

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

}
