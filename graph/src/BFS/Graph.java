package BFS;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 *
 * @author zm
 * @date 2022/10/23
 */
public class Graph {
    private HashMap<Integer,Node> nodes;
    private HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }
}
