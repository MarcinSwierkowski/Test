package pl.sda.Dzieci;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TerminalGUI {

    private Grupa grupa;

    public TerminalGUI(Grupa grupa) {
        this.grupa = grupa;
    }

    public int selectMenu() {

        int opcja =0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------- MENU -----------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Dodaj dziecko do listy");
        System.out.println("2. Usuń dziecko z listy");
        System.out.println("3. Wyswielt liste dzieci.");
        System.out.println("4. Posortuj liste dzieci.");
        System.out.println("5. Wyczyść z duplikatow liste dzieci.");
        System.out.println("6. Zmien wszystkie litery imion dzieci na duże.");
        System.out.println("7. Zmien wszystkie litery imion dzieci na małe.");
        System.out.println("8. Koniec.");
        System.out.println("---------------------------------------------------");
        System.out.print("Wybierz 1-8 : ");

        try {
            opcja = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Wprowadź poprawną liczbę.");
            return 0;
        }
        return opcja;
    }

    public void clearMenu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public void runApp() {

        int wybor = 0;

        do {
            wybor = selectMenu();
            switch (wybor) {
                case 1:
                    System.out.println("Wybrałes 1.");
                    grupa.dodajDziecko(wpiszDziecko());
                    break;
                case 2:
                    System.out.println("Wybrałes 2.");
                    break;
                case 3:
                    System.out.println("Wybrałes 3.");
                    System.out.println(grupa);
                    break;
                case 4:
                    System.out.println("Wybrałes 4.");
                    grupa.sortuj();
                    break;
                case 5:
                    System.out.println("Wybrałes 5.");
                    break;
                case 6:
                    System.out.println("Wybrałes 6.");
                    break;
                case 7:
                    System.out.println("Wybrałes 7.");
                    break;
                case 8:
                    System.out.println("Wybrałes 8.");
                    clearMenu();
                    break;
                default:
                    System.out.println("Wybierz poprawnie 1-8");
            }
        } while (wybor != 8);


    }

    private Dziecko wpiszDziecko (){
        Scanner scanner = new Scanner(System.in);
        String linia = scanner.nextLine();
        String[] result = linia.split(" ");
        Dziecko element = new Dziecko(result[0],result[1]);
        System.out.println(result[0]+" : "+result[1]);
        return element;
    }


}
