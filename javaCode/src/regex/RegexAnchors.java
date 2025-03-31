package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Якоря, вставляется между символами, символ начала и конец строки
public class RegexAnchors {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group());
        }
        System.out.println(" ");
    }

    // ^a - символ начала строки
    // b$ - символ конца строки, не учитывает \n
    // \\Z - символ конца строки, учитывает \n
    // \\d+ - найдет строку, в которой есть только цифры в любом количестве
    // ^\\d+$ - от начала и до конца строки должны быть только символы
    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("^ab", Pattern.MULTILINE).matcher("abcdef");
        Matcher m2 = Pattern.compile("c$").matcher("abc");
        Matcher m3 = Pattern.compile("\\d+").matcher("abcdef 123123567");
        Matcher m4 = Pattern.compile("^\\d+$").matcher("34567");

        func(m1);
        func(m2);
        func(m3);
        func(m4);

    }
}
