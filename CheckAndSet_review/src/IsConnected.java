/**
 * 连接
 *
 * @author zm
 * @date 2022/10/03
 */
public class IsConnected {
    public static void main(String[] args) {

    }
    class Solution {
        // 有多少个城市集合
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind unionFind = new UnionFind(n);
            // 对称的 只用遍历 右上角的矩阵即可

            for (int i = 0 ; i < n ; i ++) {
                for (int j = i ; j < n ; j ++) {
                    if (isConnected[i][j] == 1)
                        unionFind.uinion(i,j);
                }
            }
            return unionFind.sets;
        }


        public class UnionFind {
            // 每个节点的父亲是谁
            int[] parents;
            // 代表该集合的大小
            int[] size;
            // 路径压缩
            int[] help;
            // 初始城市集群
            int sets;

            public UnionFind(int n) {
                // 至多城市点的集合
                sets = n;
                parents = new int[n];
                size = new int[n];
                help = new int[n];
                // 该位置 的节点的父亲是他自己
                for (int i = 0 ; i < n ; i ++) {
                    parents[i] = i;
                    size[i] = 1;
                }
            }

            // 找节点的父亲
            public int findFather(int i ) {
                // 辅助数组 做路径压缩
                int h = 0;
                while (i != parents[i]) {
                    help[h++] = i;
                    i = parents[i];
                }
                for (h -- ; h >= 0; h -- ) {
                    parents[help[h]] = i;
                }
                return i;
            }

            public void uinion(int i , int j) {
                int iFather = findFather(i);
                int jFather = findFather(j);
                int iSize = size[iFather];
                int jSize = size[jFather];
                if (iSize >= jSize) {
                    size[iFather] += size[jSize];
                    parents[jFather] = iFather;
                }else {
                    size[jFather] += size[iFather];
                    parents[iFather] = jFather;
                }
            }
        }
    }

}
