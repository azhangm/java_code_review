
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }

        System.out.println(InversePairs(a));

    }


    public static int InversePairs(int[] array) {
        return mergesort(array);
    }

    public static int mergesort(int[] a) {
        if (a == null || a.length < 2) return 0;
        return mergesort(a, 0, a.length - 1);
    }

    private static int mergesort(int[] a, int l, int r) {
        if (l >= r) return 0;
        int mid = l + ((r - l) >> 1);
        return mergesort(a, l, mid)
                + mergesort(a, mid + 1, r)
                + merge(a, l, mid, r);
    }


    private static int merge(int[] a, int l, int mid, int r) {
        int ans = 0;
        int[] help = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                help[k++] = a[i++];
            } else {
                help[k++] = a[j++];
                ans += mid - i + 1;
            }
        }
        while (i <= mid) help[k++] = a[i++];
        while (j <= r) help[k++] = a[j++];

        for (i = 0; i < k; i++) {
            a[l + i] = help[i];
        }
        return ans;
    }

}

