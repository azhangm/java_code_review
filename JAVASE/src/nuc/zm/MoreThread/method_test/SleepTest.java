package nuc.zm.MoreThread.method_test;

/**
 * 睡眠测试
 *
 * @author zm
 * @date 2022/10/16
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("3秒之后输出我");
    }
}
