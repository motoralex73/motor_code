package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ThreadNotifyWait {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    static class Operator extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (strings) {
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine extends Thread {
        @Override
        public void run() {
            while (strings.isEmpty()) {
                synchronized (strings) {
                    try {
                        System.out.println("Wait");
                        strings.wait();
                        System.out.println("End");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(strings.remove(0));
                }
            }
        }
    }

    public static void main(String[] args) {

        new Operator().start();
        new Machine().start();

        //notify - я закончил работу
        //wait - я ожидаю, пока вы закончите


    }
}
