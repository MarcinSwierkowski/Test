package pl.sda.Wzorce;

// SINGLETON LAZY

//        lazy - instancja obiektu jest tworzona dopiero wtedy, gdy aplikacja chce go użyć pod raz pierwszy.

//        singleton typu lazy również możemy stworzyć na dwa sposoby:
//
//        lazy, który nie nadaje się do wykorzystania w aplikacjach wielowątkowych.
//        lazy double checked , który można wykorzystać w aplikacjach wielowątkowych.

public class SimpleLazyCounter {

    private static SimpleLazyCounter instance;

    private int currentCount = 0;

    // ukryty konstruktor
    private SimpleLazyCounter() {}


// zabezpieczenie zeby była tylko 1 instancja ale to moze nie zadziałac w środowisku wielowątkowym

// i wtedy zalecane jest tzw double check bo mozna tez zrobić synchronizację na bloku ale to obliczeniowo kosztowne
//
//    public static CommonStorage getInstance() {
//        if (instance == null) {
//            synchronized (CommonStorage.class) {
//                if (instance == null) {
//                    instance = new CommonStorage();
//                }
//            }
//        }
//        return instance;
//    }

    public static SimpleLazyCounter getInstance() {
        if (instance == null) {
            instance = new SimpleLazyCounter();
        }
        return instance;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void increment() {
        currentCount++;
    }
}



