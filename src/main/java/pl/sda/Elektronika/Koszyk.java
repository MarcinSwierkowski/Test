package pl.sda.Elektronika;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Koszyk {

    List<UrzadzenieElektroniczne> listOfDevices = new ArrayList<>();
    Set<String> markiUrzadzen = new HashSet<>();

    void dodajDoKoszyka(UrzadzenieElektroniczne device){
        listOfDevices.add(device);
        markiUrzadzen.add(device.getMarka());
    }
    
    void wydrukujKoszyk(){
        for (UrzadzenieElektroniczne device: listOfDevices) {
            System.out.println(device.getName()+" "+device.getCena()+" zł.");
        }
    }

    void wydrukujMarkiUrzadzen(){
        for (String marki: markiUrzadzen) {
            System.out.println(marki);
        }
    }

}
