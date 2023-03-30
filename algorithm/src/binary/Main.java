package binary;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        int q = sc.nextInt();
        a = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            a[i] = sc.nextInt();
        }
        while (q -- > 0) {
            int x = sc.nextInt();
            int l = left_bounds(x);
            if (l == -1) {
                System.out.println(-1 + " " + -1);
                continue;
            }
            int r = right_bounds(x);
            System.out.println(l + " " + r);
        }

    }

    static int left_bounds(int x) {
        int l = 0 , r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return a[l] == x ? l : -1;
    }

    static int right_bounds(int x) {
        int l = 0 , r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] <= x) l = mid;
            else r = mid - 1;
        }
        return a[r] == x ? r : -1;
    }
}