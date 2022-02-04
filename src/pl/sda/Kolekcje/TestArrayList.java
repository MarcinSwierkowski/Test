package pl.sda.Kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {

       String[] imiona = {"Marcin","Ania","Mateusz","Wojtek","Zbyszek"};

        List<String> names = new ArrayList<>(Arrays.asList(imiona));

    String removedName = names.remove(0);
        System.out.println(names);

    }


}