package pl.sda.WojnaKolekcje;

import java.util.Collections;
import java.util.List;

public class GameApp {
    public static void main(String[] args) {

        List<KartaDoGry> aktualnaTalia = SingletonConfig.getInstance().talia;

        Collections.shuffle(aktualnaTalia); // tasowanie

        Gracz gracz[] = new Gracz[SingletonConfig.getInstance().liczbaGraczy];

        for (int i = 0; i < SingletonConfig.getInstance().liczbaGraczy; i++) {
            gracz[i] = new Gracz();
        }

        rozdajKarty(gracz, aktualnaTalia);

        System.out.println(aktualnaTalia);

        for (int i = 0; i < SingletonConfig.getInstance().liczbaGraczy; i++) {
            System.out.println(gracz[i].getReka()+" "+gracz[i].getReka().size());
        }



    }

    private static void rozdajKarty(Gracz[] gracz, List<KartaDoGry> talia) {
        int counter=0;
        do{
            gracz[counter%SingletonConfig.getInstance().liczbaGraczy].dodajKartę(talia.get(counter));
            counter++;
        }while (counter<52);
    }
}