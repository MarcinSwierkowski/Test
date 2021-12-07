package pl.sda.ZadanieZamowienia;

import java.util.Arrays;

public class Zamowienie {

    private Pozycja Pozycje[];
    private int maxRozmiar;

    public Zamowienie(int maxRozmiar) {
        this.maxRozmiar = maxRozmiar;
    }

    public Zamowienie() {
        maxRozmiar=10;
    }

    public void dodajPozycje(Pozycja pozycja){

    }

    public int obliczWartosc(){
    return 1;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "Pozycje=" + Arrays.toString(Pozycje) +
                ", maxRozmiar=" + maxRozmiar +
                '}';
    }
}
