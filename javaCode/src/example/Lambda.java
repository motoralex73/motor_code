package example;

import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

//Метод, без имени, записанный коротким способом. Синтаксическая конструкция, используемая для создания анонимных функций на лету.
public class Lambda {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            example();
        }
        public void example() {
            Runnable runnable = () -> {
                while(true)
                    System.out.println("Hello");
            };
            Runnable runnable1 = () -> {
                while(true)
                    System.out.println("Goodbye");
            };
            new Thread(runnable).start();
            new Thread(runnable1).start();
        }
    };

    public static void main(String[] args) {

//        IntConsumer intConsumer = (int x) -> System.out.println("hello " + x);
//        intConsumer.accept(123);

        String s = "hello";
        ActionListener actionListener = (event) -> System.out.println(event.paramString() + s);

        //запуск 2 потоков из класса лямбда
        //new Lambda().r.run();

        Stream<String> stream = Stream.of("1","2","3","4","5");
        stream.parallel()
                .sorted( (ss1, ss2) -> {
                    System.out.println("sort: " + ss1 + " " + ss2);
                    return ss1.compareTo(ss2);
                } )
                .map(s1 -> {
                    System.out.print(s1);
                    return " and "+ s1 +"! " + Thread.currentThread().getName();
                })
                .map(s2 -> {
                    System.out.println(s2);
                    return " nameThread = " + Thread.currentThread().getName();
                })

                .forEach(x -> System.out.println(x + " --- " + Thread.currentThread().getName()));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.getPoolSize());
    }
}
