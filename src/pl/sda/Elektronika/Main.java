package pl.sda.Elektronika;

public class Main {
    public static void main(String[] args) {


        Radio radio1 = new Radio("SN123456","Yamaha RX 485 ",120,Kolor.BIAŁY,80,120);

        radio1.powerOn();
        radio1.powerOff();
        radio1.volumeDown();
        radio1.volumeUp();

        Screen ekran = new Screen(1024,800,72);

        Telefon telefon1 = new Telefon("SN558559","Samsung S8",250,Kolor.CZARNY,"Android 10",ekran);

        telefon1.powerOn();

        Telefon telefon2 = new Telefon("SN5534599","Samsung S9",350,Kolor.SZARY,"Android 12",2048,6000,300);


        Koszyk koszyk = new Koszyk();

        koszyk.dodajDoKoszyka(radio1);
        koszyk.dodajDoKoszyka(telefon1);
        koszyk.dodajDoKoszyka(telefon2);

        koszyk.wydrukujKoszyk();

    }
}
