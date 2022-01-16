package pl.sda.Pliki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OdczytZapisByte {
    public static void main(String[] args) throws IOException {

        String sciezka = "C:\\Users\\marcin\\IdeaProjects\\Test\\src\\pl\\sda\\Pliki\\";

        FileInputStream in = new FileInputStream(sciezka+"example.txt");
        FileOutputStream out = new FileOutputStream(sciezka+"user_output.txt");
        int c;
        int counter = 0;
        while ((c = in.read()) != -1) {
            out.write(c);
            counter++;
            //System.out.println(c);
        }
        out.close();
        System.out.println(counter);
    }
}
