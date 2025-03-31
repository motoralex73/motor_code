package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Группа регул выражений, ссылки на группу регул выражений (backreferences) //?: не использовать обратные ссылки
//Группы создаются при помощи (), если мы не хотим к больше ссылаться, то должны поставить знак ?:
//если какая-то замена, то $1, $0 - всё выражение
public class RegexGroup {

    //функция для распечатки матчера по регулярному выражению
    static void func(Matcher m) {
        while (m.find()) {
            System.out.print("["+m.start() + "] = " + m.group() + ". ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Matcher m1 = Pattern.compile("Set(Value)?").matcher("Set or SetValue");
        func(m1);

        //Вставка по регулярному выражению
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","$1 version"));
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","$0 version"));
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","$1 version").toUpperCase());
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","\\U1 version").toUpperCase());
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","\\L1 version").toLowerCase());
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","\\F1 version"));
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","\\I1 version"));

        //Поиск всех тэгов в предложении
        Matcher m2 = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>").matcher("This is a <EM>Title</EM> hello");
        // \\1 - здесь должно быть выражение из первой группы, например <EM>
        func(m2);

        //Ссылка должна быть в регул выражении
        Matcher m3 = Pattern.compile("([a-c])x\\1x\\1").matcher("axaxa");
        func(m3);
        //Поиск повторяющихся слов
        System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1\\b", "$1"));

    }
}
