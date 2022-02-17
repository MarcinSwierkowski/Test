package pl.sda.Pliki.pliki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zadanie2 {
    public static void main(String[] args) throws IOException {
        List<Integer> integers = loadPrimeNumbers("pierwsze.txt");
        System.out.println(integers.stream()
                .mapToInt(a -> a.intValue())
                .sum());
    }

    public static List<Integer> loadPrimeNumbers(String fileName) throws IOException {
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String singleLine = br.readLine();
            while (singleLine != null) {
                result.add(Integer.parseInt(singleLine));
                singleLine = br.readLine();
            }
        } finally {
            br.close();
        }
        return result;
    }
}
