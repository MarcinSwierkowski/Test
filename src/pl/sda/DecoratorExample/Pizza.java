package pl.sda.DecoratorExample;

public class Pizza implements PizzaMaker{

    int cenaPizzy = 0;
String nazwa = "";


    @Override
    public int getPrice() {
        return cenaPizzy;
    }

    @Override
    public String nazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "cenaPizzy=" + cenaPizzy +
                '}';
    }
}
