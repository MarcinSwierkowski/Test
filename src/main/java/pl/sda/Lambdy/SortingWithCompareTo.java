package pl.sda.Lambdy;

import java.util.Arrays;

public class SortingWithCompareTo {

    public static void main(String[] args) {
        Integer[] array = {5,4,8,3};

        System.out.println("Przed posortowaniem: " + Arrays.toString(array));

        // sortowanie "odwortne" wynikiem porównania 'x' z 'y'
        // jest porównanie 'y' z 'x'
        Arrays.sort(array, (x, y) -> y.compareTo(x));

        System.out.println("Po posortowaniu (reverseComparator): " + Arrays.toString(array));

    }

}
