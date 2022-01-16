package pl.sda.Kolekcje;

import java.util.*;

public class Mapy {

    public static void main(String[] args) {


        DaneKolekcji element1 = new DaneKolekcji(1, "Dawid", "Siednienko", 5);
        DaneKolekcji element2 = new DaneKolekcji(2, "Zbigniew", "Domagała", 2);
        DaneKolekcji element3 = new DaneKolekcji(3, "Mariusz", "Syguła", 1);
        DaneKolekcji element4 = new DaneKolekcji(4, "Krzysztof", "Banyś", 6);
        DaneKolekcji element5 = new DaneKolekcji(5, "Janusz", "Kluza", 52);
        DaneKolekcji element6 = new DaneKolekcji(6, "Grzegorz", "Ścisłowski", 40);
        DaneKolekcji element7 = new DaneKolekcji(7, "Jacek", "Sobota", 10);
        DaneKolekcji element8 = new DaneKolekcji(8, "Marek", "Dyduch", 11);
        DaneKolekcji element9 = new DaneKolekcji(9, "Michał", "Bińkiewicz", 51);
        DaneKolekcji element10 = new DaneKolekcji(10, "Artur", "Puchała", 33);
        DaneKolekcji element11 = new DaneKolekcji(10, "Artur", "Puchała", 33);

        Map<Integer,DaneKolekcji> pracownicy = new HashMap<>();


        pracownicy.put(10,element11);
        pracownicy.put(1,element1);
        pracownicy.put(2,element2);
        pracownicy.put(3,element3);
        pracownicy.put(4,element4);
        pracownicy.put(5,element5);
        pracownicy.put(6,element6);
        pracownicy.put(7,element7);
        pracownicy.put(8,element8);
        pracownicy.put(9,element9);
        pracownicy.put(10,element10);


        //Set<DaneKolekcji> bezDuplikatow = new LinkedHashSet<>(pracownicy);
        //pracownicy = new ArrayList<>(bezDuplikatow);

        //System.out.println(pracownicy);

        //pracownicy.sort(new KomparatorRcp());
        //pracownicy.sort(new KomparatorNazwisko());
        //pracownicy.sort(new KomparatorImie());
        //pracownicy.sort(new KomparatorId());


        Set<Map.Entry<Integer,DaneKolekcji>> element = pracownicy.entrySet();
        for (Map.Entry<Integer,DaneKolekcji> pozycja : element) {
            System.out.println(pozycja.getKey()+ " " + pozycja.getValue());
        }


    }

}
