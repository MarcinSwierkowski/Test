package pl.sda.Ulamki;

public class Main {

    public static void main(String[] args) {

        Ulamek pierwszy = new Ulamek(4,5);
        Ulamek drugi = new Ulamek(2,6);

        System.out.println(pierwszy.toString());
        System.out.println(drugi.toString());

        System.out.println(pierwszy.dodajUlamki(drugi).toString());
        System.out.println(pierwszy.odejmijUlamki(drugi).toString());
        System.out.println(pierwszy.pomnozUlamki(drugi).toString());
        System.out.println(pierwszy.podzielUlamki(drugi).toString());

        System.out.println(pierwszy.toString());
        System.out.println(drugi.toString());


    }
}
