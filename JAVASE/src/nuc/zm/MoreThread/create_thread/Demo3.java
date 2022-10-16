package nuc.zm.MoreThread.create_thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * demo3
 * 实现 callable 接口
 * @author zm
 * @date 2022/10/16
 */
public class Demo3 implements Callable<Double> {
    /**
     * 调用
     * 抛 子类 异常
     * @return {@link Double}
     * @throws Exception 异常
     */
    @Override
    public Double call() throws Exception {
        return (double) new Random().nextInt(10);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo3 demo3 = new Demo3();
        FutureTask<Double> futureTask = new FutureTask<>(demo3);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}
