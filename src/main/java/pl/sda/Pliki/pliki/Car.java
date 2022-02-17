package pl.sda.Pliki.pliki;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Car implements Serializable {

    private String name;
    private String engine;
    private boolean isEngineOn;

}
