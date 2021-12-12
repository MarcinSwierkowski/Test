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
        return (licznik + "/" + mianownik);
    }

    public Ulamek dodajUlamki(Ulamek ulamek) {
        if (this.mianownik == ulamek.mianownik) {
            return new Ulamek(this.licznik + ulamek.licznik,this.mianownik);
        } else {
            //Do Zrobienia : Sprowadzić do wspólnego mianownika.
            return new Ulamek(this.licznik * ulamek.mianownik + this.mianownik * ulamek.licznik,this.mianownik * ulamek.mianownik);
        }
    }

    public Ulamek odejmijUlamki(Ulamek ulamek) {
        if (this.mianownik == ulamek.mianownik) {
            return new Ulamek(this.licznik - ulamek.licznik,this.mianownik);
        } else {
            //Do Zrobienia : Sprowadzić do wspólnego mianownika.
            return new Ulamek(this.licznik * ulamek.mianownik - this.mianownik * ulamek.licznik,this.mianownik * ulamek.mianownik);
        }
    }

    public Ulamek pomnozUlamki(Ulamek ulamek) {
        return new Ulamek(this.licznik * ulamek.licznik,this.mianownik * ulamek.mianownik);
    }

    public Ulamek podzielUlamki(Ulamek ulamek) {
        return new Ulamek(this.licznik * ulamek.mianownik,this.mianownik * ulamek.licznik);
    }

}