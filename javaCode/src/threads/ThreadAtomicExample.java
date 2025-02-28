package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicExample {

    //позволяет делать инкремент переменной стабильно из разных потоков
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static class MyThreadAtomic extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j=0; j<100_000; j++)
        {
            new MyThreadAtomic().start();
        }
        Thread.sleep(1000);
        System.out.println(atomicInteger);
    }


}
