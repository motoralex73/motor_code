package regex;

//Имена групп
public class RegexGroupName {

    public static void main(String[] args) {

        System.out.println("abc".replaceAll("(?<ALetter>a)", "${ALetter}-"));
        //обращение к группам, можно по номерам групп
        System.out.println("abcdef".replaceAll("(a)(?<x>b)(c)(?<y>d)","$1$2$3$4"));
        //можно по названиям групп
        System.out.println("abcdef".replaceAll("(a)(?<x>b)(c)(?<y>d)","$1${x}$3${y}"));
        System.out.println("abcdef".replaceAll("(a)(?<x>b)(c)(?<y>d)","${y}"));
    }
}
