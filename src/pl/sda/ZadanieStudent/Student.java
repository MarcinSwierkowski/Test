package pl.sda.ZadanieStudent;

public class Student {
    private int nrIndeksu;
    private String name;
    private String nazwisko;
    private char plec;

    public Student(int nrIndeksu, String name, String nazwisko, char plec) {
        this.nrIndeksu = nrIndeksu;
        this.name = name;
        this.nazwisko = nazwisko;
        this.plec = plec;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nrIndeksu=" + nrIndeksu +
                ", name='" + name + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                '}';
    }
}
