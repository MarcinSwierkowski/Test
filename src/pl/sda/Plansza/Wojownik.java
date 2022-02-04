package pl.sda.Plansza;

public class Wojownik {

    private int pozycjaX;
    private int pozycjaY;
    private String nazwa;
    private String symbol;
    private int lifeLevel;
    private int power;


    int borderX = SingletonConfig.getInstance().rozmiarPlanszyX -1 ;
    int borderY = SingletonConfig.getInstance().rozmiarPlanszyY -1 ;


    public Wojownik(int pozycjaX, int pozycjaY, String nazwa, String symbol, int lifeLevel, int power) {
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        this.nazwa = nazwa;
        this.symbol = symbol;
        this.lifeLevel = lifeLevel;
        this.power = power;
    }

    public int getPozycjaX() {
        return pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getLifeLevel() {
        return lifeLevel;
    }

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public int getPower() {
        return power;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void idz(){
        int tmpX,tmpY,randomX,randomY;

        tmpX=pozycjaX;
        tmpY=pozycjaY;

        randomX=getXYDirection(-1,1);
        randomY=getXYDirection(-1,1);

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

    }

    private int getXYDirection(int min, int max) {
        return (int)((Math.random()*(max - min +1 )))-1;
    }

    @Override
    public String toString() {
        return "Npc{" +
                "pozycjaX=" + pozycjaX +
                ", pozycjaY=" + pozycjaY +
                ", nazwa='" + nazwa + '\'' +
                ", lifeLevel=" + lifeLevel +
                ", power=" + power +
                '}';
    }
}
