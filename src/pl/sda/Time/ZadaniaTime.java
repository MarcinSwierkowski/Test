package pl.sda.Time;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ZadaniaTime {

    public static void main(String[] args) {

        Data teraz = new Data(LocalDate.now());
        Data zajeciaPoSwietach = new Data(LocalDate.of(2022,1,10));


        teraz.roznicaData(zajeciaPoSwietach);


        LocalDate urodziny = DataCzaspodajDateUrodzenia("Podaj datę urodzenia w formacie yyyy-mm-dd ");
        Data dataUrodzin = new Data(urodziny);
    }

    private static LocalDate DataCzaspodajDateUrodzenia(String pytanie) {
        System.out.println(pytanie);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(data);
        return localDate;
    }


}
