import java.util.*;

public class Main {
    static int[] v;
    static int[] w;
    static boolean[] use;
    static int N;
    static int W;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        v = new int[N];
        w = new int[N];
        use = new boolean[N];
        for (int i = 0 ; i < N ; i ++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(ans);
    }


    private static void dfs(int u , int sumV) {
        if (sumV > W) return;
        for (int i = u ; i < N ; i ++) {
            if (use[i]) continue;
            use[i] = true;
            dfs(u + 1, sumV + v[i]);
            use[i] = false;
        }
        if (sumV <= W) {
            int res = 0;
            for (int i = 0 ; i < use.length; i ++) {
                if(use[i]) res += w[i];
            }
            ans = Math.max(ans,res);
        }
    }
}