package math;


import java.util.Scanner;

/**
 * @description : 筛质数
 * @think : 核心思想 ： 任何一个合数 都有质数的倍数可以得到。可以通过这个筛掉合数 剩下质数
 * @author zm
 * @date 2023/04/05
 */
public class PrimeScreen {
    // 记录是否 被筛掉
    static  boolean[] st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        st = new boolean[n + 1];
        System.out.println(screen(n));
    }

    static int screen(int n) {
        if (n < 2) return 0;
        int ans = 0;
        for (int i = 2; i <= n; i ++) {
            if (!st[i]) {
                System.out.println("质数：  " + i);
                for (int j = i + i; j <= n ; j += i ) {
                    st[j] = true;
                }
                ans ++;
            }
        }
        return  ans;
    }
}
