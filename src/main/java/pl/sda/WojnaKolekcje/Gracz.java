package pl.sda.WojnaKolekcje;

import java.util.ArrayList;
import java.util.List;

public class Gracz {

    private String name;
    private List<KartaDoGry> reka = new ArrayList<>();

    public Gracz() {
    }

    public List<KartaDoGry> getReka() {
        return reka;
    }

    public void setReka(List<KartaDoGry> reka) {
        this.reka = reka;
    }

    public void dodajKartę(KartaDoGry karta){
        reka.add(karta);
    }
}

