package pl.sda.Plansza;


public class Items {

    private String nazwa;
    private int pozycjaX;
    private int pozycjaY;
    private int typ;
    private int pojemnosc;

    public Items(String nazwa, int pozycjaX, int pozycjaY, int typ, int pojemnosc) {
        this.nazwa = nazwa;
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
