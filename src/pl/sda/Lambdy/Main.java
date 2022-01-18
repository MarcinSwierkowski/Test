package pl.sda.Lambdy;

public class Main {

    public static void main(String[] args) {

        System.out.println("Czy 33 mniejsze od 50: " + isLessThan50(33));
        System.out.println("Czy 66 mniejsze od 50: " + isLessThan50(66));
        System.out.println("Czy 33 parzyste: " + isNumberEven(33));
        System.out.println("Czy 66 parzyste: " + isNumberEven(66));


    }

    public static boolean isLessThan50(int number) {
        return number < 50;
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

}
