package math;

import java.util.Scanner;

/**
 * 判断素数
 * @description ：试除法判定素数
 * @think : 任何一个数 分解为两个数的乘积  两个数 必然一个 大于 sqrt(x) 一个小于 sqrt(x)  枚举到 x/i 就可以美剧玩所有的因数了
 * @author zm
 * @date 2023/04/05
 */
public class JudgePrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while ( n -- > 0) {
            int x = sc.nextInt();
            if (check(x)) System.out.println(x + "是质数");
            else System.out.println(x + "不是质数");
        }
    }

    private static boolean check(int x) {
        // 质数的取值范围是相对于 [2,n] 来说的
        if (x < 2) return  false;
        for (int i = 2; i <= x / i ; i ++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
