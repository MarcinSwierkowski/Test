package pl.sda.LiczbyIntHelper;

import java.util.Stack;

public class ZadaniaLiczby {

    public static void main(String[] args) {


        System.out.println(toBinary(124));

        System.out.println(toBinary2(124));



        for (int i = 1; i < 10; i++) {
            System.out.println(fib1(i));
        }

        fib2();


        zamien(5,8);

    }

    public static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static void fib2() {
        int a = 0;
        int b = 1;
        int wynik = 0;
        for (int i = 0; i < 10; i++) {
            wynik = a + b;
            System.out.println(wynik);
            a = b;
            b = wynik;
        }
    }

    public static void zamien (int a, int b){
        System.out.println("a = " + a + "  b = " + b);
        a = a - b;
        b = b + a;
        a = b - a;
        System.out.println("a = " + a + "  b = " + b);
    }

    public static String toBinary(int liczba){
        int[] tablica = new int[32];
        int i=0;

        while (liczba>0){
            tablica[i]= liczba%2;
            liczba = liczba/2;
            i++;
        }
        return wypiszTabliceOdTylu(tablica);
    }

    private static String wypiszTabliceOdTylu(int tab[]) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tab.length-1; i>=0; i--) {
            stringBuilder.append(tab[i]);
        }
        return stringBuilder.toString();
    }


    public static String toBinary2(int liczba) {

        Stack<Integer> stos = new Stack<>();
        StringBuilder liczbaBinarna = new StringBuilder();

        while (liczba>0){
            int reszta = liczba%2;
            stos.push(reszta);
            liczba=liczba/2;
        }

        while (!stos.isEmpty()){
            liczbaBinarna.append(stos.pop());
        }
        return liczbaBinarna.toString();
    }
}

