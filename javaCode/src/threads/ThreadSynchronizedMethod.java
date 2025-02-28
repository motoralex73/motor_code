package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronizedMethod {

    static class SyncListCLass {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void addName(String name) {
            list.add(name);
        }

        public synchronized String getName() {
            if (list.size() > 0) {
                if (Thread.currentThread().getName().equals("one")) {
                    Thread.yield();
                }
                return (String) list.remove(0);
            }
            return null;
        }
    }

    static class Resource {
        int i, j;
        Lock lock = new ReentrantLock();

        void changeI() {
            lock.lock();
            int i = this.i;
            i++;
            this.i = i;
        }

        void changeJ() {
            int j = this.j;
            j++;
            this.j = j;
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SyncListCLass nameList = new SyncListCLass();
        nameList.addName("first");

        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.getName());
            }
        }

        MyThread thread = new MyThread();
        thread.setName("one");
        thread.start();
        new MyThread().start();

    }




}
