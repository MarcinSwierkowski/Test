package pl.sda.Kolekcje;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamyExample {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(-1, -2),
                new Point(-6, 8),
                new Point(3, -2),
                new Point(10, 20));

        System.out.println("--- punkty o X większych od Y ---");

        List<Point> stream2 = points.stream()
                .filter(n -> n.getX() > n.getY())
                .collect(Collectors.toList());

        System.out.println(stream2);

        System.out.println("--- punkty o X i Y dodatnich ---");

        List<Point> stream3 = points.stream()
                .filter(n -> n.getX() > 0 &&  n.getY()>0 )
                .collect(Collectors.toList());;

        System.out.println(stream3);

    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


