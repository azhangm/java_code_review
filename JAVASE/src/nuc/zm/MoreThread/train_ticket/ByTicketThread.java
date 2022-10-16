package nuc.zm.MoreThread.train_ticket;

public class ByTicketThread extends Thread {
    int ticketNum = 100;

    public ByTicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "卖出了第" + ticketNum -- + "张票");
    }
}
