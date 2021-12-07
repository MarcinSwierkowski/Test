package pl.sda.ZadanieZamowienia;

public class Pozycja {
    private String nazwaTowaru;
    private int iloscSztuk;
    private int cenaSztuki;

    public Pozycja(String nazwaTowaru, int iloscSztuk, int cenaSztuki) {
        this.nazwaTowaru = nazwaTowaru;
        this.iloscSztuk = iloscSztuk;
        this.cenaSztuki = cenaSztuki;
    }

    public int obliczWartosc(){
        return (this.iloscSztuk * this.cenaSztuki);
    }

    @Override
    public String toString() {
        return "Pozycja{" +
                "nazwaTowaru='" + nazwaTowaru + '\'' +
                ", iloscSztuk=" + iloscSztuk +
                ", cenaSztuki=" + cenaSztuki +
                '}';
    }
}
