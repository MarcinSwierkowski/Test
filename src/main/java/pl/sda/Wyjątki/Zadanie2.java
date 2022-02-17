package pl.sda.Wyjątki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Zadanie2 {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src\\pl\\sda\\Wyjątki\\loty.txt"));
        List<Lot> listaLotow = new ArrayList<>();

        System.out.println("ROZMIAR POCZATKOWY "+strings.size());

        int i = 0;

        for (String line : strings) {
            if (i > 0) {

                try {
                    String[] tablica = line.split("\t");

                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

                    int id = Integer.parseInt(tablica[0]);
                    LocalDate dataWylotu = LocalDate.parse(tablica[1], dateFormatter);
                    LocalTime godzinaWylotu = LocalTime.parse(tablica[2], timeFormatter);
                    LocalDate dataPrzylotu = LocalDate.parse(tablica[3], dateFormatter);
                    LocalTime godzinaPrzylotu = LocalTime.parse(tablica[4], timeFormatter);
                    int zaladunek = Integer.parseInt(tablica[5]);
                    int wyladunek = Integer.parseInt(tablica[6]);

                    Lot myLot = Lot.builder()
                            .numer(id)
                            .dataWylotu(dataWylotu)
                            .godzinaWylotu(godzinaWylotu)
                            .dataPrzylotu(dataPrzylotu)
                            .godzinaPrzylotu(godzinaPrzylotu)
                            .zaladunek(zaladunek)
                            .wyladunek(wyladunek)
                            .build();

                    listaLotow.add(myLot);
                } catch (DateTimeParseException exception) {
                    System.out.println("Error loading data in line number " + i);
                }


            }
            i++;
        }

        System.out.println("ROZMIAR KONCOWY "+listaLotow.size());

    }
}
