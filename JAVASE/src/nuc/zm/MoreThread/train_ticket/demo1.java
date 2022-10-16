package nuc.zm.MoreThread.train_ticket;

/**
 * demo1
 * @description 买火车票 thread 1
 * @author zm
 * @date 2022/10/15
 */
public class demo1 {

    public static void main(String[] args) {
        ByTicketThread thread1 = new ByTicketThread("窗口1");
        ByTicketThread thread2 = new ByTicketThread("窗口2");
        ByTicketThread thread3 = new ByTicketThread("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    /*
    *   买票 重复问题
    *   我 从====窗口1====北京到哈尔滨的车票 现在剩余车票10
        我 从====窗口3====北京到哈尔滨的车票 现在剩余车票10
        我 从====窗口2====北京到哈尔滨的车票 现在剩余车票9
        我 从====窗口3====北京到哈尔滨的车票 现在剩余车票7
        我 从====窗口1====北京到哈尔滨的车票 现在剩余车票8
        我 从====窗口3====北京到哈尔滨的车票 现在剩余车票5
        我 从====窗口2====北京到哈尔滨的车票 现在剩余车票6
        我 从====窗口3====北京到哈尔滨的车票 现在剩余车票3
        我 从====窗口1====北京到哈尔滨的车票 现在剩余车票4
        我 从====窗口3====北京到哈尔滨的车票 现在剩余车票1
        我 从====窗口2====北京到哈尔滨的车票 现在剩余车票2
    *
    * */

    }

     static class ByTicketThread extends Thread {

        public ByTicketThread(String name) {
            super(name);
        }
//  静态变量的功能：被同类的所有实例共享的变量。 多个对象共享十张票
        static int ticketNum = 10;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (ticketNum > 0)
                System.out.println(
                        "我 从====" + Thread.currentThread().getName() + "====北京到哈尔滨的车票 现在剩余车票" + ticketNum --
                );
            }
        }
    }
}
