package pl.sda.Time;

import java.time.LocalDate;
import java.time.Period;

public class Data {

    private LocalDate data;

    public Data(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void roznicaData(Data data) {

        Period period = Period.between(this.data,data.data);

        System.out.print("Do następnych zajęć pozostało : ");
        System.out.print(period.getYears() + " lat, ");
        System.out.print(period.getMonths() + " miesięcy, ");
        System.out.print(period.getDays() + " dni");
    }


}
