package pl.sda.Kolekcje;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grupowanie {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jan", "Kowalski", "Wrocław"));
        customers.add(new Customer("Adam", "Nowak", "Warszawa"));
        customers.add(new Customer("Joanna", "Lipnicka", "Wrocław"));
        customers.add(new Customer("Adaś", "Miauczyński", "Sosnowiec"));

        Map<String, List<Customer>> customersByCityMap = customers.stream()
                .collect(Collectors.groupingBy(c -> c.getCity()));

        System.out.println("--- mapa wynikowa ---");
        System.out.println(customersByCityMap);

        List<Customer> customersFromWroclaw = customersByCityMap.get("Wrocław");
        System.out.println("--- klienci z Wrocławia ---");
        System.out.println(customersFromWroclaw);
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private String city;

    // konstruktory, gettery, settery
    public Customer(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "{" + firstName + " " + lastName + "}";
    }
}






