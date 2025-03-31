package example;

import java.lang.reflect.Array;
import java.util.*;

public class Example {

    static void add() {
        char ch[] = {0x47, 0x75, 0x6c, 0x6e, 0x61, 0x7a};
        System.out.println(ch);

        String str = "Hello";
        System.out.println("Адрес памяти строки = " + System.identityHashCode(str));
        str += " goodbye";
        System.out.println("Адрес памяти строки = " + System.identityHashCode(str));
    }

    static boolean check(int[] m) {

        boolean check = false, workBig = false;

        for (int i = 0; i < m.length - 1; i++) {
            if (i > 0) {
                if (m[1] > m[0]) workBig = true;
                if (workBig == true) {
                    if (m[i+1] > m[i]) check = true;
                    else return false;
                }
                else {
                    if (m[i+1] < m[i]) check = true;
                    else return false;
                }
            }
        }
        return check;
    }

    static void checkMassive() {

        int m1[] = {1,2,3,4,5,6,7,8}; //true
        int m2[] = {15,9,6,4,1};      //true
        int m3[] = {12,15,17};        //true
        int m4[] = {55,6,4,25};       //false

        System.out.println("check = "+check(m4));
    }

    static void plus2List() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,12,2,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,13,3,4));

        for (Integer a : list1) list2.add(a);
        Collections.sort(list2);
        System.out.println(list2);
    }

    public static void main(String[] args) {

        checkMassive();
        plus2List();

    }
}
