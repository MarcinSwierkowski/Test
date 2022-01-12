package pl.sda.Elektronika;

public class Telefon extends UrzadzenieElektroniczne implements Video {

    String software;
    Screen  screen;

    public Telefon() {
    }

    public Telefon(String serialNumber, String name, int cena, Kolor kolor, String software, Screen screen) {
        super(serialNumber, name, cena, kolor);
        this.software = software;
        this.screen = screen;
    }

    public Telefon(String serialNumber, String name, int cena, Kolor kolor, String software, int resolution, int height, int width) {
        super(serialNumber, name, cena, kolor);
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

class Screen {
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
