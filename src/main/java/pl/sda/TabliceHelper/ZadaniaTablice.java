package pl.sda.TabliceHelper;

import java.util.Arrays;

public class ZadaniaTablice {
    public static void main(String[] args) {

        TabliceInt tablica1 = new TabliceInt(51);
        TabliceInt tablica2 = new TabliceInt(30);


        tablica1.initRandomTable(100,200);
        tablica2.initRandomTable(150,200);
        //tablica1.viewTableInt();
        //tablica1.sortujTablice();
        //tablica1.viewTableInt();
        //tablica1.pomieszajTablice(20);
        //tablica1.viewTableInt();
        //System.out.println("Mediana tej tablicy to : "+tablica1.mediana());
        //tablica1.viewTableInt();
        //tablica1.wypiszWszystkiePodciagi(30);
        //System.out.println("Max dla tej tablicy to :" +tablica1.maxElement());
        //System.out.println("Min dla tej tablicy to :" +tablica1.minElement());
        //System.out.println("Suma elementów tej tablicy to :" +tablica1.sumaElementow());
        //System.out.println("Wartość średnia dla tej tablicy to :" +tablica1.wartoscSrednia());
        tablica1.usunDuplikaty();
        tablica1.viewTableInt();
        tablica2.usunDuplikaty();
        tablica2.viewTableInt();
        tablica1.czescWspolnaTablic(tablica2).viewTableInt();
    }

}
