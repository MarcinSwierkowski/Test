package pl.sda.Plansza;

import java.util.Random;

public class Items {

    private String nazwa;
    private String symbol;
    private int pozycjaX;
    private int pozycjaY;
    private int typ;
    private int pojemnosc;

    public Items(String nazwa, String symbol, int pozycjaX, int pozycjaY, int typ, int pojemnosc) {
        this.nazwa = nazwa;
        this.symbol = symbol;
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.typ = typ;
        this.pojemnosc = pojemnosc;
    }

    public int getPozycjaX() {
        return pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Items{" +
                "nazwa='" + nazwa + '\'' +
                ", symbol='" + symbol + '\'' +
                ", pozycjaX=" + pozycjaX +
                ", pozycjaY=" + pozycjaY +
                ", typ=" + typ +
                ", pojemnosc=" + pojemnosc +
                '}';
    }
}
