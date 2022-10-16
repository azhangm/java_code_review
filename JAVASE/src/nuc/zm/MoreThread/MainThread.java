package nuc.zm.MoreThread;


import java.util.Map;

/**
* 测试 启动main 方法有多少个线程运行
*   异常线程会影响主线程的执行
* */
public class MainThread {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int count = 0;
        for (Thread thread : allStackTraces.keySet()) {
            System.out.println(thread.getName());
            count ++;
        }
        System.out.println("一共有 " + count +  " 个线程");
    }
}
