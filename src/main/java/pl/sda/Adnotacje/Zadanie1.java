package pl.sda.Adnotacje;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

//        ### Zadanie 1
//        Utworz adnotację o nazwie Sensitive, która można umieszcząać na polach i metodach klasy. Domyślna wartość powinna być secret.
//        Utworz klase Person z polami : login, password, pesel. Dodaj konstruktor, settery i gettery
//        Metodę getPesel oznacz domyslną powyższą adnotacją.Pole password oznacz powyższą adnotacją z wartością "password".
//        Używająć refleksji sprawdz oznaczone pole i metodę i wyświetl stosowny komunikat.


public class Zadanie1 {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        // metoda getPesel "secret"
        Method getPesel = Person.class.getDeclaredMethod("getPesel");
        String annotationValue = getPesel.getAnnotation(Sensitive.class).value();
        System.out.println("secret".equals(annotationValue));


        // field password "password"
        Field password = Person.class.getDeclaredField("password");
        String value = password.getAnnotation(Sensitive.class).value();
        System.out.println("password".equals(value));
    }
}
