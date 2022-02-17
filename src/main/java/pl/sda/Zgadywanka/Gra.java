package pl.sda.Zgadywanka;

import java.util.Scanner;

public class Gra {

    private int liczbaDoOgdadniecia;
    private int zakresOd;
    private int zakresDo;
    private int liczbaWprowadzona;
    private int ileProb;

    //   public Gra(int liczbaDoOgdadniecia, int zakresOd, int zakresDo, int liczbaWprowadzona,int ileProb) {
    //       this.liczbaDoOgdadniecia = liczbaDoOgdadniecia;
    //       this.zakresOd = zakresOd;
    //       this.zakresDo = zakresDo;
    //       this.liczbaWprowadzona = liczbaWprowadzona;
    //       this.ileProb = ileProb;
    //   }

    public void initGame(){
        this.zakresOd=WczytajLiczbe("Podaj zakres dolny losowanych liczb : ");
        this.zakresDo=WczytajLiczbe("Podaj zakres górny losowanych liczb : ");
        this.ileProb=WczytajLiczbe("Ile razy chcesz próbować zgadywać ? ");
        this.liczbaDoOgdadniecia = wylosujNumer(this.zakresOd,zakresDo);
        System.out.println(this.liczbaDoOgdadniecia);
    }



    private int wylosujNumer(int zakresOd, int zakresDo) {
        return (int) (Math.random() * (zakresDo - zakresOd) + zakresOd);
    }


    public void Graj() {
        int i = 0;
        do {
            if (i == this.ileProb) {
                System.out.println(" Niestety nie udało się odgadnąc ... Spróbuj ponownie...");
                break;
            }
            this.liczbaWprowadzona = WczytajLiczbe("Zgadnij jaką liczbę wylosowano : ");


            i++;
        } while (!PorownajLiczbe(this.liczbaWprowadzona, this.liczbaDoOgdadniecia));
    }

    private boolean PorownajLiczbe(int liczbaUsera, int liczbaDoOdgadniecia) {
        boolean odp = false;
        if (liczbaUsera > liczbaDoOdgadniecia) {
            System.out.println("Liczba jest za duża");
        }
        if (liczbaUsera < liczbaDoOdgadniecia) {
            System.out.println("Liczba jest za mała");
        }
        if (liczbaUsera == liczbaDoOdgadniecia) {
            System.out.println("Niesamowite udało Ci się odgadnąc liczbę ...");
            odp = true;
        }
        return odp;
    }

    private int WczytajLiczbe(String text) {
        Scanner myScan = new Scanner(System.in);
        System.out.println(text);
        return (myScan.nextInt());
    }
}
