package pl.sda.Kolekcje;

import java.util.*;

public class KolejkiPQ {


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



        Queue<DaneKolekcji> pracownicy = new PriorityQueue<>(new KomparatorId());
        //Queue<DaneKolekcji> pracownicy = new PriorityQueue<>(new KomparatorImie());
        //Queue<DaneKolekcji> pracownicy = new PriorityQueue<>(new KomparatorNazwisko());
        //Queue<DaneKolekcji> pracownicy = new PriorityQueue<>(new KomparatorRcp());


        //pracownicy.push(element1);
        //pracownicy.addFirst(element1);        // działa jak push
        //pracownicy.add(element1);             // albo add, który doda na koniec
        //pracownicy.peek();                    // podgladamy co jest do pobrania
        //pracownicy.poll();                    // pobieramy czyli zabieramy z kolejki



        pracownicy.add(element1);
        pracownicy.add(element2);
        pracownicy.add(element3);
        pracownicy.add(element4);
        pracownicy.add(element5);
        pracownicy.add(element6);
        pracownicy.add(element7);
        pracownicy.add(element8);
        pracownicy.add(element9);
        pracownicy.add(element10);
        pracownicy.add(element11);


        Set<DaneKolekcji> bezDuplikatow = new LinkedHashSet<>(pracownicy);

        Queue<DaneKolekcji> pracownicy1 = new PriorityQueue<>(new KomparatorImie());
        pracownicy1.addAll(bezDuplikatow);




        //pracownicy.stream().sorted(new KomparatorImie());

        //System.out.println(pracownicy);

        //pracownicy.sort(new KomparatorRcp());
        //pracownicy.sort(new KomparatorNazwisko());
        //pracownicy.sort(new KomparatorImie());
        //pracownicy.sort(new KomparatorId());


        for (DaneKolekcji elementy : pracownicy1) {
            System.out.println(elementy);
        }

    }
}
