package pl.sda.Wzorce;

// SINGLETON EAGER

//        Singleton typu eager możemy w Javie stworzyć na dwa sposoby:
//
//        eager z wykorzystaniem klasy
//        eager z wykorzystaniem enum.
//        Oba powyższe typy nadają się do wykorzystania w aplikacji wielowątkowej.

public class SimpleEagerCounter {

        // pole statyczne, w którym przetrzymujemy referencję singletonu
        // jest to singleton typu eager więc instancję tworzymy od razu, przypisując ją do pola
        private static final SimpleEagerCounter INSTANCE = new SimpleEagerCounter();

        // getter dla referencji singletonu
        public static SimpleEagerCounter getInstance() {
            return INSTANCE;
        }

        // ukryty konstruktor
        private SimpleEagerCounter() {}

        private int currentCount = 0;

        public int getCurrentCount() {
            return currentCount;
        }

        public void increment() {
            currentCount++;
        }
    }

