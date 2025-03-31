package threads;

public class ThreadExample {

    static class MyThreadClass extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThreadClass name = "+Thread.currentThread().getName());
        }
    }

    static class MyRunnableClass implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnableClass name = "+Thread.currentThread().getName());
        }
    }

    //@SneakyThrows
    static class MyThreadClassInside extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnableClassInside name = "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //1
        MyThreadClass myThreadClass = new MyThreadClass();
        myThreadClass.start();
        //myThreadClass.join(); //все ждут пока выполнится данный поток
        //myThreadClass.yield();  //отдай время другому потоку
        //2
        MyRunnableClass myRunnableClass = new MyRunnableClass();
        Thread threadRunnable = new Thread(myRunnableClass);
        threadRunnable.start();
        threadRunnable.join();
        //3
        new MyThreadClassInside().start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        thread.start();






    }
}
