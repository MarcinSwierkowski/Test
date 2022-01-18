package pl.sda.Lambdy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("Ala","ma","kota","kot","ma","ALĘ"));

        System.out.println("Krótsze niż 4 znaki: ");
        printMatching(strings, x -> x.length() < 4);

        System.out.println("Dłuższe niż 3 znaki: ");
        printMatching(strings, x -> x.length() > 3);

        System.out.println("Małymi literami: ");
        // napis jest małymi literami jeśli jest identyczny do jego wersji małymi literami
        printMatching(strings, x -> x.toLowerCase().equals(x));
    }

    // metoda wypisująca elementy z listy 'list' spełniające warunek
    // podany za pomocą predykatu 'predicate'
    public static void printMatching(List<String> list, Predicate<String> predicate){
        for (String element : list) {
            boolean predicatePassed = predicate.test(element);
            if(predicatePassed){
                System.out.print(element+ ", ");
            }
        }
        System.out.println("\n-------");
    }

}
