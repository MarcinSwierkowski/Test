package pl.sda.Regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        //1szy - dłuższy zapis
        Pattern pattern= Pattern.compile("[0-9]");
        Matcher matcher=pattern.matcher("121212212");
        System.out.println(matcher.matches());
        // to znajduje 1 wystąpienie
        matcher.find();

        //2szy - krótki zapis
        System.out.println(Pattern.matches("[0-9]", "321321"));

        //3ci - ze Stringiem
        System.out.println("423423423".matches("[0-9]"));

        //materiały
        //https://github.com/idzikpro/JavaCore/blob/master/pdf/Regex.pdf
        //rozwiązania zadań


        System.out.println("Zadania:");
        String string = "42-400";

        System.out.println("Czy pierwsze trzy znaki są dowolne, zaś następne 3 znaki tylko cyframi?");
        System.out.println(string.matches(".{3}\\d{3}"));
        System.out.println(Pattern.matches(".{3}\\d{3}", string));
        System.out.println(Pattern.matches(".{3}[0-9]{3}", string));
        System.out.println("Czy string zawiera tylko cyfry?");
        System.out.println(string.matches("\\d+"));
        System.out.println(Pattern.matches("[0-9]+", string));
        System.out.println("Czy string zawiera tylko litery?");
        System.out.println(Pattern.matches("[a-zA-Z]+", string));
        System.out.println("Czy string zawiera tylko cyfry i litery?");
        System.out.println(Pattern.matches("\\w+", string));
        System.out.println("Czy string zawiera tylko cyfry i ma dokładnie 5 znaków?");
        System.out.println(Pattern.matches("\\d{5}", string));
        System.out.println("Czy string rozpoczyna się od \"J\"?");
        System.out.println(Pattern.matches("J.*", string));
        System.out.println("Czy string rozpoczyna się od \"J\" i kończy na \"U\"?");
        System.out.println(Pattern.matches("J.*U", string));
        System.out.println("Czy string rozpoczyna się od wielkiej litery?");
        System.out.println(Pattern.matches("[A-Z].*", string));
        System.out.println("Czy string zawiera spację? (biały znak)?");
        System.out.println(Pattern.matches(".*\\s.*", "aavhd werqwer wrerw"));
        System.out.println(Pattern.matches(".*\\p{Space}.*", "aavhd werqwer wrerw"));
        System.out.println("Czy string jest numerem telefonu zaczynającym się od 7 lub 8 lub 9?");
        System.out.println(Pattern.matches("[7-9]\\d{8}", string));
        System.out.println(Pattern.matches("[7-9][0-9]{8}", string));
        System.out.println("Czy string jest numerem bankowym? (Zakładając, że zaczyna się od dwóch liter, następnie 4 grupy po 4 cyfry)");
        System.out.println(Pattern.matches("[A-Z]{2}\\s*(\\d{4}\\s?){4}", "PL 1234 1234 1234 1234"));
        System.out.println("Czy string jest kodem pocztowym?");
        System.out.println(Pattern.matches("\\d{2}-\\d{3}", string));

    }
}

