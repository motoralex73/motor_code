package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUnicode {

    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("\u00E0").matcher("a");
        RegexGroup.func(m1);
        Matcher m2 = Pattern.compile("\\x{00E0}").matcher("a");
        RegexGroup.func(m2);
        System.out.println(00E0);
    }
}
