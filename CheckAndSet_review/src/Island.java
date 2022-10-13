public class Island {
        public int maxAreaOfIsland(int[][] grid) {
            UnionFind union =  new UnionFind(grid);
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 1; i < n ; i ++) {
                if (grid[0][i-1] == 1 && grid[0][i] == 1 )
                    union.union(0,i-1,0,i);
            }
            for (int i = 1; i < m ; i ++) {
                if (grid[i -1 ][0] == 1 && grid[i][0] == 1 )
                    union.union(i - 1,0,i,0);
            }
            for (int i = 1 ; i < m ; i ++) {
                for (int j = 1; j < n ; j ++) {
                    if (grid[i][j] == 1) {
                        if (grid[i - 1][j] == 1) {
                            union.union(i,j,i-1,j);
                        }
                        if (grid[i][j - 1] == 1) {
                            union.union(i,j,i,j-1);
                        }
                    }
                }
            }

            return union.getMax();
        }

        class UnionFind {
            // 并查集设计 找到自己的父亲 辅助数组1
            int[] parent;
            // 路径压缩用
            int[] help;
            // 代表节点屁股后面有多少个节点
            int[] parentSize;

            int n ;

            public UnionFind(int[][] grid) {
                int m = grid.length;
                n =  grid[0].length;
                parent = new int[m * n];
                help = new int[m*n];
                parentSize = new int[m*n];
                for (int r = 0; r < m; r ++) {
                    for (int c = 0 ; c < n ; c ++)
                        if (grid[r][c] == 1){
                            int idx = index(r,c);
                            parent[idx] = idx;
                            parentSize[idx] = 1;
                        }
                }
            }

            // 合并集合
            public void union(int r1 , int c1 , int r2, int c2) {
                int idx1 = index(r1,c1);
                int idx2 = index(r2,c2);
                int f1 = findFather(idx1);
                int f2 = findFather(idx2);
                if (f1 != f2) {
                    if (parentSize[f1] >= parentSize[f2]) {
                        parentSize[f1] += parentSize[f2];
                        parent[f2] = f1;
                    }else {
                        parentSize[f2] += parentSize[f1];
                        parent[f1] = f2;
                    }
                }
            }

            // 通过坐标找父亲
            private int findFather(int idx) {
                int k = 0;
                while (idx != parent[idx]) {
                    help[k ++] = parent[idx];
                    idx = parent[idx];
                }
                // 路径压缩优化并查集
                for (int i = 0 ; i < k ; k ++) {
                    parent[help[i]] = idx;
                }
                System.out.println(k);
                return idx;
            }

            public int getMax() {
                int max = parentSize[0];
                for (int i = 1 ; i < parentSize.length; i ++ ) {
                    max = Math.max(max, parentSize[i]);
                }
                return max;
            }

            // 得到坐标
            private int index(int r , int c) {
                return r * n + c;
            }
        }


    public static void main(String[] args) {
        Island island = new Island();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
                        };

        int[][] gird1 = {{0,0,0,0,0,0,0,0}};
        long l = System.currentTimeMillis();

        System.out.println(island.maxAreaOfIsland(grid));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
