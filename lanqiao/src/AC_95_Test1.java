import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class AC_95_Test1 {
    static int[][] arr;
    static int n;
//    向量数组 自己 : 0,0 上 0 , -1 , 左 -1 , 0 下 : 0 , 1 右 : 1,0
    static int[] dx = {-1, 0, 1, 0,0};
    static int[] dy = {0, 1, 0, -1,0};
    static boolean[] sel = new boolean[5];
    static int[][] backup;
    static int conut = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        arr = new int[6][6];
        backup = new int[6][6];
        while (n-- > 0) {
//            初始化 灯盘
            for (int i = 0; i < 5; i++) {
                String[] s = sc.next().split("");
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

//            dfs 参数的设置  : 枚举第一行的 所有情况 2^5
//            前面 对 状态的分析是 最后一行的状态 就不能确定 了 因为 有 所有 灯只能按一次的情况
            int[] ans = {7};
            dfs(0, ans);

            ans[0] = ans[0] > 6 ? -1 : ans[0];
            System.out.println(ans[0]);
        }
    }

    /**
     * 递归 枚举  第一行的情况数
     *
     * @param u   u
     * @param ans 答
     */
    private static void dfs(int u,int[] ans) {
        // 走到第一行的末尾的话 我们 由第一行的状态 推断出其他行的状态
        if (u >= 5) {
            conut++;
            copy(arr, backup);
            int stp = 0;
//            第一行各种按法的 按动
            for (int i = 0; i < 5; i++) {
                if (sel[i]) {
                    stp ++;
                    turn(0, i);
                }
            }

//          按其他行 其他行 由第一行来 确定
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] == 0) {
                        stp ++ ;
                        turn(i + 1, j);
                    }
                }
            }
            boolean dark = false;
            for (int i = 0; i < 5; i++) {
                if (arr[4][i] == 0) {
                    dark = true;
                    break;
                }
            }

            copy(backup,arr);

            if (!dark) ans[0] = Math.min(stp, ans[0]);
            return;
        }
        // 不按的情况
        dfs(u  + 1,ans);

        // 按的情况
        sel[u] = true;
        dfs( u + 1, ans);
        sel[u] = false;
    }

    private static void copy(int[][] src, int[][] aim) {
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, aim[i], 0, src[i].length);
        }
    }


//    0 黑 1亮

    //    翻转 x y 坐标的十字架位置
    private static void turn(int x, int y) {
        int curx;
        int cury;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                curx = x + dx[i];
                cury = y + dy[i];
                if (curx < 0 || curx >= 5 || cury < 0 || cury >= 5) continue;
                arr[curx][cury] ^= 1;
            }
        }
    }

}
