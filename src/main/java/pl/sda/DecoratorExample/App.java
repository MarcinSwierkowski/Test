package pl.sda.DecoratorExample;

public class App {
    public static void main(String[] args) {

        PizzaMaker mojaPizza = new Pizza();

        PizzaMaker margerita = new PizzaMargherita();

        PizzaMaker dekorPizza = new Ciasto(new Pieczarki(new Ser(mojaPizza)));

        System.out.println("Skład pizzy :"+dekorPizza.nazwa());
        System.out.println("Cena pizzy :"+dekorPizza.getPrice()+" zł.");

        PizzaMaker dekorMargerita = new Ciasto(new Pieczarki(new Ser(margerita)));

        System.out.println("Skład pizzy :"+dekorMargerita.nazwa());
        System.out.println("Cena pizzy :"+dekorMargerita.getPrice()+" zł.");

    }
}
