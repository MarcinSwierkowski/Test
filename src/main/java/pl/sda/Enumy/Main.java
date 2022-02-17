package pl.sda.Enumy;

public class Main {

    public static String toColor(Color color, ColorBackground colorBackground, String string) {
        return color.getColor() + colorBackground.getColor() + string + Color.RESET.getColor();
    }

    public static String toColor(Color color, String string) {
        return color.getColor() + string + Color.RESET.getColor();
    }

    public static void main(String[] args) {

        System.out.println(toColor(Color.BLACK, ColorBackground.WHITE_BACKGROUND, "Zajecia z Javy Programowania"));
        System.out.println(toColor(Color.YELLOW, "Zajecia z Javy Programowania"));


    }
}
