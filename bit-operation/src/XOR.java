import org.junit.Test;

import java.util.Scanner;

/**
 * xor
 * 异或 （无进位相加）
 * 知识含义 ：按每一个二进制位 相同为0 不同为 1
 * @author zm
 * @date 2022/10/11
 */
public class XOR {

    /**
     * 测试交换
        两个内存区域是分开的 例如在数组中 i == j 下标 会把自己刷成  0

     */
    @Test
    public void testSwap() {
        int a = 1;
        int b = 2;
         a = a ^ b;
         b = a ^ b;  // a ^ b ^ b (b ^ b) == 0 a ^ 0 = a  b = a;
         a = a ^ b; // a = a ^ b ^ a  = a ^ a ^ b;  a ^ a = 0 ; b ^ 0 = b;
        System.out.println( a);
        System.out.println(b);

//        ========================================
//        i != j 适用
        int[] arr = {1,3};
        int i = 0;
        int j = 1;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(arr[i] + " , " + arr[j]);

    }

    /**
     * 是奇数
     */
    public static void isOddNumber(){
        int eor = 0;
        int[] a = new int[11];
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i < 11; i ++ ) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 11; i++) {
            eor ^= a[i];
        }
        System.out.println(eor);
    }


    /**
     * 得到最后一个1
     */
    public static int getLastOne( ) {
        int a = new Scanner(System.in).nextInt();
        return a & (-a);
    }

    public static void getBit(int a ) {
        for (int i = 0; i < 32; i ++) {
            System.out.print( (a >> i) & 1);
        }
        System.out.println();
    }

    public static void getBit2(int a ) {
        StringBuilder sb = new StringBuilder();
        while (a  != 0) {
            a /= 2;
        sb.append(a % 2);
        }
        System.out.println(sb.reverse());
    }
    /**
     * 位图
     */
    public static int onlyKTimes(int[] arr, int k, int m) {

        int[] t = new int[32];
        // t[0] 0位置的1出现了几个
        // t[i] i位置的1出现了几个
        for (int num : arr) {
            while (num != 0) {
                int rightOne = num & (-num);
                num ^= rightOne;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                if (t[i] % m == k) {
                    ans |= (1 << i);
                } else {
                    return -1;
                }
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        isOddNumber();
        int lastOne = getLastOne();
        getBit(19);
        System.out.println("=======================");
        getBit2(19);

    }
}
