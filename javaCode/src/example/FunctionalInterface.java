package example;

import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalInterface {

    //functional interface
    interface MyPredicate<T> {
        void apply(T t);
    }

    //functional method
    static class Student {
        String name;
        public Student(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        //функциональный интерфейс, логическое утверждение (true-false)
        Predicate<Integer> predicate = x -> x > 5;
        System.out.println(predicate.test(10));

        Consumer<Integer> consumer = x -> System.out.println(x);
        Function<Integer, String> function = x -> x.toString();
        Supplier<Integer> supplier = () -> new Integer(5);
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;

        MyPredicate<Integer> myPredicate = x -> System.out.println(x);
        myPredicate.apply(123);

        //функциональный метод Student::getName заместо лямбды см ниже
        Stream.of(new Student("Serega"), new Student("Stas")).map(Student::getName).forEach(x -> System.out.println(x));
        //Stream.of(new Student("Serega"), new Student("Stas")).map(x -> x.getName()).forEach(x -> System.out.println(x));
        Stream.of("Serega", "Andrey").map(Student::new).forEach(x -> System.out.println(x));
    }
}
