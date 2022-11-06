package TopologicalSort;


import java.util.*;

/**
 * 主要
 * ac 链接 : https://www.acwing.com/problem/content/850/
 * @author zm
 * @date 2022/10/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[m][2];
        for (int i = 0 ; i < m; i ++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }
//        初始化map 为 图结构
        Graph graph = GetGraph(map);
        getTopoSort(graph);
    }

    private static void getTopoSort(Graph graph) {


        Set<Integer> nodeInt = graph.nodeMaP.keySet();
//        zeroNode
//        zero queue
        Deque<Node> zeroQueue = new LinkedList<>();

        int count = 0;
        for (Integer integer : nodeInt) {
            Node node = graph.nodeMaP.get(integer);
//            System.out.println("node 值  = " + node.val +  "node 入度 =  " + node.in);
            count ++;
            if (node.in == 0) {
                zeroQueue.addLast(node);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Node cur;
        while (!zeroQueue.isEmpty()) {
            cur = zeroQueue.removeFirst();
            ans.add(cur.val);
            System.out.println( "cur.val  = "  + cur.val);
            for (Node node : cur.nodes) {
                node.in--;
                System.out.println( "node.val = " + node.val);
                if (node.in == 0) {
                    zeroQueue.addLast(node);
                }
            }
        }
        if (count != ans.size()) {
            System.out.println(-1);
            return;
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    private static Graph GetGraph(int[][] map) {
        Graph graph = new Graph();
        for (int[] i : map) {
            int from = i[0];
            int to = i[1];
            Node fromNode;
            if (!graph.nodeMaP.containsKey(from)) {
                fromNode = new Node(from);
                graph.nodeMaP.put(from,fromNode);
            }
            else fromNode  = graph.nodeMaP.get(from);
            Node toNode;
            if (!graph.nodeMaP.containsKey(to)) {
                toNode = new Node(to);
                graph.nodeMaP.put(to,toNode);
            }
            else toNode = graph.nodeMaP.get(to);
//            建边
            fromNode.nodes.add(toNode);
            System.out.println("当前点  == "  + fromNode.val);
            System.out.println("邻居点 "  + toNode.val);
            toNode.in ++;
            for (Node node : fromNode.nodes) {
                System.out.println("该点的邻居  == "  + node.val + "邻居的入度 = " + node.in);
            }

        }
            return  graph;
    }

    private static class Node {
        // 入度
         int in;
         ArrayList<Node> nodes;
         int val;
        public Node(int val) {
            nodes = new ArrayList<>();
            this.val = val;
        }
    }


    private static class Graph {
        Map<Integer,Node> nodeMaP ;

        public Graph() {
            nodeMaP = new HashMap<>();
        }
    }
}
