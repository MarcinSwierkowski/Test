package pl.sda.Dzieci;

public interface IGrupa {
    void dodajDziecko(Dziecko dziecko);

    void usunDziecko(Dziecko dziecko);

    void usunDuplikaty();

    void sortuj();

    void touper();

    void tolower();
}
