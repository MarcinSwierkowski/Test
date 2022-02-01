package pl.sda.Plansza;

public class SingletonConfig {

    private static final SingletonConfig instance = new SingletonConfig();

    public SingletonConfig() {}

    public static SingletonConfig getInstance(){
        return instance;
    }

    int rozmiarPlanszyX = 10;
    int rozmiarPlanszyY = 10;

}
