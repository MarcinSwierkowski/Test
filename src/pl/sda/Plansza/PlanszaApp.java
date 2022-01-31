package pl.sda.Plansza;

import java.util.Random;

public class PlanszaApp {
    public static void main(String[] args) {


        Plansza plansza = new Plansza();
        Npc npc1 = new Npc(10,5,"X");
       // Npc npc2 = new Npc(9,1,"Y");
       // Npc npc3 = new Npc(13,3,"Z");
       // Npc npc4 = new Npc(8,7,"P");

        npc1.umiescNaPlanszy(plansza.tablica);
       // npc2.umiescNaPlanszy(plansza.tablica);
      //  npc3.umiescNaPlanszy(plansza.tablica);
       // npc4.umiescNaPlanszy(plansza.tablica);

        for (int i= 0; i <1000 ; i++) {
            npc1.idz();
            npc1.umiescNaPlanszy(plansza.tablica);
        }

        plansza.rysujPlansze();



    }

}
