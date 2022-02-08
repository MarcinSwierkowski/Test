package pl.sda.Dzieci;

import java.util.*;

public class Grupa implements IGrupa {

    private String nazwaGrupy;
    private List<Dziecko> listaDzieci = new ArrayList<>();
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


    @Override
    public void dodajDziecko(Dziecko dziecko) {
        listaDzieci.add(dziecko);
        aktualnaLiczbaDzieciwGrupie= listaDzieci.size();
    }

    @Override
    public void usunDziecko(Dziecko dziecko) {
        listaDzieci.remove(dziecko);
        aktualnaLiczbaDzieciwGrupie= listaDzieci.size();
    }

    public void sortuj() {
        listaDzieci.sort(new KomparatorImie());
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

    public void tolower() {
        for (Dziecko element : listaDzieci) {
            element.setImie(element.getImie().toLowerCase());
        }
    }

    public void touper() {
        for (Dziecko element : listaDzieci) {
            element.setImie(element.getImie().toUpperCase());
        }
    }

    public void usunDuplikaty() {
        Set<Dziecko> bezDuplikatow = new HashSet<>(listaDzieci);
        listaDzieci = new ArrayList<>(bezDuplikatow);
        aktualnaLiczbaDzieciwGrupie = listaDzieci.size();
    }
}
