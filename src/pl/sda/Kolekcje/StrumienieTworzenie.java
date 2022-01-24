package pl.sda.Kolekcje;

import java.util.*;
import java.util.stream.Stream;

public class StrumienieTworzenie {


    // zamiana listy na strumień
    List<String> someList = new ArrayList<>();
    Stream<String> streamFromList = someList.stream();

    // zamiana zbioru na strumień
    Set<Integer> someSet = new HashSet<>();
    Stream<Integer> streamFromSet = someSet.stream();

    // zamiana kolejki na strumień
    Queue<Double> someQueue = new PriorityQueue<>();
    Stream<Double> streamFromQueue = someQueue.stream();


    // zamiana mapy (zbioru wpisów) na strumień
    Map<String, Double> someMap = new HashMap<>();
    Stream<Map.Entry<String, Double>> streamFromMap = someMap.entrySet().stream();

    // zamiana tablicy na strumień
    String[] someArray = {"foo", "bar"};
    Stream<String> streamFromArray = Arrays.stream(someArray);


    // tworzenie strumienia z obiektów
    Stream<String> customStream = Stream.of("You", "shall", "not", "pass");

}
