package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadScheduledExecutorService {

    static class MyThreadScheduledExecutor extends Thread {
        @Override
        public void run() {
            System.out.println(1);
        }
    }


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyThreadScheduledExecutor(), 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
