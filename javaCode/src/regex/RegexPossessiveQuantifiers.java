package regex;

import patterns.PatternsTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//*+  ++  ?+
//нужны для того, чтобы работать быстрее, идут до конца строки и ищут нужное вхождение
public class RegexPossessiveQuantifiers {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ". ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("\"[^\"]*+\"").matcher("\"abc\"x");
        func(m1);



    }
}
