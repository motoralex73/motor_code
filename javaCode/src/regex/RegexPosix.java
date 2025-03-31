package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPosix {

    // \p{Lower}  \p{Digit}
    public static void main(String[] args) {

        Matcher m = Pattern.compile("[x-z^\\p{Digit}]").matcher("12345");
        RegexGroup.func(m);
    }
}
