package pl.sda.OOP;

public class Polimorfizm {

    public static void main(String args[]){
        Object o1 = new Zar();
        Zar o2 = new Foo();
        Foo o3 = new Bar();
        Bar o4 = new Bar();

        Object[] objectsArray = {o1,o2,o3,o4};
        printThemAll(objectsArray);
    }

    public static void printThemAll(Object[] someObjects){
        for(Object object : someObjects){
            System.out.println(object);
        }
    }
}

class Zar {
    public String toString() {
        return "Jestem Zar";
    }
}
class Foo extends Zar{
    public String toString() {
        return "Jestem Foo";
    }
}
class Bar extends Foo{
    public String toString() {
        return "Jestem Bar";
    }
}
