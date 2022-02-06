package pl.sda.DecoratorExample;

public class PizzaMargherita implements PizzaMaker{

    int cenaPizzy = 25;
    String nazwa = "Margherita";


    @Override
    public int getPrice() {
        return cenaPizzy;
    }

    @Override
    public String nazwa() {
        return nazwa;
    }
}
