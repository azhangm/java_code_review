package week_85;

import java.util.*;
import java.io.*;

public class AC_4509 {
    static int[] a;
    static double av;
    static double variance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        a = new int[n + 1];


        for (int i = 1; i <= n ; i ++) {
            a[i] = sc.nextInt();
        }
        getAv(n + 1);
        variance = Math.sqrt(getVariance(n));
        for (int i = 1; i <= n; i ++) {
            operation(a[i]);
        }
    }

    static void operation(int num) {
        System.out.println((num - av) / variance);
    }

    static void getAv( int n) {
        double sum = 0L;
        for (int i = 1 ; i < n ; i ++) {
            sum += a[i];
        }
        av = sum / (n - 1);
    }

    static double getVariance(int n) {
        double ans = 0L;
        for (int i = 1; i <= n ; i ++ ) {
            ans += Math.pow(a[i] - av,2);
        }
        System.out.println(ans);
        return ans / n;

    }




}