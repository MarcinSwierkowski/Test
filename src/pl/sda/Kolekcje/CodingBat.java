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


    public static Map<String, String> topping2(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }

        if (map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }
        return map;
    }


    public static Map<String, String> topping3(Map<String, String> map) {
        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }

        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }

    public static Map<String, String> mapAB2(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            if (map.get("a").equals(map.get("b"))) {
                map.remove("a");
                map.remove("b");
            }
        }
        return map;
    }

    public static Map<String, String> mapAB3(Map<String, String> map) {
        if (!(map.containsKey("a") && map.containsKey("b"))) {
            if (map.containsKey("a")) map.put("b",map.get("a"));
            if (map.containsKey("b")) map.put("a",map.get("b"));
        }
        return map;
    }


    public static Map<String, String> mapAB4(Map<String, String> map) {
        if ((map.containsKey("a") && map.containsKey("b"))) {
            if(map.get("a").length() == map.get("b").length())
            {
                map.put("a","");
                map.put("b","");
                return map;
            }
            if ( map.get("a").length()> map.get("b").length())
                map.put("c",map.get("a"));
            else map.put("c",map.get("b"));
        }
        return map;
    }


    public static Map<String, Integer> word0(String[] strings) {
        Map<String,Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s,0);
        return map;
    }

    public static Map<String, Integer> wordLen(String[] strings) {
        Map<String,Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s,s.length());
        return map;
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String,String> map = new HashMap<>();
        for (String s : strings)
            map.put(s.substring(0,1),s.substring(s.length()-1,s.length()));
        return map;
    }

    public static Map<String, Integer> wordCount(String[] strings) {
        Map<String,Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s,0);
        for (String s : strings)
            map.put(s,map.get(s)+1);
        return map;
    }

    public static Map<String, String> firstChar(String[] strings) {
        Map<String,String> map = new HashMap<>();
        for (String s : strings)
            map.put(s.substring(0,1),"");
        for (String s : strings)
            map.put(s.substring(0,1),map.get(s.substring(0,1))+s);
        return map;
    }


}


