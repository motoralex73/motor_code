package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Множественные выражения
public class RegexManyRegex {

    public static void main(String[] args) {

        //Находим слово из 6 букв, в котором содержится слово cat
        Matcher m1 = Pattern.compile("(?=\\b\\w{6}\\b)\\w*cat\\w").matcher("wecate");
        RegexGroup.func(m1);
        //Находим слово из 6-12 букв, котором содержится cat or dog or mouse
        Matcher m2 = Pattern.compile("\\b(?=\\w{6,12}\\b)\\w{0,9}(cat|dog|mouse)\\w*").matcher("wemouset1");
        RegexGroup.func(m2);
    }
}
