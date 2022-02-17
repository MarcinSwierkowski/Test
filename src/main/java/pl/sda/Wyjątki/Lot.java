package pl.sda.Wyjątki;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
public class Lot {
    private int numer;
    private LocalDate dataWylotu;
    private LocalTime godzinaWylotu;
    private LocalDate dataPrzylotu;
    private LocalTime godzinaPrzylotu;
    private int zaladunek;
    private int wyladunek;
}
