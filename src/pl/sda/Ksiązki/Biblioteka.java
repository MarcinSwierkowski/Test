package pl.sda.Ksiązki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.DAYS;

public class Biblioteka {
    List<Ksiazka> listaKsiazek = new ArrayList<>();

    public Biblioteka() {
    }

    Supplier<List<Ksiazka>> supplierLoadData = () -> {

        List<String> plik = null;
        try {
            plik = Files.readAllLines(Path.of("src/pl/sda/Ksiązki/plik.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> linie = new TreeSet<>(plik);
        List<Ksiazka> listaKsiazekZPliku = new ArrayList<>();
        for (String linia : linie) {
            String element[] = linia.split(";");
            listaKsiazekZPliku.add(new Ksiazka(element[0], element[1], LocalDate.of(Integer.parseInt(element[2]), Integer.parseInt(element[3]), Integer.parseInt(element[4])), Integer.parseInt(element[5])));
        }
        return listaKsiazekZPliku;
    };

    Predicate<Ksiazka> predicateLiczbaStron = ksiazka -> ksiazka.getLiczbaStron() >= 200;
    Predicate<Ksiazka> predicateDataPowstania = ksiazka -> ksiazka.getDataPowstania().isBefore(LocalDate.now().minusYears(40));

    Consumer<Ksiazka> consumerInfo = ksiazka -> System.out.println(
            ksiazka.getTytul() +":"
                    + ksiazka.getAutor() +":"
                    + ksiazka.getDataPowstania() +":"
                    + ksiazka.getLiczbaStron() +":"
                    + DAYS.between(ksiazka.getDataPowstania(), LocalDate.now())+" dni upłynęło od pierwszego wydania");

    public void dodajSuplayerem() {
        listaKsiazek.addAll(supplierLoadData.get());
    }

    public void wyswietlConsumerem() {
        for (Ksiazka ksiazka : listaKsiazek) {
            consumerInfo.accept(ksiazka);
        }
    }

    public void wyswietlConsumerem(List<Ksiazka> listaKsiazek) {
        for (Ksiazka ksiazka : listaKsiazek) {
            consumerInfo.accept(ksiazka);
        }
    }

    public List<Ksiazka> filtrujPredykatem() {

        List<Ksiazka> listaPoPredykacie = new ArrayList<>();
        for (Ksiazka ksiazka : listaKsiazek) {
            if (predicateDataPowstania.test(ksiazka) && predicateLiczbaStron.test(ksiazka))
                listaPoPredykacie.add(ksiazka);
        }
        return listaPoPredykacie;
    }


}
