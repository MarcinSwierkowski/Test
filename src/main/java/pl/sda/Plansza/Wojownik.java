package pl.sda.Plansza;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Wojownik {

    private int pozycjaX;
    private int pozycjaY;
    private int directionX;
    private int directionY;
    private int cyklRuchu;
    private int cyklCounter=1;
    private String nazwa;
    private int lifeLevel;
    private int power;
    private Image ball;


    int borderX = SingletonConfig.getInstance().rozmiarPlanszyX -1 ;
    int borderY = SingletonConfig.getInstance().rozmiarPlanszyY -1 ;


    public Wojownik(int pozycjaX, int pozycjaY,int directionX,int directionY, int cyklRuchu ,String nazwa, int lifeLevel, int power) {
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.directionX= directionX;
        this.directionY= directionY;
        this.cyklRuchu= cyklRuchu;
        this.nazwa = nazwa;
        this.lifeLevel = lifeLevel;
        this.power = power;

        loadImage();
    }

    public int getPozycjaX() {
        return pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public  int getLifeLevel() {
        return lifeLevel;
    }

    public  void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public int getPower() {
        return power;
    }

    public void idz(){
        int tmpX,tmpY,randomX,randomY;

        tmpX=pozycjaX;
        tmpY=pozycjaY;

        if(cyklCounter%cyklRuchu==0){
            this.directionX=SingletonConfig.getInstance().getDirection(-2,2);
            this.directionY=SingletonConfig.getInstance().getDirection(-2,2);
        }
            randomX = this.directionX;
            randomY = this.directionY;


        if(pozycjaX+randomX<0 || pozycjaX+randomX>borderX)
        {
            pozycjaX=tmpX;
        }
        else {
            pozycjaX=pozycjaX+randomX;
        }
        if(pozycjaY+randomY<0 || pozycjaY+randomY>borderY)
        {
            pozycjaY=tmpY;
        }
        else {
        pozycjaY=pozycjaY+randomY;
        }
        cyklCounter++;
    }

    public void rysujWojownika(Graphics g,Object t){

        g.drawImage(ball, this.pozycjaX, this.pozycjaY,(ImageObserver) t);
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/main/java/pl/sda/Plansza/ball.png");
        ball = ii.getImage();
    }

    @Override
    public String toString() {
        return "Wojownik{" +
                "pozycjaX=" + pozycjaX +
                ", pozycjaY=" + pozycjaY +
                ", directionX=" + directionX +
                ", directionY=" + directionY +
                ", cyklRuchu=" + cyklRuchu +
                ", nazwa='" + nazwa + '\'' +
                ", lifeLevel=" + lifeLevel +
                ", power=" + power +
                ", borderX=" + borderX +
                ", borderY=" + borderY +
                '}';
    }
}
