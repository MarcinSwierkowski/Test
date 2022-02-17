package pl.sda.WojnaKolekcje;

public class KartaDoGry {

    private String figura;
    private int mocFigury;
    private String kolor;
    private int mocKoloru;

    public KartaDoGry(String figura, int mocFigury, String kolor, int mocKoloru) {
        this.figura = figura;
        this.mocFigury = mocFigury;
        this.kolor = kolor;
        this.mocKoloru = mocKoloru;
    }

    public int getMocFigury() {
        return mocFigury;
    }

    public void showCard(){
        System.out.println(figura + " " + kolor);
    }

    @Override
    public String toString() {
        return  figura +"-" +kolor;

    }
}

