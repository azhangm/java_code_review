import java.util.*;

/**
 * 并查集数据结构的实现
 *
 * @author zm
 * @date 2022/09/29
 */
public class Main {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        UnionFind<Integer> unionFind = new UnionFind<>(list);

        System.out.println(unionFind.findFather(unionFind.nodes.get(3)));
        unionFind.union(3,4);
        unionFind.union(3,5);
        System.out.println(unionFind.findFather(unionFind.nodes.get(3)));
        System.out.println(unionFind.findFather(unionFind.nodes.get(4)));
        System.out.println(unionFind.findFather(unionFind.nodes.get(5)));

        System.out.println(unionFind.isInASet(3, 5));

    }



    private    static class Node<V> {
        public V value;

        public Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 并查集 数据结构
     *
     * @author zm
     * @date 2022/09/29
     */
    public static class UnionFind<V> {
        private final HashMap<V,Node<V>> nodes;
        private final HashMap<Node<V>,Node<V>> parents;
        private final HashMap<Node<V> , Integer> size;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            size = new HashMap<>();
            for (V value : values) {
                Node<V> cur = new Node<>(value);
                nodes.put(value,cur);
                parents.put(cur,cur);
                size.put(cur,1);
            }
        }


        public boolean isInASet(V value1 , V value2) {
            return findFather(nodes.get(value1)) == findFather(nodes.get(value2));
        }

        private Node<V> findFather(Node<V> node) {
            Deque<Node<V>> deque = new LinkedList<>();
            while (node != parents.get(node)) {
                deque.add(node);
                node = parents.get(node);
            }
            while (!deque.isEmpty()) {
//                当前节点的父亲指向 最高父亲节点
                parents.put(deque.remove(),node);
            }
            return node;
        }

        /**
         * 联盟
         *
         * 合并 a 和 b 所在的集合
         * @param a a
         * @param b b
         */
        public void union(V a, V b) {
            Node<V> aFather = findFather(nodes.get(a));
            Node<V> bFather = findFather(nodes.get(b));
            if (aFather == bFather) return;
//            把小的挂到大的上  即 小的父亲也是大的父亲
            Integer aSize = size.get(aFather);
            Integer bSize = size.get(bFather);
            Node<V> big = aSize >= bSize ? aFather : bFather;
//            重定向
            Node<V> small = big == aFather ? bFather : aFather;

//            小的挂大的
            parents.put(small,big);
            size.put(big,aSize + bSize);
            size.remove(small);
        }
    }
}
