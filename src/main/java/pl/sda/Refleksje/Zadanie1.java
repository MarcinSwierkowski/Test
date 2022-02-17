package pl.sda.Refleksje;

import pl.sda.Streamy.Student;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Zadanie1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //wywolanie metody toString

        Student student = Student.class
                .getConstructor(String.class, int.class)
                .newInstance("Jacek", 20);

        Method myMethod = student.getClass().getMethod("toString");
        Object invoke = myMethod.invoke(student);
        System.out.println(invoke);

        //wywolanie metody multiply
        Student student1 = Student.class
                .getConstructor(String.class, int.class)
                .newInstance("Jacek", 20);

        Method multiplyMethod = student1.getClass().getMethod("multiply", int.class, int.class);
        Object invokeMultiply = multiplyMethod.invoke(student1, 2, 3);
        System.out.println(invokeMultiply);
    }
}
