package BFS;
// 图 点集 边集 组成

// https://www.acwing.com/problem/content/849/

import java.util.*;

/**
 * 主要
 *
 * @author zm
 * @date 2022/10/19
 */
public class Main {
    public static void main(String[] args) {
//        建图
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][2];
        for (int i = 0 ; i < n ; i ++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }
//        开始建图
        Graph graph = new Graph();
        for (int i = 0 ; i < n ; i ++) {
            int from = map[i][0];
            int to = map[i][1];

            HashMap<Integer, Node> nodes = graph.getNodes();
//            生成点 压入点集
            if (!nodes.containsKey(from))
                nodes.put(from,new Node(from));
            if (!nodes.containsKey(to))
                nodes.put(to,new Node(to));
            graph.setNodes(nodes);
//            压入边
            Node fromNode = graph.getNodes().get(from);
            Node toNode = graph.getNodes().get(to);
            Edge edge = new Edge(fromNode, toNode, 1);
            HashSet<Edge> edges = graph.getEdges();
            edges.add(edge);
            graph.setEdges(edges);
            int out = fromNode.getOut();
            List<Edge> edges1 = fromNode.getEdges();
            edges1.add(edge);
            fromNode.setEdges(edges1);
            List<Node> nodes1 = fromNode.getNodes();
            nodes1.add(toNode);
            fromNode.setNodes(nodes1);
//        图 初始化完毕
        }
        System.out.println(bfs(graph, m));

    }

    private static int bfs(Graph graph,int n) {
        if (graph.getNodes().size() == 1) return 0;
        Node node = graph.getNodes().get(1);
        Deque<Node> nodeDeque = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        nodeDeque.add(node);
        set.add(node);
        Node cur = null;
        while (!nodeDeque.isEmpty()) {
            cur = nodeDeque.removeFirst();
            List<Node> nodes = cur.getNodes();
            for (Node node1 : nodes) {
                if (!set.contains(node1)) {
                    set.add(node1);
                    nodeDeque.add(node1);
                    node1.distance = cur.distance + 1;
                }
            }
        }
        HashMap<Integer, Node> nodes = graph.getNodes();
        return graph.getNodes().get(n).distance == -1 ? -1 :  graph.getNodes().get(n).distance + 1 ;
    }
}
