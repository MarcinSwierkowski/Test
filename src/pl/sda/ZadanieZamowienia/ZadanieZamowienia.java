package pl.sda.ZadanieZamowienia;

public class ZadanieZamowienia {
    public static void main(String[] args) {


        Pozycja pozycja1 = new Pozycja("Chleb", 2, 4.35);
        Pozycja pozycja2 = new Pozycja("Banany", 1, 6.99);
        Pozycja pozycja3 = new Pozycja("Kiwi", 3, 6.25);
        Pozycja pozycja4 = new Pozycja("Marchew", 1, 2.56);
        Pozycja pozycja5 = new Pozycja("Majonez", 4, 6.72);
        Pozycja pozycja6 = new Pozycja("Woda", 8, 3.15);
        Pozycja pozycja7 = new Pozycja("Piwo", 6, 6.54);
        Pozycja pozycja8 = new Pozycja("Mąka", 2, 4.23);
        Pozycja pozycja9 = new Pozycja("Cola", 2, 7.99);
        Pozycja pozycja10 = new Pozycja("Cukier", 2, 8.22);
        Pozycja pozycja11 = new Pozycja("Jabłka", 5, 6.56);


        Zamowienie zamowienie1 = new Zamowienie(11);

        zamowienie1.dodajPozycje(pozycja1);
        zamowienie1.dodajPozycje(pozycja2);
        zamowienie1.dodajPozycje(pozycja3);
        zamowienie1.dodajPozycje(pozycja4);
        zamowienie1.dodajPozycje(pozycja5);
        zamowienie1.dodajPozycje(pozycja6);
        zamowienie1.dodajPozycje(pozycja7);
        zamowienie1.dodajPozycje(pozycja8);
        zamowienie1.dodajPozycje(pozycja9);
        zamowienie1.dodajPozycje(pozycja10);
        zamowienie1.dodajPozycje(pozycja11);


        System.out.println(zamowienie1);


    }

}
