package pl.sda.DecoratorExample;

public class App {
    public static void main(String[] args) {

        PizzaMaker mojaPizza = new Pizza();

        PizzaMaker dekorPizza = new Ciasto(new Pieczarki(new Ser(mojaPizza)));

        System.out.println(dekorPizza.nazwa());
        System.out.println(dekorPizza.getPrice());

    }
}
