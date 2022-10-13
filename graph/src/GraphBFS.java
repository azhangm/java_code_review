import java.io.BufferedInputStream;
import java.util.*;

/**
 * 图bfs
 *
 * @author zm
 * @date 2022/10/09
 */
public class GraphBFS {
    /**
     * 节点
     *
     * @author zm
     * @date 2022/10/09
     */
    static class Node {
        public int value;
//        相邻有哪些点
        private List<Node> nodes;
//        从这个点出去的有哪些边
        private List<Edge> edgs;
//        存每个点 到 bfs 出发点的距离
        private int distance;

//
        public Node(int value) {
            this.value = value;
            nodes = new ArrayList<>();
            edgs = new ArrayList<>();
        }
    }
    static class Edge {
        private final int weight = 1;

        public Edge(Node fromNode, Node toNode) {
        }
    }

    static class Graph {
        private HashMap<Integer,Node> nodes;
        private HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }

    }

    public static void main(String[] args) {
////          初始化图
//        Graph graph = new Graph();
//        int[][] map = {{4,5},{1,2},
//                       {2,3},{3,4},
//                       {1,3},{1,4}};
////        初始化为 自己的图结构
//        for (int[] ints : map) {
//            int from = ints[0];
//            int to = ints[1];
////            压入点集
//            if (!graph.nodes.containsKey(from))
//                graph.nodes.put(from, new Node(from));
//            if (!graph.nodes.containsKey(to))
//                graph.nodes.put(to, new Node(to));
//
////            开始压入边
//            Node fromNode = graph.nodes.get(from);
//            Node toNode = graph.nodes.get(to);
//            Edge edge = new Edge(fromNode, toNode);
//            graph.edges.add(edge);
////            处理 入点 出点
//            fromNode.nodes.add(toNode);
//            fromNode.edgs.add(edge);
//        }
//
//
////        进行 宽搜
////        初始化队列 队列特点 尾进 头出
//
//        Deque<Node> queue = new LinkedList<>();
//        Node node = graph.nodes.get(1);
//        queue.addLast(node);
//        HashSet<Node> nodes = new HashSet<>();
////        进去一个注册一个 防止 走重复
//        nodes.add(node);
//        while (!queue.isEmpty()) {
//            Node node1 = queue.removeFirst();
//            for (Node node2 : node1.nodes) {
////                  如果没有被遍历过
//                if (!nodes.contains(node2)) {
//                    nodes.add(node2);
//                    queue.addLast(node2);
//                    node2.distance += 1;
//                }
//            }
//        }
//        System.out.println(graph.nodes.get(4).distance);
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[m][2];
        Graph graph = new Graph();
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < 2; j ++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int[] ints : map) {
            int from = ints[0];
            int to = ints[1];
            //   压入点集
            if (!graph.nodes.containsKey(from))
                graph.nodes.put(from, new Node(from));
            if (!graph.nodes.containsKey(to))
                graph.nodes.put(to, new Node(to));
            //   开始压入边
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(fromNode, toNode);
            graph.edges.add(edge);
            //   处理 入点 出点
            fromNode.nodes.add(toNode);
            fromNode.edgs.add(edge);
        }

//        进行 宽搜
//        初始化队列 队列特点 尾进 头出

        Deque<Node> queue = new LinkedList<>();
        Node node = graph.nodes.get(1);
        queue.addLast(node);
        HashSet<Node> nodes = new HashSet<>();
//        进去一个注册一个 防止 走重复
        nodes.add(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.removeFirst();
            for (Node node2 : node1.nodes) {
//                  如果没有被遍历过
                if (!nodes.contains(node2)) {
                    nodes.add(node2);
                    queue.addLast(node2);
                    node2.distance = node1.distance +  1;
                }
            }
        }
        System.out.println(graph.nodes.get(n).distance == 0 ? -1 : graph.nodes.get(n).distance);
    }
}
