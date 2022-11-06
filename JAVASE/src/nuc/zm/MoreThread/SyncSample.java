package nuc.zm.MoreThread;

import java.util.concurrent.locks.Lock;

/**
 * 同步采样
 * 演示 同步锁
 * @author zm
 * @date 2022/11/06
 */
public class SyncSample {
    static class Printer {
         public void print() {
            synchronized ("DADADADASDADAADADAD") {
                try {
                    Thread.sleep(500);
                    System.out.print("你");
                    Thread.sleep(500);
                    System.out.print("好");
                    Thread.sleep(500);
                    System.out.print("世");
                    Thread.sleep(500);
                    System.out.print("界");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public  synchronized  void print1() {
                try {
                    Thread.sleep(500);
                    System.out.print("你");
                    Thread.sleep(500);
                    System.out.print("好");
                    Thread.sleep(500);
                    System.out.print("世");
                    Thread.sleep(500);
                    System.out.print("界");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        public  static synchronized  void print2() {
            try {
                Thread.sleep(500);
                System.out.print("你");
                Thread.sleep(500);
                System.out.print("好");
                Thread.sleep(500);
                System.out.print("世");
                Thread.sleep(500);
                System.out.print("界");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void start() {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            PrintTask printTask = new PrintTask();
            printTask.printer = printer;
            Thread thread = new Thread(printTask);
            thread.start();
        }

    }
    static class PrintTask implements Runnable {
        private  Printer printer;
        @Override
        public void run() {
                printer.print();
//                printer.print1();
//                Printer.print2();
        }
    }
    public static void main(String[] args) {
        new SyncSample().start();
    }
}
