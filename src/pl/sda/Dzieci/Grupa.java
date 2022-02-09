package pl.sda.Dzieci;

import java.util.*;

public class Grupa implements IGrupa {

    private String nazwaGrupy;
    private List<Dziecko> listaDzieci = new ArrayList<>();

    public Grupa(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public List<Dziecko> getListaDzieci() {
        return listaDzieci;
    }


    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }



    @Override
    public void dodajDziecko(Dziecko dziecko) {
        listaDzieci.add(dziecko);
    }

    @Override
    public void usunDziecko(Dziecko dziecko) {
        if(listaDzieci.remove(dziecko)){
            System.out.println("Dziecko usunięte z listy");
        }
        else {
            System.out.println("Dzieciaka nie ma na liscie więc go nie usunę.");
        }
    }

    public void sortuj() {
        listaDzieci.sort(new KomparatorImie());
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nazwaGrupy='" + nazwaGrupy + '\'' +
                ", listaDzieci=" + listaDzieci +
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
    }
}
