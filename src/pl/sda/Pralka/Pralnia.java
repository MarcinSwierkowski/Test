package pl.sda.Pralka;

import java.util.List;

public class Pralnia {

    private List<Pralka> pralki;

    public Pralnia(List<Pralka> pralki){
        this.pralki = pralki;
    }
    public void wash(List<LaundryType> laundryTypes){
        Pralka pralka;
        LaundryType laundryType;
        for (int laundryNumber = 0;
             laundryNumber < pralki.size() && laundryNumber<laundryTypes.size();
             laundryNumber++) {

            pralka = pralki.get(laundryNumber); // weź pralkę o danym numerze
            laundryType = laundryTypes.get(laundryNumber); // weź pranie o danym numerze

            pralka.setLaundryType(laundryType); // skonfiguruj pralkę pod dane pranie
            pralka.start(); // zacznij prać

            // wydrukuj, kiedy skończysz to pranie
            System.out.println(laundryType + " skończę za " +
                    pralka.getMinutesTillEnd() + " minut");

        }
    }
}
