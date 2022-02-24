package pl.sda.WojnaKolekcje;

import java.util.*;
import java.util.stream.Collectors;

public class GameApp {

    static final int liczbaGraczy = SingletonConfig.getInstance().getLiczbaGraczy();
    static int loser = 0;
    static boolean duplikat = false;
    static int winnercounter =0;
    static  boolean decyzja = false;
    static  int winnerindex =0;

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
        List<KartaDoGry> pula = new ArrayList<>();


        //WyciagnijKarte2(map, rozdanie, gracze);

        System.out.println("Rozdanie : ");
        System.out.println(map);


        while (loser<liczbaGraczy-1 && pula.size()!=52){

                duplikat = false;
                checkLoosers(gracze);
                WyciagnijKarte2(map, rozdanie, gracze);
                pula.addAll(rozdanie);
                rozdanie.clear();

                if (duplikat && winnercounter > 1) {        // wojna bo są duplikaty na najwiekszych kartach
                    for (int i = 0; i < liczbaGraczy; i++) {
                        if (gracze.get(i).getReka().size() > 0) {
                            rozdanie.add(gracze.get(i).getReka().poll());
                        }
                    }
                    System.out.println("WOJNA !!!");
                    pula.addAll(rozdanie);
                    rozdanie.clear();

                    checkLoosers(gracze);

                    for (int i = 0; i < liczbaGraczy; i++) {
                        if (gracze.get(i).getReka().size() > 0 && gracze.get(i).isCzyWykladaKarte()) {
                            rozdanie.add(gracze.get(i).getReka().poll());
                        }
                    }
            }
            else  wygranyZabieraKarty(map, gracze, pula,winnerindex);



            int sumaKart=0;
            for (int i = 0; i < liczbaGraczy; i++) {

                System.out.println(gracze.get(i).getReka() + " " + gracze.get(i).getReka().size() + " " + gracze.get(i).getName());
                sumaKart=sumaKart+gracze.get(i).getReka().size();
            }
            System.out.println("Suma kart u graczy :"+sumaKart);
            System.out.println("Suma kart w puli :"+pula.size());

            if(pula.size()==52) System.out.println("Gra nierozszczygnięta !!!!");
        }
    }

    private static void checkLoosers(List<Gracz> gracze) {
        int sum = 0;
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() == 0) sum++;
        }
        loser = sum;
    }

    private static void WyciagnijKarte(Map<Integer, Integer> map, List<KartaDoGry> rozdanie, List<Gracz> gracze) {
        map.clear();
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() > 0) {
                map.put(gracze.get(i).getReka().peek().getFigura().getMocFigury(), gracze.get(i).getId());
                rozdanie.add(gracze.get(i).getReka().poll());
            }
        }
        if (map.size() < liczbaGraczy - loser) duplikat = true;
    }

    private static void WyciagnijKarte2(Map<Integer, KartaDoGry> map, List<KartaDoGry> rozdanie, List<Gracz> gracze) {
        map.clear();
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() > 0) {
                map.put(gracze.get(i).getId(), gracze.get(i).getReka().peek());
                rozdanie.add(gracze.get(i).getReka().poll());
            }
        }
        int size = map.entrySet().stream()
                .map(n -> n.getValue().getFigura())
                .distinct()
                .collect(Collectors.toList()).size();

        if (map.size() < liczbaGraczy - loser) duplikat = true;   //czy duplikaty


        KartaDoGry maxValue = (Collections.max(map.values()));



        winnercounter=0;

        for (Map.Entry<Integer, KartaDoGry> entry :
                map.entrySet()) {
            if (entry.getValue().getFigura().getMocFigury() == maxValue.getFigura().getMocFigury()) {
                winnercounter++;
                winnerindex = entry.getKey();
            }
        }

        if(winnercounter>1) {
            for (Map.Entry<Integer, KartaDoGry> entry :
                    map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    gracze.get(entry.getKey()).setCzyWykladaKarte(true);
                }
            }
        }
    }

    private static void wygranyZabieraKarty(Map<Integer, KartaDoGry> map, List<Gracz> gracze, List<KartaDoGry> pula,int winner) {

        System.out.println(gracze.get(winner).getName() + " zabiera karty " + pula + "-" + pula.size());

        gracze.get(winner).getReka().addAll(pula);
        pula.clear();
    }


    private static void rozdajKarty(List<Gracz> gracze, List<KartaDoGry> talia) {
        int counter = 0;
        do {
            gracze.get(counter % liczbaGraczy).dodajKartę(talia.get(counter));
            counter++;
        } while (counter < 52);
    }
}