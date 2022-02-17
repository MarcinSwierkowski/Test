package pl.sda.Optional;

import pl.sda.Streamy.Student;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Student student = new Student("Tomasz",21);


        Optional<String> notSureIfNotNull = Optional.ofNullable(student.getName());

        Optional<String> sureIfNotNull = Optional.of(student.getName());

        Optional<String> emptyValue = Optional.empty();

        //jak korzystać

        // 1 sposób
        if (notSureIfNotNull.isPresent()){
            System.out.println(notSureIfNotNull.get());
        }

        // 2 sposób consumerem
        notSureIfNotNull.ifPresent(value-> System.out.println(value));

        notSureIfNotNull.orElse("Hello");
        notSureIfNotNull.orElseGet(()-> "Hello");
        notSureIfNotNull.orElseThrow(RuntimeException::new);

        // 3 sposób filtrowanie
        notSureIfNotNull
                .filter(value->"Kasia".equals(value))
                .ifPresent(value-> System.out.println(value));

        // 4 sposób mapowanie
        notSureIfNotNull
                .map(value->value+"a")
                .filter(value->value.length()>0)
                .ifPresent(value-> System.out.println(value));
    }
}
