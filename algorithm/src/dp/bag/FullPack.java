package dp.bag;

import java.util.Scanner;

/**
 * 完整包
 *
 * @author zm
 * @date 2023/03/23
 */
public class FullPack {
    static int n ;
    static int m;
    static int[] v;
    static int[] w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = new int[n + 1];
        w = new int[n + 1];
        for (int i = 1; i <= n ; i ++ ) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for (int i =  1; i <= n ; i ++ ){
            for (int j = v[i]; j <= m; j ++) {
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
