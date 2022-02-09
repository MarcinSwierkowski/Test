package pl.sda.Dzieci;

public class App {
    public static void main(String[] args) {

        IGrupa przedszkole = new Grupa("Misie");

        TerminalGUI menu = new TerminalGUI(przedszkole);
        menu.clearMenu();
        menu.runApp();
    }

}
