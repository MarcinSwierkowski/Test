package pl.sda.Elektronika;

import java.io.Serializable;

public class Radio extends UrzadzenieElektroniczne implements Audio, Serializable {

  private   int minFrequency;
  private   int maxFrequency;

    public Radio() {
    }

    public Radio(String serialNumber, String name, int cena, Kolor kolor,String marka, int minFrequency, int maxFrequency) {
        super(serialNumber, name, cena, kolor,marka);
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
    }

    @Override
    void powerOn() {
        System.out.println("Radio " + getName() + " zostało włączone ON");
    }

    @Override
    void powerOff() {
        System.out.println("Radio " + getName() + " zostało wyłączone OFF");
    }


    @Override
    public void volumeUp() {
        System.out.println("Radio " + getName() + " VolumeUp");
    }

    @Override
    public void volumeDown() {
        System.out.println("Radio " + getName() + " VolumeDown");
    }

    @Override
    public String toString() {
        return "Radio{" +
                "minFrequency=" + minFrequency +
                ", maxFrequency=" + maxFrequency +
                '}';
    }
}
