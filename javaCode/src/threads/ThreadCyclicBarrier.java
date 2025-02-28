package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier {

    static class Run extends Thread {
        @Override
        public void run() {
            System.out.println("Run is begun");
        }
    }

    static int count = 0;
    static class Sportsman extends Thread {
        CyclicBarrier barrier;
        public Sportsman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                barrier.await();
                do {
                    System.out.println("barrier.await() = " + ++count);
                }
                while (count < 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//ограничение количества потоков
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());

        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);


    }
}
