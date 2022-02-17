package pl.sda.Pliki;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class wyjatki {

        public static void main(String[] args) {

            String sciezka = "C:\\Users\\marcin\\IdeaProjects\\Test\\src\\pl\\sda\\Pliki\\";

            try {
                FileReader in = new FileReader(sciezka + "example.txt");
                FileWriter out = new FileWriter(sciezka + "user_output1.txt");

                int nextChar;
                while ((nextChar = in.read()) != -1) {
                    out.append((char) nextChar);
                }
                out.close();
            } catch (IOException e) {
                System.out.println("poleciał wyjątek");
            }
            finally {
                System.out.println("zawsze nam się wykona");
            }
        }
    }

