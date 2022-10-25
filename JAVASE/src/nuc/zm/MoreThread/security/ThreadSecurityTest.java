package nuc.zm.MoreThread.security;


import java.util.HashSet;

/**
 * 线程安全测试
 * 解决 线程共享资源问题
 * 同步代码块加锁
 * @author zm
 * @date 2022/10/16
 */
public class ThreadSecurityTest {
    public static void main(String[] args) {
        ByTicketThread thread1 = new ByTicketThread("窗口1");
        ByTicketThread thread2 = new ByTicketThread("窗口2");
        ByTicketThread thread3 = new ByTicketThread("窗口3");
            start(thread1,thread2,thread3);
    }

    static void start(Thread t1,Thread t2,Thread t3) {
        t1.start();
        t2.start();
        t3.start();
    }
    static class ByTicketThread extends Thread {

        public ByTicketThread(String name) {
            super(name);
        }

        //  静态变量的功能：被同类的所有实例共享的变量。 多个对象共享十张票
        static int ticketNum = 10;
        static  int count ;
//        ticketNum --   ===== 非原子性操作  赋值 之后 在 --

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                    锁可能出现线程安全的问题
                synchronized (this) {
                    if (ticketNum > 0) {
                        count ++;
                            System.out.println(
                                    "我 从====" + Thread.currentThread().getName() + "====北京到哈尔滨的车票 现在剩余车票" + ticketNum--);

                        }
                    }
                }
            System.out.println(count);
        }

        }
    }
