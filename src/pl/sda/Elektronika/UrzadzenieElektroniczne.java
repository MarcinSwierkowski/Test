package pl.sda.Elektronika;

import java.io.Serializable;

public abstract class UrzadzenieElektroniczne implements Serializable {

  private   String serialNumber;
  private   String name;
  private   int cena;
  private   Kolor kolor;
  private   String marka;

    public UrzadzenieElektroniczne() {
    }

    public UrzadzenieElektroniczne(String serialNumber, String name, int cena, Kolor kolor, String marka) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.cena = cena;
        this.kolor = kolor;
        this.marka = marka ;
    }

    abstract void powerOn();
    abstract void powerOff();

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getCena() {
        return cena;
    }

    public Kolor getKolor() {
        return kolor;
    }

    public String getName() {
        return name;
    }

    public String getMarka() {
        return marka;
    }

    @Override
    public String toString() {
        return "UrzadzenieElektroniczne{" +
                "serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", cena=" + cena +
                ", kolor=" + kolor +
                ", marka='" + marka + '\'' +
                '}';
    }
}

enum Kolor{ BIAŁY,CZARNY,SZARY,CZERWONY,ZIELONY;}


