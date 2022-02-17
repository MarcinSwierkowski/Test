package pl.sda.Streamy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return this.name + ":" + this.age;
    }
}
