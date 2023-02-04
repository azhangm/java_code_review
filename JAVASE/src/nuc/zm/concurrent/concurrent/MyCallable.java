package nuc.zm.concurrent.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 我可调用
 *
 * @author zm
 * @date 2023/02/04
 */
public class MyCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);
        System.out.println("main 线程运行结束");
    }

    static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "ZHANG MENG ";
        }
    }
}
