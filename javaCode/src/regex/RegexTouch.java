package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTouch {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ", ");
        }
        System.out.println(" ");
    }

    //разделители слов
    static void wordBreaking() {
        Matcher m = Pattern.compile("\\bis\\b").matcher("This island is a beautiful");
        func(m);
    }

    public static void main(String[] args) {
        // . - отвечает за любой символ, кроме символа конца строки
        // * - этих символов может быть много
        Matcher m = Pattern.compile("\\d\\d[-/.]\\d\\d[-/.]\\d\\d").matcher("12-34.56");
        func(m);
        Matcher m1 = Pattern.compile("\".*\"").matcher("Put a\"string\" between double quotes");
        func(m1);
        wordBreaking();
    }
}
