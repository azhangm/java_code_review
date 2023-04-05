package math;

import java.util.Scanner;

/**
 * @description : 分解质因数
 * @think : 为什么 i 一定是 质数，不可能 是合数吗？ 不可能 合数 可以表示为 质数的倍数 在 枚举到合数时 ，确保 他一定不能对合数取余得到结果0
 * @author zm
 * @date 2023/04/05
 */
public class DecPrimNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n -- > 0) {
            int x = sc.nextInt();
            divide(x);
        }
    }

    private static void divide(int x) {
        for (int i = 2; i <= x / i; i ++) {

            if (x % i == 0) {
                int cnt = 0;
                while ( x % i == 0) {
                    x /= i;
                    cnt ++;
                }
                System.out.println(i + " " + cnt);
            }
        }
        if (x > 1) System.out.println(x + " " + 1);
    }
}
