package pl.sda.Wątki;

public class PoThread {

//    Chcąc zdefiniować nowy wątek i decydując się na rozszerzenie klasy Thread,
//    cały kod, który powinien wykonać się w osobnym wątku, musi znaleźć się w metodzie run.
//    Przykład pokazuje stworzenie nowego wątku poprzez rozszerzenie klasy Thread.
//    Dodatkowo, wątek jest uruchamiany za pomocą metody start().
//    Wątek główny i ten stworzony przez nas, na końcu swojego działania wypisują swój identyfikator
//    za pomocą Thread.currentThread().getId():


        public static void main(String[] args) {

            App app = new App("Wątek-1");
            App app2 = new App("Wątek-2");
            app.start();
            app2.start();


            System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
            System.out.println(app);
            System.out.println(app2);
        }
    }

    class App extends Thread {

    private int iloscUruchomien=0;

        public App(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("wydruk z Class App");
            iloscUruchomien++;
            System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
        }

        @Override
        public String toString() {
            return "App{" +
                    "iloscUruchomien=" + iloscUruchomien +
                    '}';
        }
    }

