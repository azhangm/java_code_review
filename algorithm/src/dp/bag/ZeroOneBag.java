package dp.bag;

/**
 * 01背包问题
 *
 * @author zm
 * @date 2023/03/23
 */
import java.util.*;
import java.io.*;

public class ZeroOneBag {

    static int[] v;
    static int[] w;
    static int[][] f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        v = new int[n + 1];
        w = new int[n + 1];
        f = new int[n + 1][m + 1];

        for (int i = 1 ; i <= n ; i ++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 0 ; j <= m ; j ++)
                if (j >= v[i])
                    f[i][j] = Math.max(f[i - 1] [j - v[i]] + w[i] , f[i - 1][j]);
                else  f[i][j] = f[i - 1][j];
        }

        System.out.println(f[n][m]);
    }
}