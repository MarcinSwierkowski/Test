package pl.sda.TabliceHelper;

import java.util.Arrays;

public class TabliceInt {

    private int size;
    private int[] tablica;

    public TabliceInt(int size) {
        this.size = size;
        this.tablica = new int[size];
    }

    public TabliceInt() {
    }

    public void initRandomTable(int rangeDown, int rangeUp) {
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = (int) (Math.random() * (rangeUp - rangeDown) + rangeDown);
        }

    }

    public void viewTableInt() {
        for (int j : tablica) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public void viewTableInt(int[] tablica) {
        for (int j : tablica) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public void sortujTablice() {
        for (int j = 0; j < tablica.length - 1; j++) {
            for (int i = 0; i < tablica.length - 1; i++) {
                int aktualna = tablica[i];
                int nastepna = tablica[i + 1];

                if (aktualna > nastepna) {
                    tablica[i] = nastepna;
                    tablica[i + 1] = aktualna;
                }
            }
        }
    }

    public void sortujTablice(int[] tablica) {
        for (int j = 0; j < tablica.length - 1; j++) {
            for (int i = 0; i < tablica.length - 1; i++) {
                int aktualna = tablica[i];
                int nastepna = tablica[i + 1];

                if (aktualna > nastepna) {
                    tablica[i] = nastepna;
                    tablica[i + 1] = aktualna;
                }
            }
        }
    }

    // wyliczając mediane nie chcemy modyfikować tablicy wiec wprowadzamy tablice pomocniczą
    // int[] kopia = (int[])oryginal.clone();
    public double mediana() {

        int[] pomocniczaTablica = tablica.clone();
        sortujTablice(pomocniczaTablica);

        if (pomocniczaTablica.length % 2 == 0) {
            return (pomocniczaTablica[pomocniczaTablica.length / 2] + pomocniczaTablica[(pomocniczaTablica.length / 2) - 1]) / 2.0;
        }
        return pomocniczaTablica[pomocniczaTablica.length / 2];
    }

    public void usunDuplikaty() {
        int[] duplikatyIndex = new int[size];
        int nowyRozmiar = 0;
        for (int i = 0; i < tablica.length; i++) {
            for (int j = i; j < tablica.length; j++) {
                if (tablica[i] == tablica[j])
                    duplikatyIndex[i] += 1;
            }
        }
        for (int i = 0; i < tablica.length; i++) {
            if (duplikatyIndex[i] == 1)
                nowyRozmiar += 1;
        }
        int[] tablicaBezDuplikatow = new int[nowyRozmiar];
        int count = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (duplikatyIndex[i] == 1) {
                tablicaBezDuplikatow[count] = tablica[i];
                count++;
            }
        }
        tablica=tablicaBezDuplikatow;
    }

    public TabliceInt czescWspolnaTablic(TabliceInt tablica2){
        int nowyRozmiar=0;
        for (int i = 0; i <this.tablica.length ; i++) {
            for (int j = 0; j < tablica2.tablica.length; j++) {
                if (this.tablica[i]==tablica2.tablica[j])
                    nowyRozmiar += 1;
            }
        }
        TabliceInt tablicaWspolne = new TabliceInt(nowyRozmiar);

        int count =0;

        for (int i = 0; i <this.tablica.length ; i++) {
            for (int j = 0; j < tablica2.tablica.length; j++) {
                if (this.tablica[i]==tablica2.tablica[j]) {
                    tablicaWspolne.tablica[count] = this.tablica[i];
                count++;
                }
            }
        }
        return tablicaWspolne;
    }

    public void wypiszWszystkiePodciagi(int dlugosc) {

        for (int i = 0; i <= tablica.length - dlugosc; i++) {
            for (int j = 0; j < dlugosc; j++) {
                System.out.print(tablica[i + j] + "\t");
            }
            System.out.println();
        }
    }

    public int maxElement() {
        int max = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > max) {
                max = tablica[i];
            }
        }
        return max;
    }

    public int minElement() {
        int min = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            }
        }
        return min;
    }


    public int sumaElementow() {
        int wynik = 0;
        for (int i = 0; i < tablica.length; i++)
            wynik = wynik + tablica[i];
        return wynik;
    }


    public double wartoscSrednia() {
        return sumaElementow() / tablica.length;
    }

    public void pomieszajTablice(int ileRazy) {
        for (int j = 0; j < ileRazy; j++) {
            for (int i = 0; i < tablica.length - 1; i++) {
                int aktualna = tablica[i];
                int nastepna = tablica[i + 1];
                int a = (int) (Math.random() * 2.0);
                if (a > 0) {
                    tablica[i] = nastepna;
                    tablica[i + 1] = aktualna;
                }
            }
        }
    }
}





