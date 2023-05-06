package nuc.zm.JVM.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 内存泄漏
 * @description : 演示内存泄漏问题
 * @author zm
 * @date 2023/02/20
 */
public class MemoryLeak {

    private byte[] bigMemory = new byte[5 * 1024 * 1024]; // 5m

    Object reference = null;

    public static void main(String[] args) {
        MemoryLeak memoryLeak = new MemoryLeak();
        MemoryLeak memoryLeak1 = new MemoryLeak();
        memoryLeak.reference = memoryLeak1;
//        Variable is already assigned to this value 变量已经分配给这个值。
        memoryLeak1.reference = memoryLeak;

        System.gc();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
