package pl.sda.StringiHelper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelp {

    private String text;

    public StringHelp(String text) {
        this.text = text;
    }

    public void szyfrCezara(int offset) {

        int startDuze = 65;
        int startMale = 97;
        int ileLiter = 26;
        int znak;

        System.out.println(text);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') znak = ' ';
            else {
                znak = (text.charAt(i) + offset);
                if (znak >= (97 + 26)) {
                    znak = 97 + (znak % (97 + 26));
                }
            }
            System.out.print((char) znak);
        }
        System.out.println();
    }

    public void sprawdzNawiasy() {
        int ileOtwartych = 0;
        int ileZamknietych = 0;
        boolean pierwszyOtwarty = false;
        boolean ostatniZamkniety = false;
        int indexStart = 0;
        int indexStop = text.length() - 1;

        int i = indexStart;
        int j = indexStop;

        do {
            if (text.charAt(i) == '(') {
                pierwszyOtwarty = true;
                indexStart = i;
            }
            i++;
        } while (!pierwszyOtwarty);

        do {
            if (text.charAt(j) == ')') {
                ostatniZamkniety = true;
                indexStop = j;
            }
            j--;
        } while (!ostatniZamkniety);


        for (i = indexStart; i <= indexStop; i++) {
            if (text.charAt(i) == '(') {
                ileOtwartych++;
            }
            if (text.charAt(i) == ')') {
                ileZamknietych++;
            }
        }
        if (ileOtwartych == ileZamknietych) {
            System.out.println("Poprawne sparowanie nawiasów");
        } else System.out.println("Niepoprawne sparowanie nawiasów");
    }

    /*public void odwrocStringa() {
        if (text.length() == 0) return;
        System.out.print(text.charAt(text.length() - 1));
        odwrocStringa(text.substring(0, text.length() - 1));
    }*/

    //  PLAN metody liczenie wyrazów V2 Matcher
    //   robie toLower
    //   usuwam znaki , . : ;
    //   usuwam pojedyncze litery \s.\s
    //   usuwam Wielokrotne znaki białe litery \s.\s
    //   usuwam liczby
    //   mam czysty string do liczenia słow:
    //   petla
    //   biore 1 słowo ( zliczam szukaczem ile wystąpien ) wyswietlam słowo i ilość wystąpien
    //   usuwam ze stringa wejsciowego słowo1 koryguje stringa
    //   przepisuje nowy string na string do szukania i robie szukanie słowa 2 itd az do ostatniego słowa

    public void wypiszStatystykeTextuWyrazyV2() {

        String bezSmieci = text.toLowerCase().replaceAll("[,|.|:|;]", "");
        String bezLiter = bezSmieci.replaceAll("\\s[a-zA-Z]\\s", " ");
        String bezWielokrotnychBialychZnakow = bezLiter.replaceAll("\\s\\s+", " ");
        String bezLiczb = bezWielokrotnychBialychZnakow.replaceAll("[\\d]+", "");

        String wejsciowy = bezLiczb.trim().toLowerCase();
        int koniec;
        do {
            int i = 0;
            String[] aktualny = wejsciowy.split(" ");
            Pattern wzor = Pattern.compile("(\\s|^)" + aktualny[0] + "(\\s|$)");
            Matcher znajdywacz = wzor.matcher(wejsciowy);
            while (znajdywacz.find()) {
                i++;
            }
            System.out.println(aktualny[0] + " - " + i);
            wejsciowy = wejsciowy.replaceAll("(\\s|^)" + aktualny[0] + "(\\s|$)", " ");
            wejsciowy = wejsciowy.trim().replaceAll("\\s\\s+", "");
            koniec = wejsciowy.length();
        } while (koniec > 0);


    }

    public void usunWgRegex(String regex, String zamien) {

        System.out.println(text);
        System.out.println(text.replaceAll(regex, zamien));
    }

    public void zlacz(String text1, String text2) {
        System.out.println(text1 + text2);
        System.out.println(text1.trim().substring(2, text1.trim().length()) + text2.trim().substring(0, text2.trim().length() - 2));
    }

    // Plan szukania słów V1 split i tablica
    // przygotowywuje string do szukania czyli szyszczenie z .,:; i innych smieci usuwanie wielokrotnych znaków białych
    // do zrobienia: sprawdzić inne znaki białe poza spacjami...
    //   mam czysty string do liczenia słow:
    //   robie splita podział spacja mam tablice słów ( stringów )
    // petla w petli biore 0 element tablicy i porównuje ze sobą i resztą pól w tablicy. porównanie ze soba czyli zawsze 1
    // jak jest więcej takich samych to +1
    // jesli nizej w tablicy wystąpi powtarzający sie element to bedzie miał tyle samo wystąpien co wczesniejszy ten sam element
    // trzeba bedzie ten duplikat ustawic na 0 ( 0 bedzie decydowało o wypisaniu podsumowania )
    // mało optymalne ale działa
    // rozmiar tablicy narzuca split ze spacja rozdzielającą


   public void wypiszStatystykeTextuWyrazyV1() {

        String bezSmieci = text.toLowerCase().replaceAll("[,|.|:|;]", "");
        String bezLiter = bezSmieci.replaceAll("\\s[a-zA-Z]\\s", " ");
        String bezWielokrotnychBialychZnakow = bezLiter.replaceAll("\\s\\s+", " ");
        String bezLiczb = bezWielokrotnychBialychZnakow.replaceAll("[\\d]+", "");
        String[] podzielony = bezLiczb.split(" ");

        int[] tablicaIle = new int[podzielony.length];

        for (int i = 0; i < podzielony.length; i++) {
            for (int j = 0; j < podzielony.length; j++) {
                if (podzielony[i].equals(podzielony[j])) tablicaIle[i] += 1;
            }
        }
        znajdzDuplikat(podzielony, tablicaIle);
        wypiszTablicePionowo(podzielony, tablicaIle);
    }

    public void znajdzDuplikat(String[] tablicawyrazy, int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = i + 1; j < tablica.length; j++) {
                if (tablicawyrazy[i].equals(tablicawyrazy[j]) && tablica[i] == tablica[j]) {
                    tablica[j] = 0;
                }
            }
        }
    }


    public void wypiszTablicePionowo(String[] tab1, int[] tab2) {
        for (int i = 0; i < tab1.length; i++) {
            if (tab2[i] != 0) {
                System.out.println(tab1[i] + " - " + tab2[i]);
            }
        }
    }

    public void wypiszStatystykeTextuLitery() {

        int[] tablica = new int[256];
        int startDuze = 65;
        int startMale = 97;
        int ileLiter = 26;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < 255) {
                tablica[(int) text.charAt(i)] += 1;
            }
        }
        wypiszTablice(startMale, ileLiter, tablica);
        System.out.println();
        wypiszTablice(startDuze, ileLiter, tablica);

    }

    public void wypiszTablice(int start, int ileLiter, int[] table) {
        for (int i = start; i < ileLiter + start; i++) {
            if (table[i] != 0) {
                System.out.print((char) i + "\t");
            }
        }
        System.out.println();
        for (int i = start; i < ileLiter + start; i++) {
            if (table[i] != 0) {
                System.out.print(table[i] + "\t");
            }
        }
        System.out.println();
    }

}



