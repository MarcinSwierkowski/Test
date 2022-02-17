package pl.sda.Kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestArrayList {
    public static void main(String[] args) {


        List<String> listaGosci = new ArrayList<>();
        List<String> listaGosciDoUsunięcia = new ArrayList<>();

        podajImiona("Podaj imiona które dopiszemy do Listy gości :", listaGosci, listaGosciDoUsunięcia, 5, "dodaj");

        System.out.println("Aktualnia lista Gości : ");
        System.out.println(listaGosci);

        podajImiona("Podaj imiona które dopiszemy do Listy gości :", listaGosci, listaGosciDoUsunięcia, 5, "dodaj");

        podajImiona("Podaj imiona które chcesz usunąć z  Listy gości :", listaGosci, listaGosciDoUsunięcia, 5, "usun");



        listaGosci.removeAll(listaGosciDoUsunięcia);

        System.out.println("Aktualnia lista Gości : ");
        System.out.println(listaGosci);


    }

    private static void podajImiona(String komunikat, List<String> listaGosci, List<String> listaGosciDoUsuniecia, int max, String akcja) {

        System.out.println(komunikat);

        if (akcja.equals("dodaj")) {
            max = max - listaGosci.size();
            System.out.println("Maksymalna ilośc miejsc :" + max);
        }

        if (akcja.equals("usun")) {
            max = listaGosci.size();
            System.out.println("Z tej listy możesz usunąć max :" + listaGosci.size());
        }

        System.out.println("Pusta linia kończy wprowadzanie.");
        Scanner scanner = new Scanner(System.in);
        String element;

        int counter = 1;
        boolean czyKoniec = false;
        boolean czyDodac = true;

        while (!czyKoniec) {
            element = scanner.nextLine();
            Pattern wzor = Pattern.compile("[0-9]");
            Matcher znajdywacz = wzor.matcher(element);
            czyDodac = true;

            if (element.isEmpty()) {
                if (akcja.equals("dodaj")) {
                    System.out.println("Koniec wprowadzania listy. Pozostało jeszcze wolnych miejsc :" + (max - counter + 1));
                }
                if (akcja.equals("usun")) {
                    System.out.println("Koniec wprowadzania listy do Usunięcia.");
                }
                break;
            }
            if (znajdywacz.find()) {
                System.out.println("W imionach nie ma liczb. Podaj poprawne dane albo skończ wprowadzanie.");
                czyDodac = false;
            }
            if (akcja.equals("dodaj")) {
                if (czyJuzJestnaLiscie(listaGosci, element)) {
                    System.out.println("Taka osoba już jest na Liscie. Podaj poprawne dane albo skończ wprowadzanie.");
                    czyDodac = false;
                }
            }

            if (akcja.equals("usun")) {
                if (!czyJuzJestnaLiscie(listaGosci, element)) {
                    System.out.println("Takiej osoby nie ma na Liscie więc jej nie usuniesz.");
                    czyDodac = false;
                }
            }

            if (czyDodac) {
                if (akcja.equals("dodaj")) {
                    listaGosci.add(element);
                    System.out.println("Dodano :" + element + " pozostało wolnych miejsc :" + (max - counter));
                }
                if (akcja.equals("usun")) {
                    listaGosciDoUsuniecia.add(element);
                    System.out.println("Dodano do usunięcia :" + element);
                }
                counter++;
                if (counter == max + 1) czyKoniec = true;
            }
        }
    }

    private static boolean czyJuzJestnaLiscie(List<String> lista, String poszukiwany) {
        boolean wynik = false;
        for (String element : lista) {
            if (element.equals(poszukiwany)) wynik = true;
        }
        return wynik;
    }

}