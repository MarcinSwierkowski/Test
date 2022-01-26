package pl.sda.Wątki;

public class PoRunnable {

        public static void main(String[] args) {

//            Innym, lepszym sposobem utworzenia wątku jest zadeklarowanie klasy,
//            która implementuje interfejs Runnable, z jedną, abstrakcyjną, bezargumentową metodą run.
//            Instancję Runnable można przekazać jako argument konstruktora klasy Thread.
//            Tak stworzony wątek startujemy za pomocą metody start.



           App1 app = new App1();
           App1 app1 = new App1();
           new Thread(app,"Wątek-1").start();
           new Thread(app1,"Wątek-2").start();

           new Thread(()->{
               Thread.currentThread().setName("Wątek-3 z Lambdy");
               System.out.println("wydruk z Lambdy");
               System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
           }).start();


            System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
            System.out.println(app);
            System.out.println(app1);
        }
    }

    class App1 implements Runnable {

        Licznik licznik = new Licznik();


        @Override
        public void run() {
            System.out.println("wydruk z Class App1");
            licznik.zwiekszLiczbeUruchomien();
            System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
        }


    }


class Licznik{

 private int iloscUruchomien =0;

    void zwiekszLiczbeUruchomien(){
        iloscUruchomien++;
    }

}
