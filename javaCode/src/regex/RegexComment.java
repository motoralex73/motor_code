package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Комметарии в регулярных выражениях
public class RegexComment {



    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("(?x)a#aLetter").matcher("a");
        RegexGroup.func(m1);
        Matcher m2 = Pattern.compile("(?x)a b c#year(19|20)").matcher("abcd");
        RegexGroup.func(m2);

    }
}
