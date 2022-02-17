package pl.sda.DecoratorExample;

public class Pieczarki implements PizzaMaker{

    int cena = 12;
    String nazwa = "Pieczarki";

    private PizzaMaker pizzaMaker;

    public Pieczarki(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }


    @Override
    public int getPrice() {
        return cena + pizzaMaker.getPrice();
    }

    @Override
    public String nazwa() {
        return nazwa+" "+pizzaMaker.nazwa();
    }
}
