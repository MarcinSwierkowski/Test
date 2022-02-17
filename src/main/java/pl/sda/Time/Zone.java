package pl.sda.Time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Zone {

    public void helper(){

        // aktualna z domyślną strefą
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println("Aktualny czas w strefie komputera (serwera): " + zonedDateTime1);

        // aktualna w konretnej strefie
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Poland"));
        System.out.println("Aktualny czas w strefie czasowej Polski: " + zonedDateTime2);

        // na podstawie LocalDateTime w konkretnej strefie
        LocalDateTime localDateTime = LocalDateTime.parse("2015-05-30T14:20:50");
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime, ZoneId.of("Japan"));
        System.out.println("Data '2015-05-30T14:20:50' w strefie czasowej Japoni: " + zonedDateTime3);





        LocalDateTime localDepartureTime = LocalDateTime.parse("2019-05-22T15:00:00");
        ZoneId departureZone = ZoneId.of("Europe/Warsaw");
        ZonedDateTime departureTime = ZonedDateTime.of(localDepartureTime,departureZone);

        System.out.println("Data i czas odlotu w strefie czasowej Polski: " + departureTime);

        ZonedDateTime arrivalTime = departureTime.plusHours(7);
        System.out.println("Data i czas przylotu w strefie czasowej Polski: " + arrivalTime);

        ZonedDateTime arrivalTimeTokyo = arrivalTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Data i czas przylotu w strefie czasowej Tokyo: " + arrivalTimeTokyo);


    }

}
