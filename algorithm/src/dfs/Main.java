package dfs;
import java.util.*;
import java.io.*;

public class Main {

    static int[][] a;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int K;
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        K = sc.nextInt();
        set = new HashSet<>();
        a = new int[n][m];
        for (int i = 0 ; i < n ; i ++ )
            for (int j = 0; j < m ; j ++)
                a[i][j] = sc.nextInt();


        for (int i = 0 ;i < n; i ++)
            for (int j = 0; j < m; j ++ )
                dfs(i,j,1,a[i][j]);

        System.out.println(set.size());

    }

    static void dfs(int x , int y , int k , int val) {
        if (k > K) {
                set.add(val);
            return;
        }
        for (int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= a.length || ny < 0 || ny >= a[nx].length) continue;
            // 可以重复选 不标记 环
            dfs(nx,ny,k + 1, val * 10 + a[nx][ny]);
        }
    }
}