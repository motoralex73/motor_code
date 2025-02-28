package threads;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ThreadExampleCode {

    volatile static int i = 0;

    static class ReadInfo extends Thread {
        public synchronized int getI() {
            return i;
        }
        @Override
        public void run() {
            while (true) {
                System.out.println("--------- Get parameter i = " + getI());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class WriteInfo extends Thread {

        public synchronized void setI(int i1) {
            i = i1;
        }
        @Override
        public void run() {
            while (true) {

                System.out.println("Set parameter i = " + ++i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ReadInfo readInfo = new ReadInfo();
        readInfo.start();
        WriteInfo writeInfo = new WriteInfo();
        writeInfo.start();


    }
}
