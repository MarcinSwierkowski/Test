package pl.sda.TabliczkaMnożenia;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TabliczkaMnozenia {
    private int n;
    private int m;
    private int[][] tabliczkaMnozeniaNxM;

    public TabliczkaMnozenia(int n, int m) {
        this.n = n;
        this.m = m;
        tabliczkaMnozeniaNxM = new int[n+1][m+1];
    }

    public void stworzTabliczkeMnozeniaNnaM() {
            for (int i = 1; i < this.n+1; i++) {
                for (int j = 1; j < this.m+1; j++)
                    this.tabliczkaMnozeniaNxM[i][j] = i * j;
            }
        }

        public void wypiszTabliczkeMnozeniaNnaM() {
            for (int i = 1; i < this.n+1; i++) {
                for (int j = 1; j < this.m+1; j++)
                    System.out.print(this.tabliczkaMnozeniaNxM[i][j]+"\t");
                System.out.println();
            }

        }

    }





