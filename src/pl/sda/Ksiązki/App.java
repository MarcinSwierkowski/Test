package pl.sda.Ksiązki;

public class App {
    public static void main(String[] args) {

        Biblioteka biblioteka = new Biblioteka();

        biblioteka.dodajSuplayerem();
        System.out.println("_________ Info + liczba dni od pierwszego wydania + filtr powyzej 200 stron i starsze niż 40 lat ______");
        biblioteka.wyswietlConsumerem(biblioteka.filtrujPredykatem());
        System.out.println("_________ Samo info + liczba dni od pierwszego wydania _____________");
        biblioteka.wyswietlConsumerem();
    }
}
