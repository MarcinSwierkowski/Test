package pl.sda.WojnaKolekcje;

import java.util.*;
import java.util.stream.Collectors;

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


        Map<Integer, Integer> map = new HashMap<>();
        List<KartaDoGry> rozdanie = new ArrayList<>();
        List<KartaDoGry> pula = new ArrayList<>();


        while (loser<liczbaGraczy-1){
            checkLoosers(gracze);
            WyciagnijKarte(map,rozdanie,gracze);
            pula.addAll(rozdanie);
            rozdanie.clear();

            if (map.size() < liczbaGraczy-loser) {
                for (int i = 0; i < liczbaGraczy; i++) {
                    if(gracze.get(i).getReka().size()>0) {
                        rozdanie.add(gracze.get(i).getReka().poll());
                    }
                    checkLoosers(gracze);
                }
                System.out.println("WOJNA !!!");
                pula.addAll(rozdanie);
                rozdanie.clear();
            }
            else  wygranyZabieraKarty(map, gracze, pula);


            int sumaKart=0;
            for (int i = 0; i < liczbaGraczy; i++) {

                System.out.println(gracze.get(i).getReka() + " " + gracze.get(i).getReka().size() + " " + gracze.get(i).getName());
                sumaKart=sumaKart+gracze.get(i).getReka().size();
            }
            System.out.println("Suma kart u graczy :"+sumaKart);
            System.out.println("Suma kart w puli :"+pula.size());


        }
    }

    private static void checkLoosers(List<Gracz> gracze) {
        int sum = 0;
        for (int i = 0; i < liczbaGraczy; i++) {
            if(gracze.get(i).getReka().size()==0) sum++;
        }
        loser = sum;
    }

    private static void WyciagnijKarte(Map<Integer, Integer> map, List<KartaDoGry> rozdanie, List<Gracz> gracze) {
        map.clear();
        for (int i = 0; i < liczbaGraczy; i++) {
            if(gracze.get(i).getReka().size()>0){
            map.put(gracze.get(i).getReka().peek().getFigura().getMocFigury(), gracze.get(i).getId());
            rozdanie.add(gracze.get(i).getReka().poll());
            }
        }
        checkLoosers(gracze);
    }

    private static void wygranyZabieraKarty(Map<Integer, Integer> map, List<Gracz> gracze, List<KartaDoGry> pula) {

        int winner = map.entrySet().stream()
                .map(n->n.getValue())
                .collect(Collectors.toList()).get(liczbaGraczy -1-loser);

        System.out.println( gracze.get(winner).getName()+" zabiera karty "+ pula+"-"+pula.size());

        gracze.get(winner).getReka().addAll(pula);
        pula.clear();
    }


    private static void rozdajKarty(List<Gracz> gracze, List<KartaDoGry> talia) {
        int counter=0;
        do{
            gracze.get(counter% liczbaGraczy).dodajKartę(talia.get(counter));
            counter++;
        }while (counter<52);
    }
    //test
}