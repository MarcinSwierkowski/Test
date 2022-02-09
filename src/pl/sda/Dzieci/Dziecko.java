package pl.sda.Dzieci;

import java.util.Objects;

public class Dziecko {
    private String imie;
    private String pesel;

    public Dziecko(String imie, String pesel) {
        this.imie = imie;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dziecko)) return false;
        Dziecko dziecko = (Dziecko) o;
        return Objects.equals(imie, dziecko.imie) && Objects.equals(pesel, dziecko.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, pesel);
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return " "+imie +"-" + pesel+" ";
    }
}
