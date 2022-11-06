package nuc.zm.MoreThread.security.mall;

public class Mall {

    public  void sale() {
        synchronized (this) {
            if (Stock.stock > 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Stock.stock--;
                System.out.println("销售成功");
            } else {
                System.out.println("商品库存不足！！");
            }
        }
    }

    public static void main(String[] args) {
        Mall mall = new Mall();
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.mall = mall;
            Thread thread = new Thread(consumer);
            thread.start();
        }
        try {
            Thread.sleep(1000);
            System.out.println("当前商品库存为" + Stock.stock );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
