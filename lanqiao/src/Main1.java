import java.util.Arrays;

import java.util.*;
import java.io.*;

public class Main1 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        dfs(1,new ArrayList<>());
    }

    private static void dfs(int u , List list) {
        if (u == n + 1) {
            for(int i = 0 ; i < list.size(); i ++ ) {
                System.out.print(list.get(i));
            }
            System.out.println();
            return;
        }

        dfs( u + 1, list);

        list.add(u);
        dfs(u + 1, list);
        list.remove(list.size() - 1);

    }
}