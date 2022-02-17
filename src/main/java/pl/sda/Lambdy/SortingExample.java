package pl.sda.Lambdy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        int[] array = {5,4,8,3};

        System.out.println("Tablica PRZED posortowaniem: " + Arrays.toString(array));
        // sortowanie tablicy
        Arrays.sort(array);
        System.out.println("Tablica PO posortowaniu: " + Arrays.toString(array));

        List<Integer> collection = new ArrayList<>(Arrays.asList(8, 4, 9, 5));

        System.out.println("Kolekcja PRZED posortowaniem: " + collection);
        Collections.sort(collection);
        System.out.println("Kolekcja PO posortowaniu: " + collection);
    }

}
