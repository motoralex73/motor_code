package regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexHomeWork {



    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("abc").matcher("abcde");
        RegexGroup.func(m1);
        Matcher m2 = Pattern.compile("[0-3]").matcher("123456789");
        RegexGroup.func(m2);
        Matcher m3 = Pattern.compile("[\\d]").matcher("abcd3eff15m");
        RegexGroup.func(m3);
        Matcher m4 = Pattern.compile("[a-zA-Z]").matcher("15abc23X");
        RegexGroup.func(m4);
        Matcher m5 = Pattern.compile("([a-zA-Z]*[\\d]*)").matcher("January 1974");
        RegexGroup.func(m5);

        String resolution = "1024x768  ->  2048x512";
        Matcher m6 = Pattern.compile("(\\d{3,4}x\\d{3,4})").matcher(resolution);
        String h1 = null, h2 = null;
        //RegexGroup.func(m6);
        while (m6.find()) {
            h1 = m6.group();
            h2 = m6.group();
        }
        System.out.println(h1);
        System.out.println(h2);


    }
}
