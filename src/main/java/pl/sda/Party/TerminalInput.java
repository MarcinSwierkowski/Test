package pl.sda.Party;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalInput {

    private List<String> listaGosci;
    private List<String> listaGosciDoUsuniecia = new ArrayList<>();
    private int max;
    private String nazwaImprezy;
    private int actualMembersCount;

    public TerminalInput(List<String> listaGosci, int max, String nazwaImprezy, int actualMembersCount) {
        this.listaGosci = listaGosci;
        this.max = max;
        this.nazwaImprezy = nazwaImprezy;
        this.actualMembersCount = actualMembersCount;
    }

    public List<String> podajImiona(String akcja) {

        int counter = 1;
        boolean czyKoniec = false;
        boolean czyDodac = true;


        if (akcja.equals("dodaj")) {
            if (max == actualMembersCount) {
                czyKoniec = true;
                System.out.println("Ta impreza jest już pełna. Nie da się już dodać nowej osoby");
            }
        }

        if (akcja.equals("dodaj") && !czyKoniec) {

            System.out.println("Maksymalna ilośc miejsc na imprezę " + nazwaImprezy + " :" + max);
            max = max - listaGosci.size();
            System.out.println("Pozostała ilośc miejsc na imprezę " + nazwaImprezy + " :" + max);
            System.out.println("Podaj imiona które dopiszemy do listy gości :");
        }

        if (akcja.equals("usun")) {
            if (actualMembersCount == 0) {
                czyKoniec = true;
                System.out.println("Ta impreza jest pusta. Nie da się nic usunąć");
            }
        }

        if (akcja.equals("usun") && !czyKoniec) {
            max = listaGosci.size();
            System.out.println("Z tej listy możesz usunąć max :" + listaGosci.size());
        }


        Scanner scanner = new Scanner(System.in);
        String element;


        while (!czyKoniec) {
            System.out.println("Pusta linia kończy wprowadzanie.");
            element = scanner.nextLine();
            Pattern wzor = Pattern.compile("[0-9]");
            Matcher znajdywacz = wzor.matcher(element);
            czyDodac = true;

            if (element.isEmpty()) {
                if (akcja.equals("dodaj")) {
                    System.out.println("Koniec wprowadzania listy.");
                    System.out.println("Na imprezę " + nazwaImprezy + " pozostało jeszcze wolnych miejsc :" + (max - counter + 1));
                }
                if (akcja.equals("usun")) {
                    System.out.println("Koniec wprowadzania listy do usunięcia.");
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
                    System.out.println("Dodano :" + element);
                    System.out.println("Pozostało wolnych miejsc :" + (max - counter));
                }
                if (akcja.equals("usun")) {
                    listaGosciDoUsuniecia.add(element);
                    System.out.println("Dodano do usunięcia :" + element);
                    listaGosci.removeAll(listaGosciDoUsuniecia);
                }
                counter++;
                if (counter == max + 1) czyKoniec = true;
            }
        }
        Collections.sort(listaGosci);
        return listaGosci;
    }

    private boolean czyJuzJestnaLiscie(List<String> lista, String poszukiwany) {
        boolean wynik = false;
        for (String element : lista) {
            if (element.equals(poszukiwany)) wynik = true;
        }
        return wynik;
    }
}
