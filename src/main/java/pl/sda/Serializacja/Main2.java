package pl.sda.Serializacja;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //serialization
        Book book = new Book(1, "Pan Tadeusz", "Adam Mickiewicz");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("book.txt")));
        objectOutputStream.writeObject(book);
        objectOutputStream.close();
        //deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("book.txt")));
        Book deserializedBook = (Book) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(deserializedBook);

    }
}
