package nuc.zm.MoreThread.train_ticket;

public class Demo2 {


    public static void main(String[] args) {
        BuyTicketThread buyTicketThread = new BuyTicketThread();
        Thread t1 = new Thread(buyTicketThread, "窗口1");
        Thread t2 = new Thread(buyTicketThread, "窗口2");
        Thread t3 = new Thread(buyTicketThread, "窗口3");
        t1.start();
        t2.start();
        t3.start();

        /*
        *
        *
        *   窗口2还剩 9张车票
            窗口1还剩 10张车票
            窗口3还剩 10张车票
            窗口1还剩 7张车票
            窗口2还剩 8张车票
            窗口2还剩 4张车票
            窗口2还剩 3张车票
            窗口1还剩 5张车票
            窗口3还剩 6张车票
            窗口1还剩 1张车票
            窗口2还剩 2张车票
        *
        *
        * */


    }
    /**
     * 买机票线程
     *
     * @author zm
     * @date 2022/10/16
     */
    static class BuyTicketThread implements Runnable {

//        不用 static 就可以共享票票资源 因为只实现一个类
         int ticketNum = 10;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "还剩 " + ticketNum-- + "张车票" );
                }
            }
        }
    }
}
