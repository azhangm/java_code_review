import java.util.Arrays;

public class AC_32 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void reOrderArray(int[] array) {
        // 奇数和偶数判断 bit 形式 偶数最后一个为 0 奇数最后一个为 1
        // & 运算 0 & 1 = 0 ； 1 & 1 = 1;
        int n = array.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            // 偶数
            while  ((array[l] & 1) != 0) l ++;
            //奇数
            while ((array[r] & 1) != 1) r --;
            if (l < r) {
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            }
        }
    }
}
