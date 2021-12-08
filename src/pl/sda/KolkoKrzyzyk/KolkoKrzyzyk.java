package pl.sda.KolkoKrzyzyk;

public class KolkoKrzyzyk {

    public static void main(String[] args) {


            int[][] planszaGry = new int[3][3];
            int[][] mapaPol = new int[3][3];


            wypelnijPlansze(mapaPol);
            wyswietlPlansze(mapaPol);
        }

        private static void wyswietlPlansze(int[][] plansza) {
        int k=1;
            System.out.println("+-------+");
            for(int i=0;i< plansza.length;i++) {
                System.out.print("|");
                for (int j = 0; j < plansza.length; j++) {
                    System.out.print(" "+ plansza[i][j] + "");
                    k++;
                }
                System.out.println(" |");
            }
            System.out.println("+-------+");
        }

    private static void wypelnijPlansze(int[][] plansza) {
        int k=1;
        for(int i=0;i< plansza.length;i++) {
            for (int j = 0; j < plansza.length; j++) {
                plansza[i][j]=k;
                k++;
            }
        }
    }
}
