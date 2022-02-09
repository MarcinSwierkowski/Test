package pl.sda.Wzorce;

public class BuilderDemo {
    public static void main(String[] args) {


        Car.CarBuilder item = new Car.CarBuilder()
                .engine("dddd")
                .vin(23)
                .isElectric(true);

        System.out.println(item);
    }

}
