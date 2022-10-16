package nuc.zm.MoreThread.method_test;

/**
 * 守护线程 练习
 * 守护线程 伴随 主线程 执行
 * 主线程停止的时候 子线程也不需要执行啦
 * 守护线程 垂死挣扎
 * @author zm
 * @date 2022/10/16
 */
public class DaemonThread {

    static class  Thread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("子线程   ====   "  + i);
            }
        }
    }

    public static void main(String[] args) {
        java.lang.Thread thread = new java.lang.Thread(new Thread());
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main ===" + i );
        }
    }

}
