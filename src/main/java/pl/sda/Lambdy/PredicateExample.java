package pl.sda.Lambdy;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        // predykat sprawdzający, czy dany String jest dłuższy niż 4 znaki
        Predicate<String> is4CharsLongPredicate = x -> x.length() > 4;

        boolean result1 = is4CharsLongPredicate.test("Ala");
        System.out.println("Test predykatu dla napisu \"Ala\": " + result1);

        boolean result2 = is4CharsLongPredicate.test("Adrianna");
        System.out.println("Test predykatu dla napisu \"Adrianna\": " + result2);
    }

}
