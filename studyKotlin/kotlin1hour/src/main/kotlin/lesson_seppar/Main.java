package lesson_seppar;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static List<Developer> developers = List.of(
            new Developer("Ivan Ivanov",22,"C++"),
            new Developer("Vasya Vasiliev",19,"Java"),
            new Developer("Filat Filatov",45,"Java"),
            new Developer("Maxim Maximov",33,"Python")
    );

    public static void main(String[] args) {
       List<Integer> collect =  developers.stream()
                .map(x -> x.getAge())
                .collect(Collectors.toList());

        System.out.println(collect);
        OptionalDouble average = collect.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println(average); //вывод среднего возраста

        List<Developer> collect1 = developers.stream()
                .sorted(new Comparator<Developer>() {
                    @Override
                    public int compare(Developer o1, Developer o2) {
                        if (o1.getAge() == o2.getAge())
                        return 0;
                        return (o1.getAge() > o2.getAge()) ? 1 : -1;
                    }
                })
                        .collect(Collectors.toList());

        System.out.println(collect1);

        List<Developer> javaDevelopers = Main.developers.stream()
                .filter(x -> "Java".equals(x.getLanguage()))
                .collect(Collectors.toList());
        System.out.println("Список java-разработчиков: "+javaDevelopers);

        Set<Developer> developerSet = developers.stream()
                .filter(x -> x.getAge() > 30)
                .collect(Collectors.toSet());
        System.out.println("Список старичков больше 30: "+developerSet);

        Set<String> stringSet = developers.stream()
                .map(Developer::getLanguage)
                .collect(Collectors.toSet());
        System.out.println("Set языков без повторов: "+stringSet);

        String collect2 = developers.stream()
                .map(Developer::getName)
                .collect(Collectors.joining(", \n"));
        System.out.println("Список пацанчиков: "+collect2);



    }
}
