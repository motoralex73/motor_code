package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Символды * и +
//* - говорит о том, что символ, который идет перед ним может быть повторен от 0 до бесконечности раз
//+ - (a+) - от 0 до бесконечности раз
//выражение в {}, например, {2,4}
//найти все тэги <>
public class RegexSymbolAsteriskAndPlus {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ". ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Matcher m = Pattern.compile("<[A-Za-z][A-Za-z0-9]*").matcher("<h1>");
        func(m);
        Matcher m1 = Pattern.compile("\\b[1-9][0-9]{2,4}").matcher("1000 12 1234 9999");
        func(m1);
        Matcher m2 = Pattern.compile("<.+>").matcher("This is a <EM>first</EM> test"); //жадное поведение, ищет все включения
        func(m2);
        Matcher m3 = Pattern.compile("<.+?>").matcher("This is a <EM>first</EM> test"); //ленивое поведение, ищет первое включение и перестает искать
        func(m3);
        Matcher m4 = Pattern.compile("<[^>]+>").matcher("This is a <EM>first</EM> test"); //ищет любой набор символов, который не заканчивается знаком >
        func(m4);

    }
}
