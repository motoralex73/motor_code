package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

//Параллелизм в стримах (на нескольких ядрах)
public class ParallelExample {

    public static void main(String[] args) {

//        Stream stream = Stream.of(1,2).parallel();
//        List list = new ArrayList<>();
//        list.parallelStream();

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            integers.add(i);
            integers.add(100_000_000 - i);
        }
        long t1 = new Date().getTime();
        integers.parallelStream()
                .sorted()
                .filter(x -> x % 2 == 0)
                .map(x -> new Double(x))
                .forEach(x -> x.toString());
        long t2 = new Date().getTime();
        System.out.println(t2 - t1);

        //параллельный стрим делает операции в произвольном порядке, например, распечатать в парал.стриме данные, то они будут в радномном порядке.
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10000;i++) list.add(i);
        list.parallelStream().forEach(x -> System.out.println(x));
    }
}
