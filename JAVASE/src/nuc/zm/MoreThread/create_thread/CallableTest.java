package nuc.zm.MoreThread.create_thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 可调用测试
 *
 * @author zm
 * @date 2022/11/06
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }

    static class ThreadTest implements Callable<Integer> {
        private String name;
        @Override
        public Integer call() throws Exception {
            Integer speed = new Random().nextInt(10);
            Integer result = 0;
            for (int i = 1; i < 10; i++) {
                Thread.sleep(1000);
                result = i * speed;
                System.out.println("第 " + i + " 秒 " + this.name + " 已经跑到  "  + result + " 米 " + " 速度 " + speed + " 米/秒 ");
            }
            return result;
        }
        public void start() throws ExecutionException, InterruptedException {
//        线程池
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            ThreadTest threadTest = new ThreadTest();
            threadTest.name = "参赛者A";
            ThreadTest threadTest1 = new ThreadTest();
            threadTest1.name = "参赛者B";
            ThreadTest threadTest2 = new ThreadTest();
            threadTest2.name = "参赛者C";
            Future<Integer> submit = executorService.submit(threadTest);
            Future<Integer> submit1 = executorService.submit(threadTest1);
            Future<Integer> submit2 = executorService.submit(threadTest2);
            executorService.shutdown();
            System.out.println(threadTest.name + "跑了" + submit.get() + "米");
            System.out.println(threadTest1.name + "跑了" + submit1.get() + "米");
            System.out.println(threadTest2.name + "跑了" + submit2.get() + "米");

        }
    }


}
