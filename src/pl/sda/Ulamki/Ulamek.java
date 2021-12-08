package pl.sda.Ulamki;

public class Ulamek {
    private int licznik;
    private int mianownik;


    public Ulamek(int licznik, int mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
    }
    @Override
    public String toString() {
        return "Ulamek{" +
                "licznik=" + licznik +
                ", mianownik=" + mianownik +
                '}';
    }

    public Ulamek dodajUlamki(Ulamek ulamek) {
        Ulamek wynik = new Ulamek(0, 0);
        if (this.mianownik == ulamek.mianownik) {
            wynik.licznik = this.licznik + ulamek.licznik;
            wynik.mianownik = this.mianownik;
            return wynik;
        } else {
            //Do Zrobienia : Sprowadzić do wspólnego mianownika.
            wynik.licznik = this.licznik * ulamek.mianownik + this.mianownik * ulamek.licznik;
            wynik.mianownik = this.mianownik * ulamek.mianownik;
            return wynik;
        }
    }

    public Ulamek odejmijUlamki(Ulamek ulamek) {
        Ulamek wynik = new Ulamek(0, 0);
        if (this.mianownik == ulamek.mianownik) {
            wynik.licznik = this.licznik - ulamek.licznik;
            wynik.mianownik = this.mianownik;
            return wynik;
        } else {
            //Do Zrobienia : Sprowadzić do wspólnego mianownika.
            wynik.licznik = this.licznik * ulamek.mianownik - this.mianownik * ulamek.licznik;
            wynik.mianownik = this.mianownik * ulamek.mianownik;
            return wynik;
        }
    }

    public Ulamek pomnozUlamki(Ulamek ulamek) {
        Ulamek wynik = new Ulamek(0, 0);
        wynik.licznik = this.licznik * ulamek.licznik;
        wynik.mianownik = this.mianownik * ulamek.mianownik;
        return wynik;
    }

    public Ulamek podzielUlamki(Ulamek ulamek) {
        Ulamek wynik = new Ulamek(0, 0);
        wynik.licznik = this.licznik * ulamek.mianownik;
        wynik.mianownik = this.mianownik * ulamek.licznik;
        return wynik;
    }

}