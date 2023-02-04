import java.util.*;
import java.io.*;

public class AC_859 {
        static int[] f ;
        static int[] size;
        static int[] help;
        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            int m = sc.nextInt();
            f = new int[n + 1];
            size = new int[n + 1];
            help = new int[n];
            Graph g = new Graph();

            // 初始化图结构
            for (int i = 0 ; i < m ; i ++ ) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                if (!g.nodes.containsKey(x)) g.nodes.put(x,new Node(x));
                if (!g.nodes.containsKey(y)) g.nodes.put(y,new Node(y));
                Node from = g.nodes.get(x);
                Node to = g.nodes.get(y);
                g.edges.add(new Edge(from,to,w));
            }
            // 初始化并查集
            for (int i = 1; i <= n ; i ++) {
                f[i] = i;
                size[i] = 1;
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
            for (Edge e : g.edges) {
                pq.add(e);
            }

            // 依次枚举 权值最小的边 并查集验证是否有环 有环不连接 无环则连接
            int ans = 0;
            while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                // 拿到这个边的 两个点值
                Node from = cur.from;
                Node to = cur.to;
                int fx = find(from.x);
                int fy = find(to.x);
                if (fx != fy) {
                    ans += cur.w;
                    uinio(from.x, to.x);
                }
            }
            if (ans != 0) System.out.println(ans);
            else System.out.println("impossible");
        }
        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面都行
        // 从小到大拍的话 返回 参数 (a,b) 返回 a - b ;
        static class EdgeComparator implements Comparator<Edge> {
            public int compare(Edge o1 , Edge o2) {
                return o1.w - o2.w;
            }
        }


        static int find(int x) {
            int k = 0;
            while (x != f[x]) {
                // x 找父亲 相当于 静态链表
                help[k++] = x;
                x = f[x];
            }
            // 路径压缩
            for (-- k; k >= 0; k -- ) {
                f[help[k]] = x;
            }
            return x;
        }



        static void uinio(int x , int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) return;
            else {
                int sx = size[fx];
                int sy = size[fy];
                // y 所属集合大小  小于 x 所属集合 大小  小的挂大的上 减少树的深度增长
                if (sy <= sx) {
                    f[fy] = fx;
                    size[fx] += fy;
                }else {
                    f[fx] = fy;
                    size[fy] += fx;
                }
            }
        }


        static class Node {
            int x;
            List<Edge> edges;
            public Node(int x) {
                this.x = x;
                edges = new ArrayList<>();
            }
        }

        static class Edge {
            Node from;
            Node to;
            int w;
            public Edge(Node from , Node to , int w) {
                this.from = from;
                this.to = to;
                this.w = w;
            }
        }

        static class Graph {
            Map<Integer,Node> nodes;
            Set<Edge> edges;
            public Graph () {
                nodes = new HashMap<>();
                edges = new HashSet<>();
            }

        }
    }
