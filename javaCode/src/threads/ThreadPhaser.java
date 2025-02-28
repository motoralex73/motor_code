package threads;

import java.util.concurrent.Phaser;

public class ThreadPhaser {

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }
        @Override
        public void run() {
            for (int i=0;i<3;i++) {
                System.out.println(getName() + " washing the car number = " + i);
                phaser.arriveAndAwaitAdvance();
                //phaser ждет пока все потоки завершат текущий этап и потом переходят на следующий,
                // моют по очереди одну машину, потом следующую.
            }
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }
}
