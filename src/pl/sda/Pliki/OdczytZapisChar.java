package pl.sda.Pliki;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OdczytZapisChar {

    public static void main(String[] args) throws IOException {

        String sciezka = "C:\\Users\\marcin\\IdeaProjects\\Test\\src\\pl\\sda\\Pliki\\";

        FileReader in = new FileReader(sciezka+"example.txt");
        FileWriter out = new FileWriter(sciezka+"user_output1.txt");

        int nextChar;
        while ((nextChar = in.read()) != -1) {
            out.append((char) nextChar);
        }
        out.close();
    }
}
