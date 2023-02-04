import java.util.*;
import java.io.*;
public class AC_858_Prim {

        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            int m = sc.nextInt();
            Map<Integer,Node> nodes = new HashMap<>();
            while (m -- > 0 ) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                if (!nodes.containsKey(u)) nodes.put(u,new Node());
                if (!nodes.containsKey(v)) nodes.put(u,new Node());
                Node from = nodes.get(u);
                Node to = nodes.get(v);
                Edge edge =  new Edge(from,to,w);
                from.edges.add(edge);
                to.edges.add(edge);
            }
            PriorityQueue<Edge> que = new PriorityQueue<>(new EdgeComparator());

            Set<Node> nodeSet = new HashSet<>();
            int ans = 0;
            int cnt = 0;
            // 随机取一个值  然后 就 跳出去
            for (Node node : nodes.values()) {
                if (!nodeSet.contains(node)) {
                    // 如果这个点没有被解锁过 就加入到解锁池中 后续不在考虑
                    nodeSet.add(node);
                    // 解锁了该点 就要解锁这个点所有相邻的边 这个边在 edges 这个list中
                    for (Edge e : node.edges) {
                        que.add(e);
                    }
                    while (!que.isEmpty()) {
                        Edge e = que.poll();
                        Node to = e.to;
                        if (!nodeSet.contains(to)) {
                            ans += e.w;
                            cnt ++;
                            // 加入到 解锁池中 后续不在考虑
                            nodeSet.add(to);
                            // 解锁了一个新的点 就要解锁新的边
                            for (Edge ed : to.edges) que.add(ed);
                        }
                    }
                }
                break;
            }
            // cnt < n - 1 每两个点之间至少一条边的理论不成立 输出 impossible
            if (cnt < n - 1) System.out.println("impossible");
            else System.out.println(ans);
        }

        static class EdgeComparator implements Comparator<Edge> {
            public int compare(Edge a , Edge b){
                return a.w - b.w;
            }

        }


        static class Node {
            List<Edge> edges;
            public Node() {
                edges = new ArrayList<>();
            }
        }

        static class Edge{
            Node from;
            Node to;
            int w;
            public Edge (Node from,Node to , int w) {
                this.from = from;
                this.to = to;
                this.w = w;
            }
        }
    }
