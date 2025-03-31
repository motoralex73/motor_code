package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//(?=(regex))reg
 public class RegexLookAround {

    public static void main(String[] args) {

        //lookahead (перед)
        //хочу найти букву "u" после буквы q (либо чтобы не шла !=u)
        Matcher m1 = Pattern.compile("q(?=u)").matcher("Iraqu");
        System.out.print("m1 = ");
        RegexGroup.func(m1);
        Matcher m2 = Pattern.compile("q(?!u)").matcher("Iraqu");
        System.out.print("m2 = ");
        RegexGroup.func(m2);
        //lookbehind (после)
        Matcher m3 = Pattern.compile("(?<=a)b").matcher("cab");
        System.out.print("m3 = ");
        RegexGroup.func(m3);
        Matcher m4 = Pattern.compile("(?<!a)b").matcher("cab");
        System.out.print("m4 = ");
        RegexGroup.func(m4);
        Matcher m5 = Pattern.compile("\\b\\w+(?<!s)\\b").matcher("John's");
        System.out.print("m5 = ");
        RegexGroup.func(m5);
    }
}
