package nuc.zm.MoreThread.method_test;

/**
 * 停止线程测试
 * 不建议使用
 * @author zm
 * @date 2022/10/16
 */
public class StopThreadTest {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if (i == 40) {
                Thread.currentThread().stop();
            }
        }

    }
}
