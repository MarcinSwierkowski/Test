package pl.sda.OOP;

public class Example {

    public static void main(String[] args) {
        String[] words = {"Ala", "ma", "kota"};
        System.out.println("---demo odd---");
        printFilteredStrings(words,new OddLengthStringFilter()); // ma, kota
        System.out.println("---demo even---");
        printFilteredStrings(words,new EvenLengthStringFilter()); // Ala
    }

    // ta metoda zadziała kiedy dostarczymy jej jakieś napisy i dowolny filter stringów
    public static void printFilteredStrings(String[] strings, StringFilter stringFilter){
        for(String string: strings){
            if(stringFilter.isStringOk(string)){
                System.out.println(string);
            }
        }
    }
}

interface StringFilter {
    boolean isStringOk(String string);
}

class OddLengthStringFilter implements StringFilter {

    public boolean isStringOk(String string) {
        return string.length() % 2 == 0;
    }
}

class EvenLengthStringFilter implements StringFilter {

    public boolean isStringOk(String string) {
        return string.length() % 2 == 1;
    }
}
