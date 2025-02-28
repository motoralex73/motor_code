package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
//создает пулл потоков
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MtRunnable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();
    }

    static class MtRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Callable";
        }
    }




}
