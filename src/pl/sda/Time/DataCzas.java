package pl.sda.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataCzas {

    private LocalDate data;

    public DataCzas(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }
}
