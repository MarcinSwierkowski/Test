package pl.sda.Komputer;

public class Main {
    public static void main(String[] args) {

        // Stwórz kilka obiektów typu Laptop i typu Komputer.
        Komputer komputer1 = new Komputer(450, "Dell-Serwer", TypProcesora.WIELORDZENIOWY);
        Komputer komputer2 = new Komputer(250, "Hewlet Packard", TypProcesora.WIELORDZENIOWY);
        Komputer komputer3 = new Komputer(120,"Amiga",TypProcesora.JEDNORDZENIOWY);

        Laptop laptop1 = new Laptop(80, "Lenovo", TypProcesora.JEDNORDZENIOWY, 15.4, false);
        Laptop laptop2 = new Laptop(180, "Acer Nitro", TypProcesora.WIELORDZENIOWY, 17, true);
        Laptop laptop3 = new Laptop(160, "Apple Air", TypProcesora.WIELORDZENIOWY, 11, true);

        // Umieść je w tablicy,
        Komputer[] tablicaKomputerow = new Komputer[]{komputer1, komputer2,komputer3, laptop1, laptop2, laptop3};

        // a następnie wypisz pętlą while.
        for (int i = 0; i < tablicaKomputerow.length ; i++) {
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((i+1) + " : "
                    + "Potrzebna moc: " + tablicaKomputerow[i].getPotrzebnaMoc() + " "
                    + "Producent: " + tablicaKomputerow[i].getProducent() + " "
                    + "Typ: " + tablicaKomputerow[i].getTypProcesora());
            if (tablicaKomputerow[i] instanceof Laptop) {
                stringBuilder.append(" Wielkosc matrycy: " + ((Laptop) tablicaKomputerow[i]).getWielkoscMatrycy());
            }
            System.out.println(stringBuilder.toString());
        }

        }
    }
}
