package dfs;
import java.util.*;
import java.io.*;
public class BoardGame {
        static int[][] map;
        static boolean[][] st;
        static int[] dx = {0,-1,0,1};
        static int[] dy = {1,0,-1,0};
        static int res = Integer.MAX_VALUE;
        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            map = new int[6][6];
            st = new boolean[6][6];
            for (int i = 0 ; i < 6 ; i ++) {
                for (int j = 0 ; j < 6 ; j ++)
                    map[i][j] = sc.nextInt();
            }
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            dfs(sx,sy,ex,ey,0 , 1);
            System.out.println(res);
        }

        static void dfs(int sx , int sy , int ex , int ey , int dist , int cost) {
            if (sx == ex && sy == ey) {res = Math.min(res,dist); return;}
            st[sx][sy] = true;
            for (int i = 0 ; i < 4 ; i ++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6) continue;
                if (st[nx][ny]) continue;
                st[nx][ny] = true;
                dfs(nx,ny,ex,ey,dist + (cost * map[nx][ny]) % 4 + 1, cost * map[nx][ny]);
                st[nx][ny] = false;
            }
        }

    }
