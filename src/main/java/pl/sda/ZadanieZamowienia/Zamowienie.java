package pl.sda.ZadanieZamowienia;

import java.util.Arrays;

public class Zamowienie {

    private Pozycja[] pozycje;
    private int maxRozmiar;
    private int ostatniaWolnaPozycja;

    public Zamowienie() {
        this.maxRozmiar = 10;
        this.ostatniaWolnaPozycja=0;
        pozycje = new Pozycja[maxRozmiar];
    }

    public Zamowienie(int maxRozmiar) {
        pozycje = new Pozycja[maxRozmiar];
        this.maxRozmiar = maxRozmiar;
    }

    public void dodajPozycje(Pozycja pozycja) {
        if (ostatniaWolnaPozycja < maxRozmiar) {
            this.pozycje[ostatniaWolnaPozycja] = pozycja;
            this.ostatniaWolnaPozycja++;
        } else System.out.println("Nic juz nie dodasz max ilosc zamowien : " + maxRozmiar);
    }

    public double obliczWartosc(){
        double suma = 0;
        for (int i = 0; i < ostatniaWolnaPozycja; i++) {
                suma += pozycje[i].obliczWartosc();
        }
        return suma;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Zamowienie: \n");
        for (int i = 0; i < ostatniaWolnaPozycja; i++) {
                stringBuilder.append(i+1+". "+pozycje[i].toString() + "\n");
        }
        stringBuilder.append("Razem: " + obliczWartosc() + " zł");
        return stringBuilder.toString();
    }
}
