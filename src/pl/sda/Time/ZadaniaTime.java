package pl.sda.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ZadaniaTime {

    public static void main(String[] args) {

        LocalDate teraz = LocalDate.now();
        LocalDate zajeciaPoSwietach = LocalDate.of(2022,1,10);
        LocalDate zajeciaPoSwietach2 = LocalDate.parse("2022-01-10");

        Data nowa = new Data();

        nowa.roznicaData(teraz,zajeciaPoSwietach);
        nowa.roznicaData(teraz,zajeciaPoSwietach2);

        LocalTime terazCzas = LocalTime.now();
        System.out.println(terazCzas);




//
//
//        LocalDate urodziny = DataCzaspodajDateUrodzenia("Podaj datę urodzenia w formacie yyyy-mm-dd ");
//        Data dataUrodzin = new Data(urodziny);
//
//        System.out.println(dataUrodzin.getData());
//
//        Data dataUrodzin2 = new Data();
//
//        dataUrodzin2.DataCzaspodajDateUrodzenia1("Podaj datę urodzenia w formacie yyyy-mm-dd ");
//
//        System.out.println(dataUrodzin2.getData());
//
//        wiek=wiekodpowiedz("Czy palisz papierosy 1-TAK / 0 -NIE : ");



    }

    private static LocalDate DataCzaspodajDateUrodzenia(String pytanie) {
        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(data);
        return localDate;
    }


    private static boolean odpowiedz(String pytanie) {
        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        int odpowiedz = scanner.nextInt();
        if (odpowiedz==1) return true;
        else return false;
    }



}
