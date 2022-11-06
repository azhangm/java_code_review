package nuc.zm.MoreThread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 *
 * @author zm
 * @date 2022/11/06
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        固定线程总数，空闲线程用于执行任务，如果线程都在使用 后续处于等待状态
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {

            int finalI = i;
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " : " + finalI));
        }
            executorService.shutdown();
    }
}
