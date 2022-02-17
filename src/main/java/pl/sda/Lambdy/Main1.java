package pl.sda.Lambdy;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Mniejsze niż 50:");
        wydrukujLiczby(new MniejszeOd50());

        System.out.println("Parzyste :");
        wydrukujLiczby(new Parzyste());
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

// plik SprawdzaLiczbe.java
interface SprawdzaLiczbe {
    boolean sprawdzLiczbe(int number);
}

// plik mniejszy od 50.java
class MniejszeOd50 implements SprawdzaLiczbe {
    @Override
    public boolean sprawdzLiczbe(int number) {
        return number < 50;
    }
}

// plik parzysty.java
class Parzyste implements SprawdzaLiczbe {
    @Override
    public boolean sprawdzLiczbe(int number) {
        return number % 2 == 0;
    }
}
