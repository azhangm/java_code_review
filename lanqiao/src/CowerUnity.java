import java.util.*;
import java.io.*;

/**
 * 畏缩团结
 *
 * @author zm
 * @date 2022/12/30
 */
public class CowerUnity {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        long max = 0;
        long cost_one = 0;
        Arrays.sort(arr);
        for (int i = 0 ; i < n ; i++) {
            long cost = (long) arr[i] * (n - i);
            if (cost > max) {
                max = cost;
                cost_one = arr[i];
            }
        }
        System.out.println(max +  " "+ cost_one);
    }
}