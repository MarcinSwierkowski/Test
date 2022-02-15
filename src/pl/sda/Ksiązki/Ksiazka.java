package pl.sda.Ksiązki;

import java.time.LocalDate;

public class Ksiazka {
    private String tytul;
    private String autor;
    private LocalDate dataPowstania;
    private int liczbaStron;

    public Ksiazka(String tytul, String autor, LocalDate dataPowstania, int liczbaStron) {
        this.tytul = tytul;
        this.autor = autor;
        this.dataPowstania = dataPowstania;
        this.liczbaStron = liczbaStron;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPowstania() {
        return dataPowstania;
    }

    public int getLiczbaStron() {
        return liczbaStron;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPowstania=" + dataPowstania +
                ", liczbaStron=" + liczbaStron +
                '}';
    }
}

