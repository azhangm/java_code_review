import java.util.*;
import java.io.BufferedInputStream;
import java.util.HashMap;

public class AC_4653 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] a = new long[n + 1];
            for (int i = 1 ; i <= n ; i ++) a[i] = i;
            HashMap<Long,Long> map = new HashMap<>();
            // 处理每位数字的排序
            for (int i = 1 ; i <= n ; i ++) {
                long s = 0;
                while (a[i] != 0) {
                    s += a[i] % 10;
                    a[i] /= 10;
                }
                map.put((long)i,s);
            }

            PriorityQueue<PII> priorityQueue = new PriorityQueue<>();
            for (long i = 1 ; i <= n ; i ++) {
                priorityQueue.add(new PII(i,map.get(i)));
            }
            long ans = 0;
            for (int i = 1 ; i <= m ; i ++) {
                ans = Objects.requireNonNull(priorityQueue.poll()).key;
            }
            System.out.println(ans);
        }

        static class PII implements Comparable<PII>{
            Long key;
            Long value;


            public PII(Long key, Long value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(PII o) {
                return (int) (this.value - o.value);
            }

            @Override
            public String toString() {
                return "PII{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }
}
