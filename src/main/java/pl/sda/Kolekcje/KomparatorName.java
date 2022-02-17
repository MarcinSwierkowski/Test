package pl.sda.Kolekcje;
import java.util.Comparator;


class KomparatorNazwisko implements Comparator<DaneKolekcji> {

        @Override
        public int compare(DaneKolekcji o1, DaneKolekcji o2) {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}

class KomparatorImie implements Comparator<DaneKolekcji> {

    @Override
    public int compare(DaneKolekcji o1, DaneKolekcji o2) {
        return o1.getImie().compareTo(o2.getImie());
    }
}

class KomparatorId implements Comparator<DaneKolekcji> {

    @Override
    public int compare(DaneKolekcji o1, DaneKolekcji o2) {
        if(o1.getId() > o2.getId()){
            return 1;
        } else if(o1.getId() == o2.getId()) {
            return 0;
        } else {
            return -1;
        }

    }
}

class KomparatorRcp implements Comparator<DaneKolekcji> {

    @Override
    public int compare(DaneKolekcji o1, DaneKolekcji o2) {
        if (o1.getRcp()>o2.getRcp()) return 1;
        else return -1;
    }
}