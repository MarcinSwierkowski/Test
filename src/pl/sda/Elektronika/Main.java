package pl.sda.Elektronika;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Radio radio1 = new Radio("SN123456","Yamaha RX 485 ",120,Kolor.BIAŁY,"Yamaha",80,120);

        radio1.powerOn();
        radio1.powerOff();
        radio1.volumeDown();
        radio1.volumeUp();

        Screen ekran = new Screen(1024,800,72);

        Telefon telefon1 = new Telefon("SN558559","Samsung S8",250,Kolor.CZARNY,"Android 10",ekran,"Samsung");

        telefon1.powerOn();

        Telefon telefon2 = new Telefon("SN5534599","Samsung S9",350,Kolor.SZARY,"Samsung","Android 12",2048,6000,300);


        Koszyk koszyk = new Koszyk();

        koszyk.dodajDoKoszyka(radio1);
        koszyk.dodajDoKoszyka(telefon1);
        koszyk.dodajDoKoszyka(telefon2);
        System.out.println();
        System.out.println("Co mamy w koszyku ?");
        koszyk.wydrukujKoszyk();
        System.out.println();
        System.out.println("Posiadane Marki Sprzętu:");
        koszyk.wydrukujMarkiUrzadzen();


        System.out.println("SERIALIZACJA i DESERIALIZACJA");

        serializujObiekt("objekt.txt",telefon1);
        deSerializujObiekt("objekt.txt",telefon1);





    }

    private static void deSerializujObiekt(String nazwa_pliku, UrzadzenieElektroniczne object) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nazwa_pliku);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UrzadzenieElektroniczne deserializedDevice = (UrzadzenieElektroniczne) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(deserializedDevice);

    }

    private static void serializujObiekt(String nazwa_pliku, UrzadzenieElektroniczne object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nazwa_pliku);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        fileOutputStream.flush();
        objectOutputStream.close();
        System.out.println(object);
    }


}
