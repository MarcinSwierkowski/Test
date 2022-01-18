package pl.sda.Lambdy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static final List<String> CUSTOMERS = Arrays.asList("Ania", "Piotrek", "Mateusz", "Kasia", "Tomek");

    public static void main(String[] args) {
        System.out.println("--- WYPISANIE KLIENTÓW ---");
        // dla każdego klienta 'c' wykonaj `System.out.println(c);'
        performOnAllCustomers(c -> System.out.println(c));

        System.out.println("--- WYPISANIE KLIENTÓW DUŻYMI LITERAMI ---");
        // dla każdego klienta 'c' wykonaj `System.out.println(c.toUpperCase());'
        performOnAllCustomers(c -> System.out.println(c.toUpperCase()));

        System.out.println("--- WYPISANIE DŁUGOŚCI IMION KLIENTÓW ---");
        performOnAllCustomers(c -> System.out.println(c + ": " + c.length()));

    }

    public static void performOnAllCustomers(Consumer<String> consumer) {
        for (String customer : CUSTOMERS) {
            consumer.accept(customer);
        }
    }

}
