package nuc.zm.JVM;

import java.util.ArrayList;
import java.util.Random;

/**
 *  oomtest
 * @description  ： 堆空间 oom 异常的演示
 * @author zm
 * @date 2023/02/16
 */
public class OOMTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Ob> objects = new ArrayList<>();
        while (true) {
            Thread.sleep(200);
            objects.add(new Ob(1024*1024));
        }
    }

    static class Ob {
        int[] a;

        public Ob(int len) {
            a = new int[len];
        }
    }
}
