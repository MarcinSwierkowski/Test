package pl.sda.Wyjątki;

import java.math.BigInteger;

public class Zadanie1 {
    public static long silnia(int number) {
        long result = 1;
        try {
            if (number > 99) throw new SilniaException("Za dużo");
            for (int i = 2; i <= number; i++) {
                result = result * i;
            }
        } catch (SilniaException ex) {
            System.out.println("Catch");
        }
        return result;
    }

    public static BigInteger silniaBig(BigInteger number) {
        BigInteger result = new BigInteger("1");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        for (BigInteger i = two; i.compareTo(number)<=0; i=i.add(one)) {
            result = result.multiply(i);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(silnia(100));

        System.out.println(silniaBig(new BigInteger("33")));
    }
}
