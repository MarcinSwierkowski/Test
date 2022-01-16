package pl.sda.Kolekcje;

import java.util.HashMap;
import java.util.Map;

public class CodingBat {

    public static void main(String[] args) {


        Map<String, String> mapa = new HashMap<>();

        mapa.put("a", "candy");
        mapa.put("b", "dirt");

        System.out.println(mapBully(mapa));

    }

    public static Map<String, String> mapBully(Map<String, String> map) {
        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
            map.remove("c");
            return map;
        } else map.remove("c");
        return map;
    }

    public static Map<String, String> mapAB(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            map.put("a" + "b", map.get("a") + map.get("b"));
            return map;
        } else return map;
    }

    public static Map<String, String> topping1(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.replace("ice cream", "cherry");
        }
        map.put("bread", "butter");
        return map;
    }
}
