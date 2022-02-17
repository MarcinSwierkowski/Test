package pl.sda.Wątki;

public class PoRunnable {

    public static void main(String[] args) {

//            Innym, lepszym sposobem utworzenia wątku jest zadeklarowanie klasy,
//            która implementuje interfejs Runnable, z jedną, abstrakcyjną, bezargumentową metodą run.
//            Instancję Runnable można przekazać jako argument konstruktora klasy Thread.
//            Tak stworzony wątek startujemy za pomocą metody start.

        Licznik counter = new Licznik(0);
        App1 app = new App1(counter);
        App1 app1 = new App1(counter);
        new Thread(app, "Wątek-1").start();
        new Thread(app1, "       Wątek-2").start();

//           new Thread(()->{
//               Thread.currentThread().setName("Wątek-3 z Lambdy");
//               System.out.println("wydruk z Lambdy");
//               System.out.println("Zakończenie bieżacego wątku o Id: "+Thread.currentThread().getId()+" ,name :"+Thread.currentThread().getName());
//           }).start();


        System.out.println("Zakończenie bieżacego wątku o Id: " + Thread.currentThread().getId() + " ,name :" + Thread.currentThread().getName());
        System.out.println(counter.getIloscUruchomien() + " : " + counter.getIloscUruchomien2());
    }

}

class App1 implements Runnable {

    final private Licznik licznik;


    public App1(Licznik licznik) {
        this.licznik = licznik;
    }

    @Override
    public void run() {
        System.out.println("wydruk z Class App1");
        for (int i = 0; i < 100; i++) {
            licznik.zwiekszLiczbeUruchomien();
            licznik.zwiekszLiczbeUruchomien2();

            for (int j = 0; j < Math.abs(Math.random() * 200); j++) {
            }
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("Zakończenie bieżacego wątku o Id: " + Thread.currentThread().getId() + " ,name :" + Thread.currentThread().getName());
    }


}


final class Licznik {

    private int iloscUruchomien = 0;
    private int iloscUruchomien2 = 0;

    public Licznik(int iloscUruchomien) {
        this.iloscUruchomien = iloscUruchomien;
    }

    public int getIloscUruchomien() {
        return iloscUruchomien;
    }

    public int getIloscUruchomien2() {
        return iloscUruchomien2;
    }

    synchronized void zwiekszLiczbeUruchomien() {
        this.iloscUruchomien++;
    }

    synchronized void zwiekszLiczbeUruchomien2() {
        this.iloscUruchomien2++;
    }
}
