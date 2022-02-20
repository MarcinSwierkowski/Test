package pl.sda.WojnaKolekcje;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Gracz {

    private int id;
    private String name;
    private Queue<KartaDoGry> reka = new LinkedList<>();

    public Gracz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Queue<KartaDoGry> getReka() {
        return reka;
    }

    public void setReka(Queue<KartaDoGry> reka) {
        this.reka = reka;
    }

    public void dodajKartę(KartaDoGry karta){
        reka.add(karta);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

