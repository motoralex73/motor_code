package threads;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ThreadForkJoinFramework {

    static long num = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= num/numOfThreads) {
                long j = 0;
                for (long i=from; i<to;i++) j += i;
                return j;
            }
            else {
                long mid = (to + from)/2;
                MyFork firshHalf = new MyFork(from, mid);
                firshHalf.fork();
                MyFork secondHalf = new MyFork(mid+1, to);
                long secondValue = secondHalf.compute();
                return firshHalf.join() + secondValue;
            }
        }
    }

    public static void main(String[] args) {
        long j = 0;
        System.out.println(new Date());
        //for (int i = 0; i < num; i++) j += i;
        //System.out.println(j);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new MyFork(0, num)));
        System.out.println(new Date());
    }




}
