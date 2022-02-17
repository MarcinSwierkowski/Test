package pl.sda.Dzieci;

import java.util.Comparator;

public class KomparatorImie implements Comparator<Dziecko> {

    @Override
    public int compare(Dziecko o1, Dziecko o2) {
        {
            int result = o1.getImie().compareTo(o2.getImie());

            if (result == 0) {
                return Integer.valueOf(o1.getPesel()).compareTo(Integer.valueOf(o2.getPesel()));
            } else {
                return result;
            }
        }
    }
}
