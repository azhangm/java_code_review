package dfs;
import java.util.*;
import java.io.*;

public class NumberPermutation {
    static int n;
    static boolean[] use;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        use = new boolean[ n + 1];
        dfs(1,new ArrayList<>());
    }

    static void dfs(int i , List<Integer> list) {
        if (i > n) {
            for (Integer integer : list) System.out.print(integer + " ");
            System.out.println();
        }
        // 当层选数
        for (int j = 1 ; j <= n ; j ++) {
            if (use[j]) continue;
            use[j] = true;
            list.add(j);
            dfs(i + 1,list);
            use[j] = false;
            list.remove(list.size() - 1);
        }
    }
}