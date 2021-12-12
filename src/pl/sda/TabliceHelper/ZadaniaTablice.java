package pl.sda.TabliceHelper;

import java.util.Arrays;

public class ZadaniaTablice {
    public static void main(String[] args) {

        TabliceInt tablica1 = new TabliceInt(51);

        tablica1.initRandomTable(100,200);
        tablica1.viewTableInt();
        tablica1.sortujTablice();
        tablica1.viewTableInt();
        tablica1.pomieszajTablice(20);
        tablica1.viewTableInt();
        System.out.println(tablica1.mediana());
        tablica1.viewTableInt();

    }

}
