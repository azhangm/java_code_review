package moni;

public class T4 {
    static int[] a = new int[]{99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11, 18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77 };
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0 ; i < a.length ; i ++) {
            for (int j = i + 1; j < a.length ; j ++) {
                if (a[i] * a[j] >= 2022) ans ++;
            }
        }
        System.out.println(ans);
    }
}
