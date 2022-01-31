package pl.sda.Plansza;

public class Plansza {

    private int rozmiarX = 20;
    private int rozmiarY = 10;

    String[][] tablica = new String[rozmiarX][rozmiarY];

    public Plansza() {
    }

    public void rysujPlansze() {
        String znak = "";
        for (int i = 0; i < rozmiarY; i++) {
            for (int j = 0; j < rozmiarX; j++) {
                if (tablica[j][i] == null) znak = ".";
                else znak=tablica[j][i];
                System.out.print(znak);

            }
            System.out.println();
        }
    }

}
