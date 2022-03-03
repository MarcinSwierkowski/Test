package pl.sda.Ulamki;

import java.util.Random;

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


        int max =2;
        int min =-2;

        Random random = new Random();
        System.out.println((int)((Math.random() * (max - min + 1))) - 1);

        for (int i = 0; i < 100; i++) {

            System.out.println(random.nextInt((max - min + 1)) - max);
        }

        System.out.println(min++);
        System.out.println(++min);
    }
}
