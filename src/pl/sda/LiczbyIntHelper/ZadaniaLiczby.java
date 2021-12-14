package pl.sda.LiczbyIntHelper;

public class ZadaniaLiczby {

    public static void main(String[] args) {

        //LiczbyInt liczba = new LiczbyInt(556);
        //System.out.println(liczba.toBinary());

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
}

