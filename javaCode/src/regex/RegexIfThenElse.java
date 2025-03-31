package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// (?(?=condition)(then1|then2|then3)|(else1|else2))
public class RegexIfThenElse {

    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("(a)?b((1)c|d)").matcher("abd");
        RegexGroup.func(m1);


    }
}
