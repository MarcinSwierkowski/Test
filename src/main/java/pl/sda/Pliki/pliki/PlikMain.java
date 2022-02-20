package pl.sda.Pliki.pliki;

import pl.sda.Streamy.Student;

import java.io.*;

public class PlikMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //pliki tekstowe - zapis i odczyt

        //zapis
        PrintWriter printWriter=new PrintWriter("tekst.txt");
        printWriter.println("line 1");
        printWriter.println("line 2");
        printWriter.close();

        //odczyt przez kody ascii
        FileReader fileReader=new FileReader("tekst.txt");
        int kodAscii = fileReader.read();
        while (kodAscii!=-1){
            System.out.println(kodAscii);
            kodAscii=fileReader.read();
        }
        fileReader.close();


        //odczyt - kolejne wiersze
        FileReader newFileReader =new FileReader("tekst.txt");
        BufferedReader br=new BufferedReader(newFileReader);
        try {
            String singleLine=br.readLine();
            while (singleLine!=null){
                System.out.println(singleLine);
                singleLine = br.readLine();
            }
        }
        finally {
            br.close();
            newFileReader.close();
        }

        //pliki binarne - obiekty wbudowanych klas

        //zapis
        FileOutputStream fileOutput = new FileOutputStream("integers.bin");
        DataOutputStream output = new DataOutputStream(fileOutput);
        output.writeInt(10);
        output.writeInt(12);
        output.writeInt(14);
        output.close();
        fileOutput.close();

        //odczyt

        FileInputStream fileInput = new FileInputStream("integers.bin");
        DataInputStream inputData = new DataInputStream(fileInput);
        Object integer;
        try {
            while (true) {
                System.out.println(inputData.readInt());
            }
        } catch (EOFException ex) {

        }
        fileInput.close();
        inputData.close();

        //pliki binarne - obiekty naszych klas

        //zapis

        Student student1 = new Student("Ala", 30);
        Student student2 = new Student("Aga", 31);
        Student student3 = new Student("Anna", 32);

        FileOutputStream fileOutputStream = new FileOutputStream("students.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student1);
        objectOutputStream.writeObject(student2);
        objectOutputStream.writeObject(student3);
        objectOutputStream.close();
        fileOutputStream.close();

        //odczyt

        FileInputStream fileInputStream = new FileInputStream("students.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student;
        Object obj;
        try {
            while ((obj = objectInputStream.readObject()) != null) {
                student = (Student) obj;
                System.out.println(student);
            }
        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }

        objectInputStream.close();
        fileInputStream.close();
    }
}
