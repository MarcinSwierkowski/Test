package pl.sda.WojnaKolekcje;

import java.util.*;
import java.util.stream.Collectors;

public class GameApp {

    static final int liczbaGraczy = SingletonConfig.getInstance().getLiczbaGraczy();
    static int loser = 0;
    static boolean duplikat = false;


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


        WyciagnijKarte2(map, rozdanie, gracze);

        System.out.println("Rozdanie : ");
        System.out.println(map);


//        while (loser<liczbaGraczy-1 && pula.size()!=52){
//            duplikat = false;
//            checkLoosers(gracze);
//            WyciagnijKarte(map,rozdanie,gracze);
//            pula.addAll(rozdanie);
//            rozdanie.clear();
//
//            // ZROBIONE : wersja gry dla wielu graczy : jesli istnieje wojna wszyscy walczą.
//            // probemy przy wiekszej ilosci graczy wojna jest czesta i zaraz w puli znajdują sie wszystkie karty.
//            // TODO : zrobić wersje gdy walczą tylko gracze o takich samych kartach reszta kart na stole idzie łupem wojny
//            // TODO : wojna jest tylko wtedy gdy karty wojujące sa najwyzsze w rozdaniu jesli nie to zabiera je najwyzsza karta
//            // TODO : POSPRZĄTAĆ i poprzenosić metody i zmienne w optymalne miejsca
//
//
//            if (duplikat) {        // wojna bo są duplikaty
//                for (int i = 0; i < liczbaGraczy; i++) {
//                    if(gracze.get(i).getReka().size()>0) {
//                        rozdanie.add(gracze.get(i).getReka().poll());
//                    }
//                }
//                System.out.println("WOJNA !!!");
//                pula.addAll(rozdanie);
//                rozdanie.clear();
//            }
//            else  wygranyZabieraKarty(map, gracze, pula);
//
//
//            int sumaKart=0;
//            for (int i = 0; i < liczbaGraczy; i++) {
//
//                System.out.println(gracze.get(i).getReka() + " " + gracze.get(i).getReka().size() + " " + gracze.get(i).getName());
//                sumaKart=sumaKart+gracze.get(i).getReka().size();
//            }
//            System.out.println("Suma kart u graczy :"+sumaKart);
//            System.out.println("Suma kart w puli :"+pula.size());
//
//            if(pula.size()==52) System.out.println("Gra nierozszczygnięta !!!!");
//        }
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

        int winnercounter=0;

        for (Map.Entry<Integer, KartaDoGry> entry :
                map.entrySet()) {
            if (entry.getValue().getFigura().getMocFigury() == maxValue.getFigura().getMocFigury()) {
                winnercounter++;
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

    private static void wygranyZabieraKarty(Map<Integer, Integer> map, List<Gracz> gracze, List<KartaDoGry> pula) {

        int winner = map.entrySet().stream()
                .map(n -> n.getValue())
                .collect(Collectors.toList()).get(liczbaGraczy - 1 - loser);

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