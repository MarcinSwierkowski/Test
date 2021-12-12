package pl.sda.TabliczkaMnożenia;

import java.util.Scanner;

public class ZadanieTabliczkaMnożenia {

    public static void main(String[] args) {


        TabliczkaMnozenia tabliczka1 = new TabliczkaMnozenia(wczytajLiczbeOdUsera("Podaj rozmiar n: "),wczytajLiczbeOdUsera("Podaj rozmiar m: "));
        tabliczka1.stworzTabliczkeMnozeniaNnaM();
        tabliczka1.wypiszTabliczkeMnozeniaNnaM();

    }

    public static int wczytajLiczbeOdUsera(String text) {
        System.out.println(text);
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        return number;
    }

}
