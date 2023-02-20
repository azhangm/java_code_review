package nuc.zm.JVM.heap;

/**
 * 年轻旧区测试
 * @description  : -Xms600m -Xmx600m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 设置堆空间大小  60M Eden区 20M Old 区 40M 幸存者区 4M  大对象直接放入 old 区域
 * @author zm
 * @date 2023/02/16
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20]; // 20M
    }
}
