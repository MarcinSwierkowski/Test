package pl.sda.Lambdy;

import java.util.Arrays;

public class SortingStringByLength {

    public static void main(String[] args) {
        String[] strings = {"Ala", "ma", "białego", "kota"};

        System.out.println("Przed posortowaniem: " + Arrays.toString(strings));

        // sortowanie względem długości - wynikiem porównania dwóch Stringów
        // jest wynik porównania ich długości
        Arrays.sort(strings, (x, y) -> Integer.compare(x.length(), y.length()));

        System.out.println("Po posortowaniu: " + Arrays.toString(strings));

    }

}
