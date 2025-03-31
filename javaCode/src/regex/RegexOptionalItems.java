package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Опциональные символы (?), которые могут быть, а могут и не быть
//colou?r - u может не быть
//Nov(ember) - может иметь сокращение
//Nov(ember)? - greedy жадный
//Nov(ember)?? - reluctant ленивый
public class RegexOptionalItems {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ". ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Matcher m = Pattern.compile("Feb(ruary)? 23(rd)?").matcher("February 23rd, February 23, Feb 23rd, Feb 23");
        func(m);
    }
}
