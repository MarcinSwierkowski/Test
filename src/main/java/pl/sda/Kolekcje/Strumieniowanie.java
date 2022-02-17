package pl.sda.Kolekcje;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Strumieniowanie {

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

        List<DaneKolekcji> pracownicy = new ArrayList<>();

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


        List<DaneKolekcji> filteredList = pracownicy.stream()
                .filter(x -> x.getRcp() > 10)
                .filter(x -> x.getRcp() % 2 == 0)
                .sorted(new KomparatorId())

                .collect(Collectors.toList());

        for (DaneKolekcji elementy : filteredList) {
            System.out.println(elementy);
        }
        System.out.println("_____________________________");

        for (DaneKolekcji elementy2 : pracownicy) {
            System.out.println(elementy2);
        }
        System.out.println("ilość elementow : " + pracownicy.size());
    }


}

