package pl.sda.ZadanieZamowienia;

public class Pozycja {
    private String nazwaTowaru;
    private int iloscSztuk;
    private double cenaSztuki;

    public Pozycja(String nazwaTowaru, int iloscSztuk, double cenaSztuki) {
        this.nazwaTowaru = nazwaTowaru;
        this.iloscSztuk = iloscSztuk;
        this.cenaSztuki = cenaSztuki;
    }

    public double obliczWartosc(){
        return (this.iloscSztuk * this.cenaSztuki);
    }

    @Override
    public String toString() {
        return nazwaTowaru + "\t\t" +
                cenaSztuki + " zł" + "\t\t" +
                iloscSztuk + " szt." + "\t\t" +
                obliczWartosc() + " zł";
    }
}
