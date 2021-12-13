package pl.sda.Time;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ZadaniaTime {

    public static void main(String[] args) {

        DataCzas teraz = new DataCzas(LocalDate.now());
        DataCzas zajeciaPoSwietach = new DataCzas(LocalDate.of(2022,1,6));


        Period period = Period.between(teraz.getData(), zajeciaPoSwietach.getData());

        System.out.print("Do następnych zajęć pozostało : ");
        System.out.print(period.getYears() + " lat, ");
        System.out.print(period.getMonths() + " miesięcy, ");
        System.out.print(period.getDays() + " dni");

        System.out.println();


        LocalDate urodziny = DataCzaspodajDateUrodzenia("Podaj datę urodzenia w formacie yyyy-mm-dd ");
        System.out.println(urodziny);
    }

    private static LocalDate DataCzaspodajDateUrodzenia(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(data);
        return localDate;
    }


}
