package pl.sda.LiczbyIntHelper;

public class LiczbyInt {

    private int liczba;

    public LiczbyInt(int liczba) {
        this.liczba = liczba;
    }

      public String toBinary(){
            int[] tablica = new int[32];
            int i=0;
            int dalej;

            while (liczba!=0){
                tablica[i]= liczba%2;
                dalej = liczba/2;
                i++;
                liczba = dalej;
            }
            return wypiszTabliceOdTylu(tablica);
        }

        private String wypiszTabliceOdTylu(int tab[]) {
        StringBuilder stringBuilder = new StringBuilder();
            for (int i = tab.length-1; i>=0; i--) {
                stringBuilder.append(tab[i]);
            }
            return stringBuilder.toString();
        }
    }

