package pl.sda.DecoratorExample;

public class Ciasto implements PizzaMaker{

    int cena = 5;
    String nazwa = "Ciasto";

    private PizzaMaker pizzaMaker;

    public Ciasto(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    @Override
    public int getPrice() {
        return cena+ pizzaMaker.getPrice();
    }

    @Override
    public String nazwa() {
        return nazwa+" "+pizzaMaker.nazwa();
    }
}
