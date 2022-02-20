package pl.sda.WojnaKolekcje;

import java.util.Comparator;

public class KomparatorFigury implements Comparator<KartaDoGry> {

    @Override
    public int compare(KartaDoGry o1, KartaDoGry o2) {
        return o1.getFigura().getMocFigury()-o2.getFigura().getMocFigury();
    }
}
