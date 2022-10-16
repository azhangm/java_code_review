package nuc.zm.MoreThread.create_thread;

/**
 * 以及接下来
 * 实现 Runnable 接口 成为线程类
 * @author zm
 * @date 2022/10/16
 */
public class Demo2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
        }
    }

//   main 线程 启动器
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread thread = new Thread(demo2);
        thread.setName("子线程~~");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "========" + i);
        }
    }
}
