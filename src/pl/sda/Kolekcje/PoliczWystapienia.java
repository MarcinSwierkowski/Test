package pl.sda.Kolekcje;

import java.util.*;

public class PoliczWystapienia {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        //List<Integer> lista = Arrays.asList(3, 2, 123, 3, 4, 1, 0, 4, 0);

        wrzucDoListy(lista,1,2,3,4,5,6,7,8,9,0);


        //initList(lista, 30, 40);   // pomocnicze do usuniecia
        System.out.println(lista);          // pomocnicze do usuniecia
        policzWystapienia(lista);           // pomocnicze do usuniecia

        System.out.println(isThree(lista));  //własciwa metoda

    }

    private static void wrzucDoListy(List<Integer> lista,int ... args) {
        for (int element : args) {
            lista.add(element);
        }

    }

    private static void policzWystapienia(List<Integer> lista) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (Integer element : lista) {
            mapa.putIfAbsent(element, 0);
            mapa.replace(element, mapa.get(element) + 1);
        }
        System.out.println(mapa);
    }

    private static void initList(List<Integer> lista, int ilosc, int zakres) {
        Random random = new Random();
        for (int i = 0; i < ilosc; i++) {
            lista.add(random.nextInt(zakres));
        }
    }

    private static boolean isThree(List<Integer> lista) {
        boolean result = false;

        Map<Integer, Integer> mapa = new HashMap<>();
        for (Integer element : lista) {
            mapa.putIfAbsent(element, 0);
            mapa.replace(element, mapa.get(element) + 1);
            if ((mapa.get(element) == 3)) result = true;
        }
        return result;
    }
}

