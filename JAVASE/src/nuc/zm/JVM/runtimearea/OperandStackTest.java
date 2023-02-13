package nuc.zm.JVM.runtimearea;

/**
 * 操作数堆栈测试
 *
 * @author zm
 * @date 2023/02/13
 */
public class OperandStackTest {

    /**
     * 测试添加操作
     */
    void testAddOperation() {
//        byte char short boolean 都以int来保存
//        局部变量表深度 7
        // this 1
        byte i = 1;  // 1 1 bipush
        short a = 2; // 1 1 bipush
        int k = a + i; // 1 iadd 从栈里面取 不计入 最大深度 2

        long m = 12L; // 2  2 ldc  lsore 消
        int n = 800; // 1   1  最大深度 2
        m = n * m; // 1 i2l 1 -> 2 (宽化处理) iload m  占4
    }

    int getSum() {
        int a = 1; // 1
        int b = 2; // 2
        int k = a + b;
        return k;
    }

    void test () {
        int sum = getSum();
        int j = 10;
    }
}
