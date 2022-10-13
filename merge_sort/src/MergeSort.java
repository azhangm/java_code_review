import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zm
 * @date 2022/10/11
 */
public class MergeSort {



    public void mergeSort(int [] a) {
        if (null == a || a.length < 2) return;
        sort(a,0,a.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid =l + ((r - l) >> 1);
        sort(a,l,mid);
        sort(a,mid + 1 ,r);
        merge(a,l,mid,r);
    }

    private void merge(int[] a, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            help[k ++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) help[k++] = a[i++];
        while (j <= r) help[k ++]  = a[j++];

        for (i = 0 ; i < k ; i ++) {
            a[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 16, 71, 88, 72, 38, 94, 50, 67, 72};
        new MergeSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

}
