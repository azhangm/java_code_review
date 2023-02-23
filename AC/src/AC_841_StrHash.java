import java.io.*;
import java.util.*;

public class AC_841_StrHash {
    static int n;
    static final int P = 131;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        int[] p = new int[n + 10];
        int[] hash = new int[ n + 10];
        p[0] = 1;
        // 处理 进制关系。每段的hash 值
        for (int i = 1 ;i <= n ; i ++) {
            // 前缀和 思想
            // 构造 进制 记录每个 i 的p次方  1 位 0 2 位1 ····
            p[i] = p[i - 1] * P;
            hash[i] = hash[i - 1] * P + s.charAt(i - 1);
        }

        while (m -- > 0) {
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            // System.out.println( hash[r1] - hash[l1 - 1] * p[r1 - l1 + 1]);

            // System.out.println( hash[r2] - hash[l2 - 1] * p[r2 - l2 + 1]);

            String out  = hash[r1] - hash[l1 - 1] * p[r1 - l1 + 1] == hash[r2] - hash[l2 - 1] * p[r2 - l2 + 1] ? "Yes" : "No";
            System.out.println(out);
        }
    }
}
