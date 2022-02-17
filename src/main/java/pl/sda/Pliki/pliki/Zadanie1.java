package pl.sda.Pliki.pliki;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Zadanie1 {

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        savePrimes("pierwsze.txt");
    }

    private static void savePrimes(String fileName) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileName);
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                printWriter.println(i);
            }
        }
        printWriter.close();
    }
}
