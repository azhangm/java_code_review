import java.util.*;
import java.io.*;
public class AC_848 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            int m = sc.nextInt();

            Map<Integer,Node> map = new HashMap<>();

            // 预处理点之间的关系
            boolean flag = true;
            for (int i = 0 ; i < m ; i ++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (!map.containsKey(x)) map.put(x, new Node(x));
                if (!map.containsKey(y)) map.put(y, new Node(y));
                // 从 x 点到 y 点
                Node from = map.get(x);
                from.nexts.add(map.get(y));

                if (map.get(x) == map.get(y)) {
                    System.out.println(-1);
                    flag = false;
                }
            }

                if (flag) {
                    // 处理 入度 表
                    Map<Node,Integer> inMap = new HashMap<>();
                    for (Integer k : map.keySet()) inMap.put(map.get(k),0);

                    for (Node k : inMap.keySet()) {
                        for (Node next : k.nexts)
                            inMap.put(next,inMap.get(next) + 1);
                    }

                    Deque<Node> zero = new LinkedList<>();
                    // 入度为 0 入队列
                    for (Node cur : inMap.keySet()) {
                        if (inMap.get(cur) == 0) zero.addLast(cur);
                    }

                    int cnt = 0; //记录点次
                    List<Integer> ans = new ArrayList<>();
                    // bfs 处理
                    while (!zero.isEmpty()) {
                        Node cur = zero.pollFirst();
                        cnt ++;
                        ans.add(cur.x);
                        for (Node next : cur.nexts) {
                            inMap.put(next, inMap.get(next) -1);
                            if (inMap.get(next) == 0) zero.addLast(next);
                        }
                    }
                    if (cnt < m) {
                        System.out.println(-1);
                    }else {
                        for (Integer x : ans) {
                            System.out.print(x + " ");
                        }
                    }
                }
            }

        static class Node {
            int x;
            List<Node> nexts;
            public Node(int x) {
                this.x = x;
                nexts = new ArrayList<>();
            }
        }
    }
