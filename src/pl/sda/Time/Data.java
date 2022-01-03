package pl.sda.Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Data {

    public void roznicaData(LocalDate data1, LocalDate data2) {

        Period period = Period.between(data1,data2);

        System.out.print("Do następnych zajęć pozostało : ");
        System.out.print(period.getYears() + " lat, ");
        System.out.print(period.getMonths() + " miesięcy, ");
        System.out.print(period.getDays() + " dni");
        System.out.println();
    }

    public void helper(){

        // aktualna data
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Local date #1: " + localDate1);

        // data podawana jako liczby rok-miesiąc-dzień
        LocalDate localDate2 = LocalDate.of(2019, 5, 25);
        System.out.println("Local date #2: " + localDate2);

        // data podawana text w formacie ISO
        LocalDate localDate3 = LocalDate.parse("2019-06-13");
        System.out.println("Local date #3: " + localDate3);





        LocalDate localDate = LocalDate.now();
        System.out.println("Aktualna data: " + localDate);

        LocalDate tomorrowDate = localDate.plusDays(1);
        System.out.println("Jutrzejsza data: " + tomorrowDate);

        LocalDate date3WeeksBefore = localDate.minusWeeks(3);
        System.out.println("Date sprzed 3 tygodni: " + date3WeeksBefore);

        LocalDate date5MonthsBefore = localDate.minusMonths(5);
        System.out.println("Data sprzed 5 miesięcy: " + date5MonthsBefore);

        LocalDate date6YearsAfter = localDate.plus(6, ChronoUnit.YEARS);
        System.out.println("Data za 6 lat: " + date6YearsAfter);

        LocalDate date50DaysBefore = localDate.minus(50, ChronoUnit.DAYS);
        System.out.println("Data sprzed 50 dni: " + date50DaysBefore);


        Period period1 = Period.of(1, 11, 15);
        System.out.println("Okres 1 roku, 11 miesięcy i 15 dni: " + period1);


        //Period


        LocalDate localDate10 = LocalDate.parse("2019-05-02");
        LocalDate localDate20 = LocalDate.parse("2015-01-28");
        System.out.println("Data #1: " + localDate10);
        System.out.println("Data #2: " + localDate20);

        // okres pomiędzy dwiema datami
        Period period2 = Period.between(localDate10, localDate20);
        System.out.println("Okres pomiędzy datami #1 i  #2: " + period2);


        LocalDate localDateNow = LocalDate.now();

        // dodanie okresu do daty
        LocalDate datePlusPeriod1 = localDateNow.plus(period1);
        System.out.println("Aktualna data plus okres 1: " + datePlusPeriod1);

        // odjęcie okresu od daty
        LocalDate dateMinusPeriod2 = localDateNow.minus(period2);
        System.out.println("Aktualna data minus okres 2: " + dateMinusPeriod2);




    }

}
