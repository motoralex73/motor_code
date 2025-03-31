package regex;

//Группа, которая начинается с символа ?>
public class RegexAtomicGroup {
    public static void main(String[] args) {
        System.out.println("abcc".matches("a(bc|b)c"));
        System.out.println("abc".matches("a(bc|b)c"));
//Atomic group
        //ищем a, bc, c по очереди, удачно
        System.out.println("abcc".matches("a(?>bc|b)c"));
        //ищем a, bc, c по очереди, неудачно
        System.out.println("abc".matches("a(?>bc|b)c"));

        //работает медленно засчет многократной проверки каждого параметра
        System.out.println("integers".matches("\\b(integer|insert|in)\\b"));
        //данный вариант работает намного быстрее засчет того, что обход осуществляется без возврата коретки для проверки, последовательным сравнением
        System.out.println("integers".matches("\\b(?>integer|insert|in)\\b"));
    }
}
