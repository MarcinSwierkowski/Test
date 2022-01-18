package pl.sda.Elektronika;

import java.io.Serializable;

public class Telefon extends UrzadzenieElektroniczne implements Video, Serializable {

    String software;
    Screen  screen;

    public Telefon() {
    }



    public Telefon(String serialNumber, String name, int cena, Kolor kolor, String software, Screen screen, String marka) {
        super(serialNumber, name, cena, kolor,marka);
        this.software = software;
        this.screen = screen;
    }

    public Telefon(String serialNumber, String name, int cena, Kolor kolor, String marka, String software, int resolution, int height, int width) {
        super(serialNumber, name, cena, kolor, marka);
        this.software = software;
        this.screen = new Screen(resolution, height, width);
    }

    @Override
    void powerOn() {
        System.out.println("Telefon " + getName() + " został włączony ON");
    }

    @Override
    void powerOff() {
        System.out.println("Telefon " + getName() + " został wyłączony OFF");
    }

    @Override
    public void refresh() {
        System.out.println("Telefon " + getName() + " ekran został odświeżony REFRESH");
    }
}

class Screen implements Serializable{
     int resolution;
     int height;
     int width;

    public Screen(int resolution, int height, int width) {
        this.resolution = resolution;
        this.height = height;
        this.width = width;
    }

    public int getResolution() {
        return resolution;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
