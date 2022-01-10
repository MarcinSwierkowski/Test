package pl.sda.Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class ZadaniaTime {

    public static void main(String[] args) {

        int ileMiesiecy;


        LocalDate urodziny = LocalDate.parse("1972-11-01");

        int c = pytanie("Kobieta czy mężczyzna ? (k/m) :",10,1);
        System.out.println(c);
        int a = pytanie("Czy palisz papierosy ? (t/n) :",10,5,-1);
        System.out.println(a);
        int b = pytanie("Uprawiasz sport ? (t/n) :",10,4,1);
        System.out.println(b);

        int startowyWiek = 60*12;
        int ileJeszczeMiesiecy = (a + b + c)*12;

        System.out.println("Pożyjesz :"+(startowyWiek+ileJeszczeMiesiecy)/12);
    }

    private static LocalDate DataCzaspodajDateUrodzenia(String pytanie) {
        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(data);
        return localDate;
    }


    private static int pytanie(String pytanie,int waga, int random, int pozytywny) {

        Random rand = new Random();
        int wartosc = rand.nextInt(2*random)-random;
        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        String odpowiedz = scanner.nextLine();
        if (odpowiedz.equals("t")){
            return (waga+wartosc)*pozytywny;
        }
        else return 0;
    }

    private static int pytanie(String pytanie,int waga, int pozytywny) {

        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        String odpowiedz = scanner.nextLine();
        if (odpowiedz.equals("k")){
            return 10;
        }
        else return 0;
    }

}
