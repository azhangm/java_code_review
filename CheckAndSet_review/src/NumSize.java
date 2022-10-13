import java.util.Scanner;

public class NumSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] a = new int[10];
        for (int i = 0; i < 3 ; i ++) {
            a[n ++] = i;
        }
        System.out.println(n);
    }
}
