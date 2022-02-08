package pl.sda.Dzieci;

import java.util.Comparator;

public class KomparatorImie implements Comparator<Dziecko> {
    @Override
    public int compare(Dziecko o1, Dziecko o2) {
        {
            return o1.getImie().compareTo(o2.getImie());
        }
    }
}
