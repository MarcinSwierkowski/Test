package pl.sda.Pliki;

import java.io.*;

public class OdczytZapisBuffer {

    public static void main(String[] args) throws IOException {

        String sciezka = "C:\\Users\\marcin\\IdeaProjects\\Test\\src\\pl\\sda\\Pliki\\";

        BufferedReader in = new BufferedReader(new FileReader(sciezka+"example.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(sciezka+"user_output2.txt"));

        String line;
        while ((line = in.readLine()) != null) {
            out.write(line+'\n');
        }
    out.close();
    }

}
