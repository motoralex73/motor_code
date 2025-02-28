package threads;

import java.util.concurrent.Exchanger;

public class ThreadExchanger {

    static class Mike extends Thread {
        Exchanger<String> exchanger;
        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                exchanger.exchange("Hello, people");
                sleep(1000);
                exchanger.exchange("My name is Alex");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread {
        Exchanger<String> exchanger;
        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                sleep(3000);
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger);
        new Anket(exchanger);
    }
}
