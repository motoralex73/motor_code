package threads;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        ThreadFactory th = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        th.newThread(new MyRun()).start();
    }
}
