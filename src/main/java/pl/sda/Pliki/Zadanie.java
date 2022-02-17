package pl.sda.Pliki;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zadanie {

    public static void main(String[] args) throws IOException {

        String sciezka = "C:\\Users\\marcin\\IdeaProjects\\Test\\src\\pl\\sda\\Pliki\\";

        BufferedReader in = new BufferedReader(new FileReader(sciezka+"do_zrobienia.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(sciezka+"zrobione.txt"));

        List<String> lista = new ArrayList<>();

        String line;

        while ((line = in.readLine()) != null) {
            lista.add(line);
        }

        for (String element: lista ) {
            out.write(element+zrobione()+ '\n');
        }
        out.close();
    }

    private static String zrobione() {
        if(Math.random()*10>5) return (" --- zrobione ");
        else return (" --- do zrobienia");
    }


}

