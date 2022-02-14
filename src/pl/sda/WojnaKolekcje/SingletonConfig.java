package pl.sda.WojnaKolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingletonConfig {

    private static final SingletonConfig instance = new SingletonConfig();

    public SingletonConfig() {
        initTalia();
    }

    public static SingletonConfig getInstance() {
        return instance;
    }

    List<KartaDoGry> talia = new ArrayList<>();
    int liczbaGraczy = 9;

    private void initTalia() {

        List<KartaDoGry> lista = Arrays.asList(
                new KartaDoGry("2", 2, "Kier", 1),
                new KartaDoGry("3", 3, "Kier", 1),
                new KartaDoGry("4", 4, "Kier", 1),
                new KartaDoGry("5", 5, "Kier", 1),
                new KartaDoGry("6", 6, "Kier", 1),
                new KartaDoGry("7", 7, "Kier", 1),
                new KartaDoGry("8", 8, "Kier", 1),
                new KartaDoGry("9", 9, "Kier", 1),
                new KartaDoGry("10", 10, "Kier", 1),
                new KartaDoGry("J", 11, "Kier", 1),
                new KartaDoGry("D", 12, "Kier", 1),
                new KartaDoGry("K", 13, "Kier", 1),
                new KartaDoGry("A", 14, "Kier", 1),

                new KartaDoGry("2", 2, "Karo", 2),
                new KartaDoGry("3", 3, "Karo", 2),
                new KartaDoGry("4", 4, "Karo", 2),
                new KartaDoGry("5", 5, "Karo", 2),
                new KartaDoGry("6", 6, "Karo", 2),
                new KartaDoGry("7", 7, "Karo", 2),
                new KartaDoGry("8", 8, "Karo", 2),
                new KartaDoGry("9", 9, "Karo", 2),
                new KartaDoGry("10", 10, "Karo", 2),
                new KartaDoGry("J", 11, "Karo", 2),
                new KartaDoGry("D", 12, "Karo", 2),
                new KartaDoGry("K", 13, "Karo", 2),
                new KartaDoGry("A", 14, "Karo", 2),

                new KartaDoGry("2", 2, "Pik", 3),
                new KartaDoGry("3", 3, "Pik", 3),
                new KartaDoGry("4", 4, "Pik", 3),
                new KartaDoGry("5", 5, "Pik", 3),
                new KartaDoGry("6", 6, "Pik", 3),
                new KartaDoGry("7", 7, "Pik", 3),
                new KartaDoGry("8", 8, "Pik", 3),
                new KartaDoGry("9", 9, "Pik", 3),
                new KartaDoGry("10", 10, "Pik", 3),
                new KartaDoGry("J", 11, "Pik", 3),
                new KartaDoGry("D", 12, "Pik", 3),
                new KartaDoGry("K", 13, "Pik", 3),
                new KartaDoGry("A", 14, "Pik", 3),

                new KartaDoGry("2", 2, "Trefl", 4),
                new KartaDoGry("3", 3, "Trefl", 4),
                new KartaDoGry("4", 4, "Trefl", 4),
                new KartaDoGry("5", 5, "Trefl", 4),
                new KartaDoGry("6", 6, "Trefl", 4),
                new KartaDoGry("7", 7, "Trefl", 4),
                new KartaDoGry("8", 8, "Trefl", 4),
                new KartaDoGry("9", 9, "Trefl", 4),
                new KartaDoGry("10", 10, "Trefl", 4),
                new KartaDoGry("J", 11, "Trefl", 4),
                new KartaDoGry("D", 12, "Trefl", 4),
                new KartaDoGry("K", 13, "Trefl", 4),
                new KartaDoGry("A", 14, "Trefl", 4)
        );
        talia=lista;

    }
}

