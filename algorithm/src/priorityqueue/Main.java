package priorityqueue;

import java.util.*;
import java.io.*;

public class Main {
    static int[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        v = new int[n + 1];
        PriorityQueue<int[]>[] que = new PriorityQueue[n + 1];
        for (int i = 1 ; i <= n ; i ++) {v[i] = sc.nextInt(); que[i] = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));}
        while (m -- > 0) {
            int a = sc.nextInt();  // a 时刻分配
            int b = sc.nextInt(); // b 第 i 号计算机
            int c = sc.nextInt(); // 持续时间
            int d = sc.nextInt(); // 消耗算力
            // 结束时间 小于 开始 时间 说明他过期了
            while (!que[b].isEmpty()&& que[b].peek()[0] <= a) {
                // 该计算机的算力 要得到恢复
                v[b] += que[b].peek()[1];
                // 移除过期时间
                que[b].poll();
            }

            if (d > v[b]) {
                System.out.println(-1);
                continue;
            }
            int end = a + c; // 任务结束时间 、 剩余算力、作为 计算机的任务属性。
            // 开始时间高于结束时间 则 过期
            // 在合法时间内 消耗算力
            v[b] -= d;
            que[b].add(new int[]{end,d});
            System.out.println(v[b]);
        }
    }
}