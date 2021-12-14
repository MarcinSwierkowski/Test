package pl.sda.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataCzas {

    private LocalDate dataCzas;

    public DataCzas(LocalDate dataCzas) {
        this.dataCzas = dataCzas;
    }

    public LocalDate getDataCzas() {
        return dataCzas;
    }
}
