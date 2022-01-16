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

    public int getRcp() {
        return rcp;
    }

    @Override
    public String toString() {
        return (id+". "+imie+"  "+nazwisko+"  "+rcp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaneKolekcji)) return false;
        DaneKolekcji that = (DaneKolekcji) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getImie(), that.getImie()) && Objects.equals(getNazwisko(), that.getNazwisko()) && Objects.equals(rcp, that.rcp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getImie(), getNazwisko(), rcp);
    }
}
