package nuc.zm.concurrent.concurrent;

/**
 * 加入测试
 *
 * @author zm
 * @date 2023/02/04
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
//        在 main 线程中间插入 thread 线程
        thread.join();
        System.out.println(Thread.currentThread().getName() + "线程结束");
    }
    static  class  MyThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i ++) {
                System.out.println(i);
            }
        }
    }
}
