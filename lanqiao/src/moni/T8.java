package moni;

import java.util.Arrays;
import java.util.Scanner;
public class T8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];

        int t = sc.nextInt();
        while (t -- > 0) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            for (int i = r1 ; i <= r2 ; i ++) {
                for (int j = c1; j <=c2 ; j++) {
                    a[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= m ; j ++) {
                if (a[i][j] == 0) ans ++;
            }
        }

        System.out.println(ans);
    }
}