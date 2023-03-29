package graph;

/**
 * 八数码
 *
 * @author zm
 * @date 2023/03/29
 */
import java.util.*;
import java.io.*;

public class EightDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        StringBuilder s = new StringBuilder();
        for (int i = 0 ; i < 9 ; i ++) s.append(sc.next());
        String end = "12345678x";
        bfs(s.toString(),end);
    }

    static void bfs(String s , String end) {
        Map<String,Integer> map = new HashMap<>();
        map.put(s,0);
        int[] dx = new int[]{0,-1,0,1};
        int[] dy = new int[]{1,0,-1,0};
        Deque<String> que = new LinkedList<>();
        que.offerLast(s);
        while (!que.isEmpty()) {
            String tmp = que.pollFirst();
            if (tmp.equals(end)) {System.out.println(map.get(tmp)); return;}
            char[] str = tmp.toCharArray();
            int idx = tmp.indexOf('x');
            int x = idx / 3;
            int y = idx % 3;
            int dist = map.get(tmp);
            for (int i = 0 ; i < 4 ; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                swap(str,idx,nx * 3 + ny);
                tmp = new String(str);
                if (!map.containsKey(tmp)) {map.put(tmp,dist + 1); que.offerLast(tmp);}
                swap(str,nx * 3 + ny,idx);
            }
        }
        System.out.println(-1);
    }

    static void swap(char[] s , int x , int y) {
        char t = s[x];
        s[x] = s[y];
        s[y] = t;
    }
}