package dfs;

/**
 * 猫爬山问题
 *
 * @author zm
 * @date 2023/04/01
 */
import java.util.*;
import java.io.*;

public class CatClimb {
    static int [] c;
    static int[] d;
    static int n;
    static int max;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        max = sc.nextInt();
        c = new int[n];
        d = new int[n];
        for (int i = 0; i < n ; i ++) c[i] = sc.nextInt();
        dfs(0,1);
        System.out.println(ans);
    }

    static void dfs(int u , int k) {
        if (k >= n) return;
        if (u == n) {
            ans = Math.min(k,ans);
            return;
        }
        for (int i = 0; i < k ; i ++) {
            if (d[i] + c[u] >= max) continue;
            d[i] += c[u];
            dfs(u + 1, k);
            d[i] -= c[u];
        }
        d[k] = c[u];
        dfs(u + 1, k + 1);
        d[k] = 0;
    }

}