package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点
 * 组成 ：入度 出度 相邻的节点 从这个节点出发 都有哪些边？
 * @author zm
 * @date 2022/10/23
 */
public class Node {
    private int in;
    private int out;
    public int distance = -1;
    private List<Node> nodes;
    private List<Edge> edges;
    public Node(int val) {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }


    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }


}
