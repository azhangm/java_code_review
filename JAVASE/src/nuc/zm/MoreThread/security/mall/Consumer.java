package nuc.zm.MoreThread.security.mall;

public class Consumer implements Runnable{
    public Mall mall;
    @Override
    public void run() {
        mall.sale();
    }


}
