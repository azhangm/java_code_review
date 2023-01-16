import java.util.Objects;

public class LC_200 {

    public static void main(String[] args) {
        LC_200 lc_200 = new LC_200();
        System.out.println(lc_200.maxAreaOfIsland(new String[][]{
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}

        }));
    }
        int col;
        int[] help;
        public int maxAreaOfIsland(String[][] grid) {
            int ans = 0;
            int m = grid.length;
            col = grid[0].length;
            int len = m * col;
            int[] p = new int[len];
            help = new int[len];
            for (int i = 0 ; i < m ; i ++ ) {
                for (int j = 0; j < col; j++) {
                    if (Objects.equals(grid[i][j], "1")) {
                        int idx = getIdx(i, j);
                        p[idx] = idx;
                        ans ++;
                    }
                }
            }


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < col; j++) {
                    // 找他上下左右
                    if (Objects.equals(grid[i][j], "1")) {
                        int idx = getIdx(i, j);
                        // 合并上边
                        if (i > 0) {
                            if (Objects.equals(grid[i - 1][j], "1")) {
                                int idx1 = getIdx(i - 1, j);
                                int pidx = find(idx,p);
                                int pidx1 = find(idx1,p);
                                if (pidx != pidx1) {
                                    p[pidx1] = pidx;
                                    ans --;
                                }
                            }
                        }
                        if (j > 0) {
                            if (Objects.equals(grid[i][j - 1], "1")) {
                                int idx1 = getIdx(i , j - 1);
                                int pidx = find(idx,p);
                                int pidx1 = find(idx1,p);
                                if (pidx != pidx1) {
                                    p[pidx1] = pidx;
                                    ans --;
                                }
                            }
                        }
                    }
                }
            }
            return  ans;
        }


        int getIdx(int x , int y) {
            return x * col + y;
        }

        int find(int idx,int[] p) {
            int k = 0;
            while (idx != p[idx]) {
                idx = p[idx];
                help[k ++] = idx;
            }
            for (k -- ; k >= 0 ; k --) p[help[k]] = idx;
            return idx;
        }
}
