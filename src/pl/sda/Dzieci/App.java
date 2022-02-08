package pl.sda.Dzieci;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Grupa przedszkole = new Grupa("Misie",10);

        TerminalGUI menu = new TerminalGUI(przedszkole);
        menu.clearMenu();
        menu.runApp();
    }

}
