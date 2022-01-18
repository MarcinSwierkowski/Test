package pl.sda.Lambdy;

import java.util.Arrays;
import java.util.Comparator;

public class SortingWithComparator {

    public static void main(String[] args) {
        Integer[] array = {5,4,8,3};

        // "naturalna" kolejność, liczba x jest większa (1), jeśli jej
        // wartość jest większa od liczby y
        Comparator<Integer> normalComparator = (x, y) -> {
            if(x > y){
                return 1;
            } else if(x == y) {
                return 0;
            } else {
                return -1;
            }
        };

        // "odwrotna" kolejność, liczba x jest większa (1), jeśli jej
        // wartość jest mniejsza od liczby y
        Comparator<Integer> reverseComparator = (x, y) -> {
            if(x > y){
                return -1;
            } else if(x == y) {
                return 0;
            } else {
                return 1;
            }
        };

        System.out.println("Przed posortowaniem: " + Arrays.toString(array));

        Arrays.sort(array, normalComparator);
        System.out.println("Po posortowaniu (normalComparator): " + Arrays.toString(array));

        Arrays.sort(array, reverseComparator);
        System.out.println("Po posortowaniu (reverseComparator): " + Arrays.toString(array));

    }

}
