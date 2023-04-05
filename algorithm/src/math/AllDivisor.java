package math;

import java.util.Scanner;

/**
 * 所有因子
 * @description : 试除法求约数
 * @think : 若 d >= sqrt(n) 是 n 的约数 ， 那么 n/d <= sqrt(n) 也是 n的约数
 * @author zm
 * @date 2023/04/05
 */
public class AllDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n -- > 0) {
            int x = sc.nextInt();
            get(x);
            System.out.println();
        }
        // 6
        // 1 6 2 3
        //1 8 2 4
    }

    private static void get(int x) {
        for (int i = 1; i <= x / i ; i ++) {
            if (x % i == 0) {
                System.out.print(i + " ");
                if (i != x / i) System.out.print(x/i + " ");
            }
        }
    }
}
