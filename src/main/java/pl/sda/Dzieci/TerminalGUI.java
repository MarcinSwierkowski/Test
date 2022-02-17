package pl.sda.Dzieci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalGUI {

    private final static String MENU = "---------------------- MENU -----------------------\n"
            + "---------------------------------------------------\n"
            + "1. Dodaj dziecko do listy\n"
            + "2. Usuń dziecko z listy\n"
            + "3. Wyswielt liste dzieci.\n"
            + "4. Posortuj liste dzieci.\n"
            + "5. Wyczyść z duplikatow liste dzieci.\n"
            + "6. Zmien wszystkie litery imion dzieci na duże.\n"
            + "7. Zmien wszystkie litery imion dzieci na małe.\n"
            + "8. Koniec.\n"
            + "---------------------------------------------------\n"
            + "Wybierz 1-8 : ";


    private IGrupa grupa;

    public TerminalGUI(IGrupa grupa) {
        this.grupa = grupa;
    }

    public int selectMenu() {

        System.out.println(MENU);

        int opcja = 0;
        try {
            opcja = WprowadzNumer();
        } catch (InputMismatchException e) {
            System.out.println("Wprowadź poprawną liczbę.");
            return 0;
        }
        return opcja;
    }

    public void clearMenu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
            //drukuje 20 pustych lini zeby to jakoś wyglądało
        }
    }

    public void runApp() {

        int wybor = 0;

        do {
            wybor = selectMenu();
            switch (wybor) {
                case 1:
                    System.out.println("Podaj Imię dziecka i po spacji PESEL :");
                    grupa.dodajDziecko(wpiszDziecko());
                    break;
                case 2:
                    System.out.println("Podaj Imię dziecka i po spacji PESEL :");
                    grupa.usunDziecko(wpiszDziecko());
                    break;
                case 3:
                    System.out.println("Wydruk Listy");
                    System.out.println(grupa);
                    break;
                case 4:
                    System.out.println("Sortowanie");
                    grupa.sortuj();
                    break;
                case 5:
                    System.out.println("Usuń duplikaty");
                    grupa.usunDuplikaty();
                    break;
                case 6:
                    System.out.println("Zamien imiona na duże litery");
                    grupa.touper();
                    break;
                case 7:
                    System.out.println("Zamien imiona na małe litery");
                    grupa.tolower();
                    break;
                case 8:
                    System.out.println("Koniec");
                    clearMenu();
                    break;
                default:
                    System.out.println("Wybierz poprawnie 1-8");
            }
        } while (wybor != 8);


    }

    private Dziecko wpiszDziecko() {
        String[] result = WprowadzStringa().split(" ");
        Dziecko element = new Dziecko(result[0], result[1]);
        System.out.println(result[0] + " : " + result[1]);
        return element;
    }

    private String WprowadzStringa() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int WprowadzNumer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
