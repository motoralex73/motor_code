package example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorExample {

    public static void main(String[] args) {
        Stream.of("one","two").collect(Collectors.toCollection(ArrayList::new));
        Stream.of("one","two").collect(maxBy(Comparator.comparing(x -> x)));

        Map<Boolean, List<Integer>> map = Stream.of(1,2,3,4).collect(partitioningBy(x -> x > 2));
        System.out.println("map = " + map);
        Map<Integer, List<Integer>> map2 = Stream.of(1,2,3,4,5,6,7).collect(groupingBy(x -> x));
        System.out.println("map2 = " + map2);

        Map<Integer, Long> map3 = Stream.of(1,2,3,1,4,5).collect(groupingBy(x -> x, counting()));
        System.out.println("how many have number 1 = "+map3.get(1));
    }
}
