package pl.sda.KolkoKrzyzyk;

import java.util.Scanner;

public class PlanszaXO {
    private int[][] plansza;
    private int winner;

    public PlanszaXO() {
        plansza = new int[3][3];
        winner = 0;                 //0 - remis, 1-X,  2-O
    }

    private int[][] wygrane = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}};

    private boolean czyWygral(char znak, int[][] wygrane) {
        boolean wygral = false;
        for (int i = 0; i < 8; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (plansza[(wygrane[i][j] - 1) / 3][(wygrane[i][j] - 1) % 3] == znak) {
                    count++;
                }
                if (count == 3) wygral = true;
            }
        }
        if(wygral){
        if(znak=='X') winner=1;
        if(znak=='O') winner=2;}
        return wygral;

    }
    // mozna by dodać kolory dla X i O zeby nie zlewały się z 1,2,3...,9

    private void wyswietlPlansze() {
        System.out.println("+-------+");
        for (int i = 0; i < plansza.length; i++) {
            System.out.print("|");
            for (int j = 0; j < plansza.length; j++) {
                System.out.print(" " + (char) plansza[i][j] + "");
            }
            System.out.println(" |");
        }
        System.out.println("+-------+");
    }

    public void initGame() {
        int k = 0;
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza.length; j++) {
                plansza[i][j] = (int) '1' + k;
                k++;
            }
        }
    }

    private void ktoWygral() {
        switch (winner) {
            case 0:
                System.out.println("Remis nikt nie wygrał.");
                break;
            case 1:
                System.out.println("Zwycięzcą jest X krzyżyk.");
                break;
            case 2:
                System.out.println("Zwycięzcą jest O kółko.");
                break;
        }
    }

    public void startGame() {
        System.out.println("Rozpoczyna X ");
        char znak;
        int poprawnePole;
        int ruch =0;
        do {
            if(ruch%2==0)
                znak='X';
                else znak ='O';

            wyswietlPlansze();
            do {
                poprawnePole = wybierzPole(znak);

            }while (czyPoleZajete(poprawnePole));

            postawZnak(poprawnePole,znak);
            ruch++;

        } while (!czyWygral('X', wygrane) && !czyWygral('O', wygrane) && ruch < 9);
        wyswietlPlansze();
        ktoWygral();
    }

        public void postawZnak ( int numer, char znak){
            plansza[(numer - 1) / 3][(numer - 1) % 3] = znak;
        }

    public boolean czyPoleZajete ( int numer){
        if((plansza[(numer - 1) / 3][(numer - 1) % 3] !='X') && (plansza[(numer - 1) / 3][(numer - 1) % 3] !='O'))
            return false;
        else {
            System.out.println("Pole zajęte podaj wolne pole.");
            return true;}
        }

        public int wybierzPole ( char znak){
            System.out.println("Gdzie chcesz postawić " + znak + " ?");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
    }


