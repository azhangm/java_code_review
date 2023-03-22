package monotonicqueue;

import java.util.*;
import java.io.*;

public class Main {

    // 单调队列维护 长度为 [1 --> m] 的区间最大值. for (int )

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[ n + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1 ; i <= n ; i ++) {
            int x = sc.nextInt();
            a[i] = a[i - 1] + x;
            ans = Math.max(ans,x);
        }

        Deque<Integer> que = new LinkedList<>();

        for (int k = 2 ; k <= m ; k ++ ) {
            for (int i = 0 ; i <= n ; i ++) {
                while (!que.isEmpty() && a[que.peekLast()] <= a[i]) que.removeLast();
                que.addLast(i);
                while (!que.isEmpty() && que.peekFirst() <= i - k + 1 ) que.removeFirst();
//                System.out.println(que);
//                if (que.isEmpty())
                if (i >= k) {
                    if (que.peekFirst() - k >= 0)
                    ans = Math.max(ans,a[que.peekFirst()] - a[que.peekFirst() - k ]);
                }

            }
        }
        System.out.println(ans);
    }
}