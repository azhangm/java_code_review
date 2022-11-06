package TopologicalSort;


import java.io.File;
import java.util.*;

/**
 * @author zm
 * @date 2022/10/25
 * 拓扑排序 2
 *  使用点的 入度
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][2];
        Graph graph = generateGraph(map);
        getTopSort(graph);
    }

    /**
     * 信息
     * 那个点 有哪些信息。
     * @author zm
     * @date 2022/10/26
     */ //    通过递归来拉取 这里边提到的信息
    static class Info {
        int nodeNum;
        Node node;
    }

    private static void getTopSort(Graph graph) {
        if (graph == null) return;

    }



    //    追求点次 与 其他无关 只要点 这个图 变成了点集 每个点 都知道自己的邻居是谁 即 指向谁
    private static Graph generateGraph(int[][] map) {
        if (map.length == 0) return null;
        Graph graph = new Graph();
        for (int[] i : map) {
            int from =  i[0];
            int to = i[1];
            Node fromNode = null;
            if (graph.nodeMap.containsKey(from))
                fromNode = graph.nodeMap.get(from);
            else fromNode = new Node(from);
            Node toNode = null;
            if (graph.nodeMap.containsKey(to))
                toNode = graph.nodeMap.get(to);
            else  toNode = new Node(to);

//            对点的邻居 和 这个点出发的边进行 操作
            fromNode.nodeList.add(toNode);
        }
        return graph;
    }

    // 点类
    static class Node {
        int val;
//        这个点 的 邻居点
        List<Node> nodeList;
//        从这个点出发 有几条边

        public Node(int val) {
            this.val = val;
            nodeList = new ArrayList<>();
        }
    }

    // 边 类
//    static class Edge{
////        边的组成  从哪个点 到 那个点  记录点次 可以不要边 类
//        Node from;
//        Node to;
//
//        public Edge(Node from, Node to) {
//            this.from = from;
//            this.to = to;
//        }
//    }

    //
    static class Graph {
        Map<Integer , Node> nodeMap;
//        Set<Edge> edgeSet;

        public Graph() {
            nodeMap =  new HashMap<>();
//            edgeSet = new HashSet<>();
        }
    }
}
