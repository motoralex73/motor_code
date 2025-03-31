package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Наборы символов
public class RegexCharacters {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ", ");
        }
        System.out.println(" ");
    }

    static void example() {
        Pattern p = Pattern.compile("[a-b0-5A-Z]"); //регулярное выражение для поиска любых символов
        Matcher m = p.matcher("abcdb1"); //строка для проверки

        func(m);
    }

    static void example1() {
        Pattern p = Pattern.compile("gr[aeuy]y"); //регулярное выражение для поиска строки с разными вариантами букв внутри a,e,u,y
        Matcher m = p.matcher("grey"); //строка для проверки

        func(m);
    }

    static void example2() {
        Matcher m = Pattern.compile("[+]").matcher("1 + 1 = 2");
        func(m);
    }

    static void example3() {
        Matcher m = Pattern.compile("q[^u]").matcher("Iraq! is a country"); //символ отрицание, найти букву q, за которым следует любой символ, кроме буквы u
        func(m);
    }

    static void example4() {
        Matcher m = Pattern.compile("\\Q[-]\\E").matcher("123[-]555");
        func(m);
    }

    static void example5() {
        Matcher m = Pattern.compile("\\d").matcher("sadasd 57 ggg"); //ищет все цифры [0-9]  D = отрицание d
        Matcher m1 = Pattern.compile("\\w").matcher("sadasd 57 ggg"); //ищет все символы [a-ZA-Z]  W = отрицание w
        Matcher m2 = Pattern.compile("\\s").matcher("sadasd 57 ggg"); //ищет пробелы и табуляции S = отрицание s
        func(m);
        func(m1);
        func(m2);
    }

    public static void main(String[] args) {
        example();
        example1();
        example2();
        example3();
        example4();
        example5();
    }
}
