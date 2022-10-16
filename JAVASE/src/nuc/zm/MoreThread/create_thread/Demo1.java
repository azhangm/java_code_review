package nuc.zm.MoreThread.create_thread;

import nuc.zm.io.ObjectIOTest.Object;

/**
 * demo1
 * @description 创建线程的方式 1
 * @author zm
 * @date 2022/10/15
 */
public class Demo1 {


    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        for (int i = 0; i < 10; i++) {
            System.out.println("不会出现争夺资源的main" + i);
        }
        Thread thread = Thread.currentThread();
        thread.setName("主线程");
//        让子线程先启动 才会出现 和主线程抢夺资源的情况hh
        testThread.setName("子线程");
        testThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName() + i);
        }

    }

      static class TestThread extends Thread {
          /**
           * 运行
           * 线程对象 争抢资源的任务 必须放在 run 方法中
           */
          @Override
          public void run() {
              super.run();
              for (int i = 0; i < 10; i++) {
                  System.out.println(getName()  + " ==== " + i);
              }
          }
      }
}
