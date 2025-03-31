package regex;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Паттерн для проверки строки на содержание определенного выражения
public class RegexSimpleExample {

    static String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    static void example() {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("epta email is mymail@mail.ru");
        while (m.find()) {
            System.out.println(m.start() + " " + m.group() + " ");
        }
    }

    static void example2() {
        Pattern p = Pattern.compile("a");
        Matcher m = p.matcher("Jack is a boy");
        while (m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");
    }

    static void example3() {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("Jack is a cat, have a nice day");
        while (m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");
    }

    //special symbols:
    //[]\^$.|?*+() - эти спец символы нужно экранировать

    static void example4() {
        //Pattern p = Pattern.compile("1\\+2=3");
        //обрамление выражения, которое будет использоваться как регулярное и по нему будет производиться поиск
        Pattern p = Pattern.compile("\\Q1+2=3\\E");
        Matcher m = p.matcher("00012341+2=3345345");
        System.out.print("example 1+2=3: ");
        while (m.find()) {
            System.out.print(m.start() + " " + m.group());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("mail@mail.ru".matches(regex));
        example();
        example2();
        example3();
        example4();
    }
}
