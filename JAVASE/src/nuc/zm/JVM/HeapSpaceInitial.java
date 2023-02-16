package nuc.zm.JVM;

/**
 * 堆空间初始
 *
 * @author zm
 * @date 2023/02/16
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
//        返回 Java虚拟机堆的内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;

//        Java 虚拟机试图使用的最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024 ;

        System.out.println("-Xms " + initialMemory + "M");
        System.out.println("-Xmx " + maxMemory + "M");

        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
