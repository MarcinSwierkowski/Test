package pl.sda.Lambdy;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Mniejsze niż 50:");
        wydrukujLiczby(new SprawdzaLiczbe() {
            public boolean sprawdzLiczbe(int number) {
                return number <50;
            }
        });

        System.out.println("Mniejsze niż 50:");
        wydrukujLiczby(number -> number <50);

        System.out.println("Parzyste :");
        wydrukujLiczby(new SprawdzaLiczbe() {
            public boolean sprawdzLiczbe(int number) {
                return number % 2 == 0;
            }
        });

        System.out.println("Parzyste :");
        wydrukujLiczby(number -> number % 2 == 0);
    }

    // metoda drukująca liczby od 40 do 60 spełniające podany warunek
    public static void wydrukujLiczby(SprawdzaLiczbe sprawdz) {
        for (int i = 40; i <= 60; i++) {
            // sprawdzenie warunku - wykonanie metody
            // sprawdzaLiczbe przekazanego obiektu
            if (sprawdz.sprawdzLiczbe(i)) {
                System.out.println(i);
            }
        }
    }

}
