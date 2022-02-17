package pl.sda.Streamy;


import com.github.javafaker.Faker;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMain {

    private final static Faker faker = new Faker(new Locale("pl-Pl"));
    private final static int maxNumber = 100;

    private static int sumaCyfr(int number) {
        int suma = 0;
        while (number > 0) {
            suma += number % 10;
            number /= 10;
        }
        return suma;
    }

    public static List<Student> loadFakeStudents() {
        List<Student> studentList = new ArrayList<>();
        while (studentList.size() != maxNumber) {
            studentList.add(
                    new Student(faker.name().firstName(), faker.random().nextInt(70))
            );
        }
        return studentList;
    }

    public static List<Student> loadRealStudents() {
        return Arrays.asList(
                new Student("Jacek", 32),
                new Student("Kasia", 34),
                new Student("Jacek", 32)
        );
    }

    public static void main(String[] args) {
        List<Student> students = loadFakeStudents();
        System.out.println(students);


        //Zadanie 3
        System.out.println("3.Sprawdzić czy w strumieniu znajduje się student o imieniu Kasia.");
        boolean value3 = students.stream()
                .map(st -> st.getName())
                .anyMatch(name -> "Kasia".equals(name));
        System.out.println(value3);

        System.out.println("-----------------------");
        System.out.println("");

        //Zadanie 4
        System.out.println("4.Sprawdzić czy w strumieniu wszystkie imiona są kobiece.");
        boolean value4 = students.stream()
                .map(st -> st.getName())
                .filter(name -> name != null)
                .allMatch(name -> name.endsWith("a"));
        System.out.println(value4);
        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 5
        System.out.println("5.Znaleźć najstarszego studenta i go wyświetlić.");
        //1szy sposób
        System.out.println(students.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(1)
                .collect(Collectors.toList()));
        //2gi sposób
        students.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .findFirst().ifPresent(st -> System.out.println(st));

        //3gi sposób
        students.stream()
                .sorted(Comparator.comparingInt(st -> st.getAge()))
                .reduce((a, b) -> b)
                .ifPresent(st -> System.out.println(st));

        //4gi sposób
        Optional<Student> max = students.stream()
                .max(Comparator.comparingInt(st -> st.getAge()));
        max.ifPresent(st -> System.out.println(st));

        System.out.println("-----------------------");
        System.out.println();


        //Zadanie 6
        System.out.println("6.Pobrać wszystkie imienia ze strumienia i połaczyć je separatorem \",\".");

        //1szy sposób
        Optional<String> value6 = students.stream()
                .map(st -> st.getName())
                .reduce((a, b) -> a + "," + b);
        if (value6.isPresent()) {
            System.out.println(value6.get());
        }

        //2gi sposób
        System.out.println(students.stream()
                .map(st -> st.getName())
                .collect(Collectors.joining(",")));

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 7
        System.out.println("7.Utworzyć mapę studentów ze strumienia w sposób key=wiek, value=liczba studentów w podanym wieku.");
        Map<Integer, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        for (Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().size());
        }
        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 8
        System.out.println("8.Pobrać ze strumienia dwóch najmłodszych studentów.");
        students.stream()
                .sorted(Comparator.comparingInt(st -> st.getAge()))
                .limit(2)
                .forEach(st -> System.out.println(st));

        System.out.println("-----------------------");
        System.out.println();


        //Zadanie 9
        System.out.println("9.Znaleźć średnią wieku wszystkich studentów.");
        students.stream()
                .mapToInt(st -> st.getAge())
                .average()
                .ifPresent(System.out::println);

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 10
        System.out.println("10.Utwórz nowego studenta ze wszystkich studentów w następujący sposób:");
        System.out.println("imię to konkatenacja pierwszych liter imion wszystkich studentów, wiek to suma lat wszystkich studentów.");
        students.stream()
                .map(st -> new Student(st.getName().charAt(0) + "", st.getAge()))
                .reduce((st1, st2) -> new Student(st1.getName() + st2.getName(), st1.getAge() + st2.getAge()))
                .ifPresent(st -> System.out.println(st));

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 11
        System.out.println("11.Znajdź studenta, którego suma cyfr wieku jest taka sama jak liczba znaków w imieniu.");
        Predicate<Student> studentPredicate = student -> sumaCyfr(student.getAge()) == student.getName().length();

        students.stream()
                .filter(studentPredicate)
                .forEach(st -> System.out.println(st));

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 12
        System.out.println("12.Usuń studentów, którzy występują podwójnie. Następnie podaj ilu takich studentów było.");

        System.out.println(students.size() - students.stream()
                .distinct()
                .count());
        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 13
        System.out.println("13.Na podstawie danych wszystkich studentów utwórz studenta, którego imię powstanie");
        System.out.println("przez złaczenia imion wszystkich studentów, a wiek to jest suma wieku wszystkich studentów podzielona przez 10.");
        students.stream()
                .reduce((st1, st2) -> new Student(st1.getName() + st2.getName(), st1.getAge() + st2.getAge()))
                .map(st -> new Student(st.getName(), st.getAge() / 10))
                .ifPresent(st -> System.out.println(st));


        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 14
        System.out.println("14.Zamień wiek studentow na wiek zgodnie ze wzorem n*6-1, a następnie wyświetl tych studentów,których wiek przekracza 40.");

        students.stream()
                .map(st -> new Student(st.getName(), st.getAge() * 6 - 1))
                .filter(st -> st.getAge() > 40)
                .forEach(st -> System.out.println(st));
        System.out.println("-----------------------");
        System.out.println();


        //Zadanie 15
        System.out.println("15.Zgrupuj studentów, których suma znaków w imieniu i suma cyfr wieku jest taka sama.");

        Map<Boolean, List<Student>> mapa = students.stream()
                .collect(Collectors.groupingBy(st -> st.getName().length() == sumaCyfr(st.getAge())));
        for (Map.Entry<Boolean, List<Student>> entry : mapa.entrySet()) {
            if (entry.getKey())
                System.out.println(entry.getValue());
        }

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 16
        System.out.println("16.Wyświetl najpopularniejsze imię.");
        students.stream()
                .map(st -> st.getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey()));

        System.out.println("-----------------------");
        System.out.println();

        //Zadanie 17
        System.out.println("17.Znajdz liczbę różnych imion męskich dla imion, których liczba znaków nie przekracza 10.");
        System.out.println(students.stream()
                .map(student -> student.getName())
                .filter(name -> name.length() <= 10 && !name.endsWith("a"))
                .distinct()
                .count());

        System.out.println("-----------------------");
        System.out.println();

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> list3 = Arrays.asList(11, 12, 13, 14, 15);

        List<List<Integer>> globalList = Arrays.asList(list1, list2, list3);
        List<Integer> lista = globalList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(lista);
    }
}
