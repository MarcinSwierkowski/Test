package pl.sda.Plansza;


import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Items {

    private String nazwa;
    private int pozycjaX;
    private int pozycjaY;
    private int typ;
    private int pojemnosc;
    private Image apteczka;


    public Items(String nazwa, int pozycjaX, int pozycjaY, int typ, int pojemnosc) {
        this.nazwa = nazwa;
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.typ = typ;
        this.pojemnosc = pojemnosc;

        loadImage();
    }

    public int getPozycjaX() {
        return pozycjaX;
    }
    public int getPozycjaY() {
        return pozycjaY;
    }


    public void rysujItem(Graphics g, Object t){

        g.drawImage(apteczka, this.pozycjaX, this.pozycjaY,(ImageObserver) t);
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/main/java/pl/sda/Plansza/apteczka.png");
        apteczka = ii.getImage();
    }

    @Override
    public String toString() {
        return "Items{" +
                "nazwa='" + nazwa + '\'' +
                ", pozycjaX=" + pozycjaX +
                ", pozycjaY=" + pozycjaY +
                ", typ=" + typ +
                ", pojemnosc=" + pojemnosc +
                '}';
    }
}
