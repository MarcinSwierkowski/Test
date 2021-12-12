package pl.sda.TabliceHelper;

public class TabliceInt {

    private int size;
    private int[] tablica;

    public TabliceInt(int size) {
        this.size = size;
        this.tablica = new int[size];
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

    public double mediana() {
        sortujTablice();
        if (tablica.length % 2 == 0) {
            return (tablica[tablica.length / 2] + tablica[(tablica.length / 2) - 1]) / 2.0;
        }
        return tablica[tablica.length / 2];
    }

    public static void wypiszWszystkiePodciagi(int dlugosc, int[] table) {

        for (int i = 0; i <= table.length - dlugosc; i++) {
            for (int j = 0; j < dlugosc; j++) {
                System.out.print(table[i + j] + "\t");
            }
            System.out.println();
        }
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





