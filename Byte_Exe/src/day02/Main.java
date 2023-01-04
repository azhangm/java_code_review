package day02;

import java.io.BufferedInputStream;
import java.util.Scanner;

/*
*
1 0 0 1 0 0 0
1 0 0 0 0 1 1
0 0 0 1 0 0 0
1 1 0 1 1 0 0
* */

public class Main {
    static int[][] map = new int[][]{{1, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0, 0}};
    // 向量
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) {
        int ans = 0;

        for (int i = 0; i < map.length ; i ++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    ans = Math.max(dfs(i, j), ans);
                }
            }
        }
        System.out.println(ans);



    }

    private static int dfs(int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[i].length ) return 0;
        if (map[i][j] == 1) return 0;
        int ans = 1;
        map[i][j] = 1;
        for (int k = 0 ; k < 4 ; k ++) {
            int nextX = i + dx[k];
            int neXtY = j + dy[k];
            ans += dfs(nextX,neXtY);
        }
        return ans;
    }

}
