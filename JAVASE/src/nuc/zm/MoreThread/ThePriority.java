package nuc.zm.MoreThread;

/**
 * 优先级
 *
 * @author zm
 * @date 2022/10/16
 */
public class ThePriority {

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();
        thread01.setPriority(1);
        thread02.setPriority(10);
        thread01.start();
        thread02.start();
    }


    static class Thread01 extends Thread {
        @Override
        public void run() {
            for (int i = 10; i < 21 ; i++) {
                System.out.println(i);
            }
        }
    }

    static class Thread02 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }
}
