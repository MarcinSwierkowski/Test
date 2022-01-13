package pl.sda.Kolekcje;

import java.util.Objects;

public class DaneKolekcji {

    private Integer id;
    private String imie;
    private String nazwisko;
    private Integer rcp;

    public DaneKolekcji(int id, String imie, String nazwisko, int rcp) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rcp = rcp;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getPriorytet() {
        return rcp;
    }

    @Override
    public String toString() {
        return (id+". "+imie+" "+nazwisko+" "+rcp);
    }


}
