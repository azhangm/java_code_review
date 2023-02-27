package moni;

import java.util.Arrays;
import java.util.Scanner;

public class T5 {
    static int[][] a = new int[30][60];

//    上下左右 方向数组
    static  int[] dx = {0,-1,0,1};
    static  int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i < 30 ; i ++) {
            String[] s = sc.next().split("");
            for (int j = 0 ; j < 60; j ++ ) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        int ans = 0;
       for (int i = 0 ; i < 30 ; i ++) {
           for (int j = 0 ; j < 60 ; j ++) {
               if (a[i][j] == 1) {
                   ans = Math.max(ans,dfs(i,j));
               }
           }
       }
        System.out.println(ans);
    }

    private  static int dfs(int x , int y) {
        if (a[x][y] == 0) return 0;
        a[x][y] = 0;
        int ans = 1;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < a.length && ny >= 0 && ny < a[nx].length ) {
                ans += dfs(nx,ny);
            }
        }
        return  ans;
    }
}
