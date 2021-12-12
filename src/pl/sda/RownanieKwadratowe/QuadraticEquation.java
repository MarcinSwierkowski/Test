package pl.sda.RownanieKwadratowe;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // zrobic obsługe błedu a!=0 nie moze być zerem
    }

    private double policzDelte() {
        return (b * b - 4 * a * c);
    }

    private double getX1(double delta) {
        return ((-b) - Math.sqrt(delta)) / (2 * a);
    }

    private double getX2(double delta) {
        return ((-b) + Math.sqrt(delta)) / (2 * a);
    }

    @Override
    public String toString() {

        if (policzDelte()==0) return "Równanie Kwadratowe : " + a + "x^2+" + b + "x+" + c + " ma 1 rozwiązanie : x=" + getX1(policzDelte());
        if(policzDelte()<0)
            return "Równanie Kwadratowe : " + a + "x^2+" + b + "x+" + c + " nie ma rozwiązań";
        else
            return "Równanie Kwadratowe : " + a + "x^2+" + b + "x+" + c + " ma 2 rozwiązania : x1=" + getX1(policzDelte()) + " x2=" + getX2(policzDelte());
        }
}
