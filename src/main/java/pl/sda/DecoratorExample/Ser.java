package pl.sda.DecoratorExample;

public class Ser implements PizzaMaker{

    int cena =7;
    String nazwa ="Ser";

    private PizzaMaker pizzaMaker;

    public Ser(PizzaMaker pizzaMaker) {
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
