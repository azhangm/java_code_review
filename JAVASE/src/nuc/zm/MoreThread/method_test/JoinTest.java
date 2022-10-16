package nuc.zm.MoreThread.method_test;

/**
 * 加入测试
 * 当一个线程 调用 了 join 方法后 这个线程会被优先执行   调用 join 方法 其他方法转为 waiting 状态
 * @author zm
 * @date 2022/10/16
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 10; i ++) {
            if (i == 6) {
//                test thread was created
                TestThread t = new TestThread("子线程");
                t.start();
//                子线程走完 主线程才走
                t.join();

            }
            System.out.println ( " main ----" + i);
        }
    }

        static class TestThread extends Thread {

            public TestThread(String name) {
                super(name);
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName() +  i);

            }
                for (Thread thread : Thread.getAllStackTraces().keySet()) {
                        System.out.println(thread.getName() + "- --- " +   thread.getState());
                }
            }
        }

}
