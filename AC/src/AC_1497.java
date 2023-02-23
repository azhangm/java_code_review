import java.util.*;
import java.io.*;
public class AC_1497 {
        static int n;
        static int[] pood;
        static int[] inod;
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            public TreeNode(int val) {this.val = val;}
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            n = sc.nextInt();
            pood = new int[n];
            inod = new int[n];
            // 二叉树后序遍历特点  左 右 根
            // 中序遍历的特点      左 根 右
            //   1
            // 2   3  最小子集 后序遍历  2 3 1 中序遍历 2 1 3
            // 递归构造一层的逻辑即可
            // 后序遍历 最后一个节点是根节点
            for (int i = 0 ; i < n ; i ++) inod[i] = sc.nextInt();
            for (int i = 0 ; i < n ; i ++) pood[i] = sc.nextInt();

            TreeNode root = dfs(0,n - 1,0,n - 1);
            bfs(root);
        }
        // dfs 参数规定 要知道根 --> 后序遍历决定
        static TreeNode dfs(int l1 , int r1 , int l2 , int r2)  {
            if (l2 > r2) return null;
            // 书写当前层逻辑
            TreeNode root = new TreeNode(pood[r1]);
            int mid = l2;
            // 找到根 在 中序遍历的位置
            while (inod[mid] != pood[r1]) mid ++;
            // 左子树大小抽象
            int leftSize = mid - l2;

            root.left =  dfs(l1 , l1 + leftSize - 1,l2,mid - 1);

            root.right = dfs(l1 + leftSize ,r1 - 1,mid + 1,r2);
            return root;
        }

        // 进行层序遍历
        static void bfs(TreeNode root) {
            Deque<TreeNode> que = new LinkedList<>();
            // 层序遍历 一般用队列 队列特点 尾进头出
            que.addLast(root);
            System.out.println("root.val " + root.val);
            while (!que.isEmpty()) {
                TreeNode cur = que.pollFirst();
                System.out.print(cur.val + " ");
                if (cur.left != null) que.addLast(cur.left);
                if (cur.right != null) que.addLast(cur.right);
            }
        }
    }

