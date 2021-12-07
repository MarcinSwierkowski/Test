package pl.sda.ZadanieStudent;

public class ZadanieStudent {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Piotr", "Piotrowski", 'M');
        Student student2 = new Student(2, "Marcin", "Marcinkiewicz", 'M');
        Student student3 = new Student(3, "Zuzanna", "Zuzinska", 'K');

        System.out.println(student1.toString());
        student2.setNrIndeksu(1234);
        System.out.println(student2.toString());

    }
}