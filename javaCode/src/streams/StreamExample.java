package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("3");

        //Stream<String> stream = strings.stream();
        //stream.forEach(x -> System.out.println(x));

        strings.stream().forEach(x -> System.out.println(x.toUpperCase()));

        Stream<String> stringStream = strings.stream().filter(x -> {
            System.out.println("hello");
            return x.equals("one");
        }); //lazy
        stringStream.forEach(x -> System.out.println(x));// eager

        System.out.println(strings.stream().collect(Collectors.toList()));
        int val1 = Stream.of(1,2).min(Comparator.comparing(x -> x)).get();
        int val2 = Stream.of(1,2).max(Comparator.comparing(x -> x)).get();

        Integer count = Stream.of(1,2,3).reduce(0, (acc, element) -> acc + element);
        System.out.println(count );

        Stream.of("one", "two").sorted().collect(Collectors.toList());
        Stream.of("one", "two").limit(1).collect(Collectors.toList());
        //когда 2 одинаковых значения делаем уникальными, чтобы они не повторялись, оставляет одно значение в коллекции
        System.out.println("distinct = " + Stream.of("one", "one").distinct().collect(Collectors.toList()));
        //говорит сколько значений пропустить, начинать с n-ного
        Stream.of("one", "one").skip(1).collect(Collectors.toList());
        //фильтруем и находим любой элемент
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().get();
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().isPresent();
        //складываем инты
        Stream.of(1, 2).mapToInt(x -> x).sum();
        System.out.println("count = " + Stream.of(1, 2, 3, 4).count());
        //преобразуем поток элементов по аппер кейсу
        Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get();

        IntStream intStream = Stream.of(1, 2).mapToInt(x -> x);
        intStream.summaryStatistics().getAverage();

        String s = "hello people";
        Stream.of(s).map(x -> x+" "+x).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder("happy new year");
        System.out.println("string builder find first = " + Stream.of(stringBuilder).findFirst());
    }
}
