package pl.sda.Elektronika;

public abstract class UrzadzenieElektroniczne {

  private   String serialNumber;
  private   String name;
  private   int cena;
  private   Kolor kolor;

    public UrzadzenieElektroniczne() {
    }

    public UrzadzenieElektroniczne(String serialNumber, String name, int cena, Kolor kolor) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.cena = cena;
        this.kolor = kolor;
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
}

enum Kolor{ BIAŁY,CZARNY,SZARY,CZERWONY,ZIELONY;}


