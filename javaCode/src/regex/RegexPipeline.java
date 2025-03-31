package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Разделительная черта, обозначение или, кот или собака
public class RegexPipeline {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group());
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Matcher m = Pattern.compile("SetValue").matcher("Get|Set|GetValue|SetValue");
        func(m);
    }
}
