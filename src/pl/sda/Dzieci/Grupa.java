package pl.sda.Dzieci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grupa {

    private String nazwaGrupy;
    private List<Dziecko> listaDzieci=new ArrayList<>();
    private int rozmiarGrupy;
    private int aktualnaLiczbaDzieciwGrupie;

    public Grupa(String nazwaGrupy, int rozmiarGrupy) {
        this.nazwaGrupy = nazwaGrupy;
        this.rozmiarGrupy = rozmiarGrupy;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public List<Dziecko> getListaDzieci() {
        return listaDzieci;
    }

    public int getRozmiarGrupy() {
        return rozmiarGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public int getAktualnaLiczbaDzieciwGrupie() {
        return aktualnaLiczbaDzieciwGrupie;
    }

    public void setAktualnaLiczbaDzieciwGrupie(int aktualnaLiczbaDzieciwGrupie) {
        this.aktualnaLiczbaDzieciwGrupie = aktualnaLiczbaDzieciwGrupie;
    }

    public void setRozmiarGrupy(int rozmiarGrupy) {
        this.rozmiarGrupy = rozmiarGrupy;
    }

    public void dodajDziecko(Dziecko dziecko){
        listaDzieci.add(dziecko);
    }

    public void sortuj(){

    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nazwaGrupy='" + nazwaGrupy + '\'' +
                ", listaDzieci=" + listaDzieci +
                ", rozmiarGrupy=" + rozmiarGrupy +
                ", aktualnaLiczbaDzieciwGrupie=" + aktualnaLiczbaDzieciwGrupie +
                '}';
    }
}
