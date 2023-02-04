package nuc.zm.concurrent.concurrent;

/**
 * 我线
 *
 * @author zm
 * @date 2023/02/04
 */
public class MyThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread01().start();
        new Thread(new Thread02()).start();
    }
    static  class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println( Thread.currentThread().getName() + " 线程运行起来了");
        }
    }

    static class Thread02 implements Runnable {

        @Override
        public void run() {
            System.out.println("实现接口的线程运行起来了");
        }
    }
}
