import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1081 {
        public static int getNumberOfBacklogOrders(int[][] orders) {
            // od[1] 笔 类型为 od[2] 价格为 od[0] 的订单
            // od[2] 0 buy 1 sell
            // 采购订单 查看sell订单中的最低的
            // sell 订单 查看 buy 订单中最高的
            PriorityQueue<int[]> buyQueue = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
            PriorityQueue<int[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            int ans = 0;
            for (int[] od : orders) {
                //  直接入队列的情况
                if (od[2] == 0 && sellQueue.isEmpty()) buyQueue.add(od);
                else if (od[2] == 0 && sellQueue.peek()[0] > od[0]) buyQueue.add(od);
                else if (od[2] == 0) {
                    while (od[0] > sellQueue.peek()[0]) {
                        int sellPrice = sellQueue.peek()[0];
                        if (od[0] >= sellPrice) {
                            // 消耗销售订单
                            while (sellQueue.peek()[1] >= 0 && od[1] >= 0) {
                                sellQueue.peek()[1]--;
                                od[1] --;
                                ans++;
                            }
                            if (sellQueue.peek()[1] >= 0 && od[1] == 0) break;
                            if (od[1] >= 0 && sellQueue.peek()[1] == 0) sellQueue.poll();
                        }
                    }
                }
                if (od[2] == 1 && buyQueue.isEmpty()) sellQueue.add(od);
                else if (od[2] == 1 && buyQueue.peek()[0] < od[0]) sellQueue.add(od);
                    // 匹配订单的额情况 这时候队列一定不空 高订单与低订单匹配
                    // 销售订单匹配 采购订单 销售订单要 高于 或者等于这笔采购订单
                else if (od[2] == 1) {
                    while (true) {
                        assert buyQueue.peek() != null;
                        if (!(od[0] < buyQueue.peek()[0])) break;
                        int buyPrice = buyQueue.peek()[0];
                        if (od[0] >= buyPrice) {
                            // 消耗采购订单
                            while (buyQueue.peek()[1] >= 0 && od[1] >= 0) {
                                buyQueue.peek()[1]--;
                                od[1] --;
                                ans++;
                            }
                            assert buyQueue.peek() != null;
                            if (buyQueue.peek()[1] == 0) buyQueue.poll();
                        }
                    }
                }

            }
            return ans;
        }

    public static void main(String[] args) {
        System.out.println(getNumberOfBacklogOrders(new int[][]{
                {10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}
        }));
    }
}
