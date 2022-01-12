package pl.sda.Elektronika;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Koszyk {

    List<UrzadzenieElektroniczne> listOfDevices = new ArrayList<>();

    void dodajDoKoszyka(UrzadzenieElektroniczne device){
        listOfDevices.add(device);
    }
    
    void wydrukujKoszyk(){
        for (UrzadzenieElektroniczne device:
             listOfDevices) {
            System.out.println(device.getName());
        }
    }

}
