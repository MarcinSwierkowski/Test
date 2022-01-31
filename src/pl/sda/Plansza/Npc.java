package pl.sda.Plansza;

import java.util.Random;

public class Npc {

    private int pozycjaX;
    private int pozycjaY;

    private String nazwa;

    public Npc(int pozycjaX, int pozycjaY, String nazwa) {
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.nazwa = nazwa;
    }

  public void umiescNaPlanszy(String[][] tablica){
        tablica[pozycjaX][pozycjaY]=nazwa;
    }

    public void idz(){
        int tmpX,tmpY,randomX,randomY;

        tmpX=pozycjaX;
        tmpY=pozycjaY;
        randomX=getRandomNumberUsingNextInt(-1,1);
        randomY=getRandomNumberUsingNextInt(-1,1);

        if(pozycjaX+randomX<0 || pozycjaX+randomX>19)
        {
            pozycjaX=tmpX;
        }
        else {
            pozycjaX=pozycjaX+randomX;
        }
        if(pozycjaY+randomY<0 || pozycjaY+randomY>9)
        {
            pozycjaY=tmpY;
        }
        else {
        pozycjaY=pozycjaY+randomY;
        }

    }

    public int getRandomNumberUsingNextInt(int min, int max) {

        return (int) Math.random()*1.0*(max - min) + min;
    }
}
