import java.util.*;
import java.io.*;
public class AC_1249_Union {
        static int n;
        static int[] parent;
        static int[] size;
        public static void main(String[] args) throws IOException {
            BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter wt = new PrintWriter(new OutputStreamWriter(System.out));
            String[] str = re.readLine().split(" ");
             n = Integer.parseInt(str[0]);
            parent = new int[n + 1];
            size = new int[n + 1];
            int m = Integer.parseInt(str[1]);

            System.out.println(m  + " " + n);
            for (int i = 0 ; i <= n ; i ++)  {parent[i] = i; size[i] = 1;}
            while (m -- > 0) {
                String[] s = re.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                union(a,b);
            }
            int q = Integer.parseInt(re.readLine());
            while (q -- > 0) {
                String[] s = re.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                if (isRelative(a,b)) {
                    wt.println("Yes");
                }else {
                    wt.println("No");
                }
            }
            wt.flush();
        }


        public static boolean isRelative(int a, int b) {
            return find(a) == find(b);
        }

        public static void union(int a , int b) {
            int af = find(a);
            int bf = find(b);
            if (af == bf) return;
            int as = size[af];
            int bs = size[bf];
            // 小挂大
            if (as >= bs) {parent[bf] = af; size[af] += bs;}
            else {
                parent[af] = bf;
                size[bf] += as;
            }
        }

        public static int find(int x) {
            int[] help = new int[100];
            int k = 0;
            while (x != parent[x]) {
                x = parent[x];
                help[k ++] = x;
            }
            for (k--; k >= 0;k--)
                parent[help[k]] = x;
            return x;
        }
}
