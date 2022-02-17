package pl.sda.Time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DataCzas {

public void helper(){

    LocalDateTime localDateTime1 = LocalDateTime.now();
    LocalDateTime localDateTime2 = LocalDateTime.parse("2015-05-30T18:54:23");

    System.out.println("LocalDateTime #1: " + localDateTime1);
    System.out.println("LocalDateTime #2: " + localDateTime2);

    // modyfikacja
    Period oneYearPeriod = Period.ofYears(1);
    LocalDateTime localDateTime1AfterYear = localDateTime1.plus(oneYearPeriod);
    System.out.println("Data i czas 'za rok': " + localDateTime1AfterYear);

    LocalDateTime localDateTime1Minus30Months = localDateTime1.minusMonths(30);
    System.out.println("Data i czas 'sprzed 30 miesięcy': " + localDateTime1Minus30Months);


    // formatowanie daty
    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println("Aktualna data (format domyślny): " + zonedDateTime);
    System.out.println("Aktualna data (format dd.MM.yyyy hh:mm): " + dtf1.format(zonedDateTime));

    // parsowanie daty - gotowy formatter (yyyy-MM-ddThh:mm)
    DateTimeFormatter dtf2 = DateTimeFormatter.ISO_DATE_TIME;
    LocalDateTime localDateTimeParsed = LocalDateTime.parse("2019-10-25T18:20", dtf2);
    System.out.println("Sparsowana LocalDateTime: " + localDateTimeParsed);

    // parsowanie daty - własny formatter z konkretną strefą czasową
    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
            .withZone(ZoneId.of("Europe/Warsaw"));
    ZonedDateTime zonedDateTimeParsed = ZonedDateTime.parse("10/25/2019 18:20", dtf3);
    System.out.println("Sparsowana ZonedDateTime: " + zonedDateTimeParsed);

}

}
