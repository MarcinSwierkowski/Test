package pl.sda.Serializacja;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Book book = new Book(1,"Pan Tadeusz", "Adam Mickiewicz");
        FileOutputStream fileOutputStream = new FileOutputStream("book.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(book);
        fileOutputStream.flush();
        objectOutputStream.close();
        System.out.println(book);

        FileInputStream fileInputStream = new FileInputStream("book.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Book deserializedBook = (Book) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(deserializedBook);


    }
}
