package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMyExample {

    public static void main(String[] args) {
        Matcher m1 = Pattern.compile("cat").matcher("My super cat is the best of many cats");
        RegexGroup.func(m1);

        Matcher m2 = Pattern.compile("ab").matcher("abbbabba");
        RegexGroup.func(m2);

        //ищет все вхождения aba, повторно входные символы не использует в поиске
        Matcher m3 = Pattern.compile("aba").matcher("ababaabab");
        RegexGroup.func(m3);

        //ищет все числа
        Matcher m4 = Pattern.compile("\\d+").matcher("a12c34b56er789ff");
        RegexGroup.func(m4);

        //ищет словосочетание proj1 с любым последующим символом, кроме ","
        Matcher m5 = Pattern.compile("proj1([^,])*").matcher("proj3.txt,proj56,proj2,proj1.java");
        RegexGroup.func(m5);

        //ищет 3 цифры, затем тире, либо пробел, потом еще 4 цифры
        Matcher m6 = Pattern.compile("\\d\\d\\d([-\\s])?\\d\\d\\d\\d").matcher("123 4567");
        RegexGroup.func(m6);

        //ищет a.c, находим "a c"
        Matcher m7 = Pattern.compile("a.c").matcher("ac abc a c");
        RegexGroup.func(m7);

        //найдет полностью всё из-за жадности, иначе добавить *?xx. Не найдет ничего, если .*+xx
        Matcher m8 = Pattern.compile(".*xx").matcher("yyxxxyxx");
        RegexGroup.func(m8);
    }
}
