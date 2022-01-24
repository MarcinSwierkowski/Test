package pl.sda.Kolekcje;

import java.util.*;
import java.util.stream.Collectors;

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
            if (map.containsKey("a")) map.put("b", map.get("a"));
            if (map.containsKey("b")) map.put("a", map.get("b"));
        }
        return map;
    }


    public static Map<String, String> mapAB4(Map<String, String> map) {
        if ((map.containsKey("a") && map.containsKey("b"))) {
            if (map.get("a").length() == map.get("b").length()) {
                map.put("a", "");
                map.put("b", "");
                return map;
            }
            if (map.get("a").length() > map.get("b").length())
                map.put("c", map.get("a"));
            else map.put("c", map.get("b"));
        }
        return map;
    }


    public static Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s, 0);
        return map;
    }

    public static Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s, s.length());
        return map;
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String s : strings)
            map.put(s.substring(0, 1), s.substring(s.length() - 1, s.length()));
        return map;
    }

    public static Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings)
            map.put(s, 0);
        for (String s : strings)
            map.put(s, map.get(s) + 1);
        return map;
    }

    public static Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String s : strings)
            map.put(s.substring(0, 1), "");
        for (String s : strings)
            map.put(s.substring(0, 1), map.get(s.substring(0, 1)) + s);
        return map;
    }


    public static String wordAppend(String[] strings) {
        String str = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i]))
                map.put((strings[i]), map.get(strings[i]) + 1);
            else map.put(strings[i], 1);
            if (map.get(strings[i]) % 2 == 0) str = str + strings[i];
        }
        return str;
    }


    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i]))
                map.put((strings[i]), true);
            else map.put(strings[i], false);

        }
        return map;
    }

    public static String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i].substring(0, 1))) {
                String pomoc = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = pomoc;
                map.replace(strings[i].substring(0, 1), 0);
            } else map.put(strings[i].substring(0, 1), i);
        }
        return strings;
    }


    public static String[] firstSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if ((map.containsKey(strings[i].substring(0, 1))) && !map2.containsKey(strings[i].substring(0, 1))) {
                String pomoc = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = pomoc;
                map.remove(strings[i].substring(0, 1));
                map2.put(strings[i].substring(0, 1), i);
            } else map.put(strings[i].substring(0, 1), i);
        }
        return strings;
    }

    public static String[] firstSwap2(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].charAt(0) + "";
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else {
                int j = map.get(key);
                if (j == 1000) {
                    continue;
                } else {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                    map.put(key, 1000);

                }

            }
        }
        return strings;
    }

    public static List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }


    public static List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }

    public static List<String> addStar(List<String> strings) {
        strings.replaceAll(n -> n + "*");
        return strings;
    }

    public static List<String> copies3(List<String> strings) {
        strings.replaceAll(n -> n + n + n);
        return strings;
    }


    public static List<String> moreY(List<String> strings) {
        strings.replaceAll(n -> "y" + n + "y");
        return strings;
    }

    public static List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n + 1) * 10);
        return nums;
    }

    public static List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }

    public static List<String> lower(List<String> strings) {
        strings.replaceAll(n -> n.toLowerCase());
        return strings;
    }

    public static List<String> noX(List<String> strings) {
        strings.replaceAll(n -> n.replace("x", ""));
        return strings;
    }

    public static List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(n -> n < 0);
        return nums;
    }

    public static List<Integer> noNeg1(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());
    }


    public static List<Integer> no9(List<Integer> nums) {
        nums.removeIf(n -> n % 10 == 9);
        return nums;
    }

    public static List<Integer> no91(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 10 != 9)
                .collect(Collectors.toList());
    }

    public static List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf((n -> n >= 13 && n <= 19));
        return nums;
    }

    public static List<String> noZ(List<String> strings) {
        strings.removeIf(n -> n.contains("z"));
        return strings;
    }


    public static List<String> noLong(List<String> strings) {
        strings.removeIf(n -> n.length() >= 4);
        return strings;
    }

    public static List<String> no34(List<String> strings) {
        strings.removeIf(n -> n.length() == 3 || n.length() == 4);
        return strings;
    }

    public static List<String> noYY(List<String> strings) {
        strings.replaceAll(n -> n + "y");
        strings.removeIf(n->n.contains("yy"));
        return strings;
    }

    public static List<Integer> two2(List<Integer> nums) {
    nums.replaceAll(n->n*2);
    nums.removeIf(n->n%10==2);
    return nums;
    }


    public static List<Integer> square56(List<Integer> nums) {
    nums.replaceAll(n->n*n+10);
    nums.removeIf(n->n%10==5 || n%10==6);
    return nums;
    }

    public static List<Integer> square561(List<Integer> nums) {
        return nums.stream()
                .map(n->n*n+10)
                .filter(n->n%10!=5)
                .filter(n->n%10!=6)
                .collect(Collectors.toList());
    }


}



