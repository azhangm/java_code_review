package nuc.zm.JVM;

/**
 * clinit死锁
 * @author zm
 * @description 演示 <clinit>()方法 产生死锁的问题
 * @date 2023/02/08
 */
public class ClinitDeadLock {
    public static void main(String[] args) {
        Thread a = new Thread(new LoadClassThread("A"));
        Thread b = new Thread(new LoadClassThread("B"));
        a.start();
        b.start();
    }

    /**
     * 加载类线程
     *
     * @author zm
     * @date 2023/02/08
     */
    static class LoadClassThread implements Runnable {

        String flag;

        public LoadClassThread(String flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                Class.forName("nuc.zm.JVM.ClinitDeadLock$Load" + flag);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(flag + "类加载完毕");
        }
    }
    static class LoadA {
        static {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Class.forName("nuc.zm.JVM.ClinitDeadLock$LoadB");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static class LoadB {  static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("nuc.zm.JVM.ClinitDeadLock$LoadA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
}
