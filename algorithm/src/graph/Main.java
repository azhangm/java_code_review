package graph;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visit ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 1 ; i <= n ; i ++)
            for (int j = 1 ; j <= m ; j ++)
                map[i][j] = sc.nextInt();

        System.out.println(bfs(1,1));
    }

    // bfs 模板应用
    static int bfs(int curx , int cury) {
        Deque<int[]> que = new LinkedList<>();
        // 0 表示最小步数
        que.add(new int[]{curx,cury,0});
//        int step = 0;
        while (!que.isEmpty()) {
            int[] info = que.removeFirst();
            int x = info[0];
            int y = info[1];
             int step = info[2];
            // 方向数组
            for (int i = 0 ; i < 4 ; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 访问数组好习惯 判断合法性
                if (nx < 1 || nx >= map.length || ny < 1 || ny >= map[nx].length || map[nx][ny] == 1 || visit[nx][ny] )
                    continue;
                que.add(new int[]{nx,ny,step + 1});
                if (nx == map.length - 1 && ny == map[nx].length - 1)
                        return  step + 1;
                visit[nx][ny] = true;
            }

        }
        return -1;
    }
}