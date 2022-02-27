package pl.sda.WojnaKolekcje;

import java.util.*;

public class GameApp {

    static final int liczbaGraczy = SingletonConfig.getInstance().getLiczbaGraczy();
    static int loser = 0;

    public static void main(String[] args) {

        List<KartaDoGry> aktualnaTalia = SingletonConfig.getInstance().getTalia();

        Collections.shuffle(aktualnaTalia); // tasowanie

        List<Gracz> gracze = new ArrayList<>();
        for (int i = 0; i < liczbaGraczy; i++) {
            gracze.add(new Gracz(i, "Gracz_" + i));
        }

        rozdajKarty(gracze, aktualnaTalia);

        for (int i = 0; i < liczbaGraczy; i++) {
            System.out.println(gracze.get(i).getReka() + " " + gracze.get(i).getReka().size() + " " + gracze.get(i).getName());
        }



        Map<Integer, KartaDoGry> map = new TreeMap<>();
        List<KartaDoGry> rozdanie = new ArrayList<>();

        while (loser<liczbaGraczy-1 && rozdanie.size()!=52){

                checkLoosers(gracze);
                RzucKarte(map, rozdanie, gracze);

            int sumaKart=0;
            for (int i = 0; i < liczbaGraczy; i++) {

                System.out.println(gracze.get(i).getReka() + " " + gracze.get(i).getReka().size() + " " + gracze.get(i).getName());
                sumaKart=sumaKart+gracze.get(i).getReka().size();
            }
            System.out.println("Suma kart u graczy :"+sumaKart);

            if(rozdanie.size()==52) System.out.println("Gra nierozszczygnięta !!!!"); // nieprawdopodobne ale jednak :) gracze musieli by miec karty po kolei i o takiej samej wartosci
        }
    }


    private static void RzucKarte(Map<Integer, KartaDoGry> map, List<KartaDoGry> rozdanie, List<Gracz> gracze) {
        int winnercounter;
        int winnerindex =1000;
        map.clear();
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() > 0 && gracze.get(i).isCzyWykladaKarte()) {
                map.put(gracze.get(i).getId(), gracze.get(i).getReka().peek());   // map - analiza
                rozdanie.add(gracze.get(i).getReka().poll());                     // rozdanie - karty w grze
            }
        }

        checkLoosers(gracze);


        if(map.size()>1) {
            KartaDoGry maxValue = (Collections.max(map.values()));      // map najwieksza karta w grze

            winnercounter = 0;
            // sprawdzam czy w grze sa jeszcze inne najwieksze karty
            for (Map.Entry<Integer, KartaDoGry> entry :
                    map.entrySet()) {
                if (entry.getValue().getFigura().getMocFigury() == maxValue.getFigura().getMocFigury()) {
                    winnercounter++;
                    winnerindex = entry.getKey();
                }
            }
            // jesli są to ustawiam 'wykłada karte' na true tylko dla grających w wojnie
            // tu  muszę zawsze ustawiać wszystkivh do wykłądania kart więc odwrotnośc w logice
            // wyłącze możliwośc wykładania kart graczom nie uczestniczącym w wojnie
            if (winnercounter > 1) {
                for (Map.Entry<Integer, KartaDoGry> entry :
                        map.entrySet()) {
                    if (entry.getValue().getFigura().getMocFigury() != maxValue.getFigura().getMocFigury()) {
                        gracze.get(entry.getKey()).setCzyWykladaKarte(false);
                    }
                }
                System.out.println("WOJNA!!!");
                // wlożenie kart wojennych do puli
                for (int i = 0; i < liczbaGraczy; i++) {
                    if (gracze.get(i).getReka().size() > 0 && gracze.get(i).isCzyWykladaKarte()) {
                        rozdanie.add(gracze.get(i).getReka().poll());
                    }
                }
                RzucKarte(map, rozdanie, gracze);     //rekurencja :)
            }
            wygranyZabieraKarty(gracze, rozdanie, winnerindex);
            checkLoosers(gracze);
        }
    }


    private static void wygranyZabieraKarty(List<Gracz> gracze, List<KartaDoGry> pula,int winner) {

            System.out.println(gracze.get(winner).getName() + " zabiera karty " + pula + "-" + pula.size());
            gracze.get(winner).getReka().addAll(pula);
            pula.clear();

            for (int i = 0; i < liczbaGraczy; i++) {
                gracze.get(i).setCzyWykladaKarte(true);
            }
    }


    private static void rozdajKarty(List<Gracz> gracze, List<KartaDoGry> talia) {
        int counter = 0;
        do {
            gracze.get(counter % liczbaGraczy).dodajKartę(talia.get(counter));
            counter++;
        } while (counter < 52);
    }

    private static void checkLoosers(List<Gracz> gracze) {
        int sum = 0;
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() == 0) sum++;
        }
        loser = sum;
    }
}