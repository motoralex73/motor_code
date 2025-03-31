package example;

import java.util.*;

public class ExamplePrintAnyType {

    static void printAnyType(Object c) {
        System.out.println("Simple type = " + c);
    }
    static void printAnyType(Collection c) {
        System.out.println("Collection = " + c);
    }
    static void printAnyType(Map c) {
        System.out.println("Map = " + c);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,12,2,4));
        printAnyType(list);
        Map<String, String> map = new HashMap<>();
        map.put("1","one");
        Set set = new HashSet();
        set.add(1);
        set.add("hello");
        printAnyType(map);
        printAnyType(1.23);
    }
}
