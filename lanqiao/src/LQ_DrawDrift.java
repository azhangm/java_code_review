/**
 * lq画漂移
 *
 * @author zm
 * @date 2023/01/03
 */
import java.util.*;
import java.io.*;
public class LQ_DrawDrift {

    // 指数型枚举
    static int ans;
    static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        // 你知道在你下游 D 米处有一个峡谷，如果你向下游前进大于等于 D 米则必死无疑。
        int D = sc.nextInt();
        // T  秒后救援队会到达并将你救上岸。
        int T = sc.nextInt();
        // 每消耗一点体力，你可以划一秒桨使船向上游前进 1 米，否则会向下游前进 1 米(水流)。
        int M = sc.nextInt();
        dfs(D,T,M);
        System.out.println(ans);
    }

    // 含义 在 D 米处 T 秒时间内 每次选择 消耗体力 还是 不消耗体力
    static void dfs(int D , int T , int M) {
        // 救援队时间没到 我能游到
        if ( T == 0  ) {
            // 体力还在可以被救援
            if (M >= 0)  ans = (ans + 1) % MOD;
            System.out.println(" T " + T  +  " M " + M + " D "  + D);
        }
        // 不消耗体力
        if (D > 1)
            dfs(D - 1,T - 1, M);
        // 消耗体力
        if (M > 0)
            dfs(D + 1, T - 1 , M - 1);

    }
    }
