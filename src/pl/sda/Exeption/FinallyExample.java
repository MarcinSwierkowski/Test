package pl.sda.Exeption;

public class FinallyExample {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }
        finally {
            System.out.println("Surprise!");
        }
    }

}
