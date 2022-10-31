package recursive;

/**
 * ac满每
 *
 * @author zm
 * @date 2022/10/31
 */
import java.util.*;
public class Ac_Full_Per {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 1 ; i <= n ; i ++) {
            s.append(i);
        }
        char[] str = s.toString().toCharArray();


        dfs(str,0);
    }

    private static void dfs(char[] str, int idx) {
        if (idx >= str.length) {
            for (char c : str) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        for (int i = idx ; i < str.length; i ++) {
            swap(str,i,idx);
            dfs(str,idx + 1);
            swap(str,idx,i);
        }
    }

    private static void swap(char[] a, int i , int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}