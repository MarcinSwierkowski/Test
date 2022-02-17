package pl.sda.Pliki.pliki;

import java.io.*;

public class Zadanie4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car bmw = new Car("BMW", "2.0l benzyna", false);
        Car opel = new Car("Opel", "1.4 ropa", false);
        Car audi = new Car("Audi", "1.6 TDI", true);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/pl/sda/java105/pliki/przemek/auta.bin"));
        objectOutputStream.writeObject(bmw);
        objectOutputStream.writeObject(opel);
        objectOutputStream.writeObject(audi);

        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream("src/main/java/pl/sda/java105/pliki/przemek/auta.bin")));

        Car car;
        Object obj;

        try {
            while ((obj = objectInputStream.readObject()) != null) {
                car = (Car) obj;
                System.out.println(car);
            }
        } catch (EOFException ex) {

        }

        objectInputStream.close();

    }
}


//Zaprojektowac klase Car i zapisac trzy obiekty tej klasy do pliku binarnego a następnie odczytać