package segment_tree;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = read.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        s = read.readLine().split(" ");
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s[i]);
        SegmentTree tree = new SegmentTree(nums);
        while (m -- > 0) {
            s = read.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);
            if (k == 0) wt.println(tree.query(l,r));
            else tree.update(l,r);

        }
        wt.flush();
        wt.close();
        read.close();
    }

    static class SegmentTree {
        static   class Node {
            // 节点表示 [l,r] 的连续和
            int l;
            int r;
            int sum;
        }
        int n;
        // 取 4n 用完全二叉树的类型存储 中
        Node[] a;
        public SegmentTree(int[] nums) {
            n = nums.length;
            a = new Node[4 * n];
            build(1,0,n - 1,nums);
        }

        // buildTree
        void build(int cur , int l , int r , int[] nums) {
            if (nums.length == 0) return;
            a[cur] = new Node();
            a[cur].l = l;
            a[cur].r = r;
            if (l == r){ a[cur].sum = nums[l]; return;}
            int mid = l + r >> 1;

            build(cur * 2 , l , mid,nums);
            build(cur * 2 + 1, mid + 1 , r , nums);
            // 回溯统计信息
            a[cur].sum = a[cur * 2].sum + a[cur * 2 + 1].sum;
        }

        void update(int idx , int val) {
            update(1,idx - 1,val);
        }

        // 更新一个点 影响与之关联的全部点
        void update(int cur , int idx , int val) {
            if (a[cur].l == a[cur].r) {
                a[cur].sum += val;
                return;
            }
            int mid = a[cur].l + a[cur].r >> 1;
            // 树枝走向  去左边还是去右边 [l,mid] 左边 [mid + 1, r] 右边
            if (idx <= mid)  update(cur * 2 , idx , val);
            else update(cur * 2 + 1, idx , val);
            a[cur].sum = a[cur * 2].sum + a[cur * 2 + 1].sum;
        }

        // 查询区间
        int query(int l , int r) {
            return query(1,l - 1,r - 1);
        }

        int query(int cur , int l , int r) {
            // 递归边界 同时也是作为一个候选答案 完全包含 作为答案
            if (l <=  a[cur].l && r >= a[cur].r ) return a[cur].sum;
            int mid = a[cur].l + a[cur].r >> 1;
            int ans = 0;
            if (l <= mid) ans += query(cur * 2,l,r);
            if (r > mid) ans += query(cur * 2 + 1,l, r);
            return ans;
        }
    }
}
