package nuc.zm.JVM.runtimearea;

/**
 * @author zm
 * @description  不设置 -Xss:ThreadStackSize  -XX:ThreadStackSize=0
 * @description  验证大小是否默认为 1024k
 * @date 2023/02/12
 */
public class StackErrorTest {

    static int count  = 1;

    public static void main(String[] args) throws InterruptedException {

        try {
            count ++;
            main(args);
        }catch (Throwable e) {
            System.out.println("递归次数为"  + count);
        }
    }
}
