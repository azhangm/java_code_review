import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ac 116
 * 飞行员兄弟
 * @author zm
 * @date 2022/12/17
 */
public class AC_116 {
    //  + 闭合状态 - 打开状态
    static char[][] map = new char[4][4];
    static List<PII> ans = new ArrayList<>() ;
    static List<PII> tmp = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        for (int i = 0; i < 4; i++) {
           String s = sc.next();
           map[i]  = s.toCharArray();
        }
        dfs(0,0);
        System.out.println(ans.size());
        for (PII an : ans) {
            System.out.println((an.x + 1) + " " + (an.y + 1));
        }
    }

    private static void dfs(int i , int j) {
//      枚举到最后一个位置时
        if (i == 3 && j == 4) {
            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    if (map[k][l] == '+') return;
                }
            }
            // 锁开了
        if (ans.isEmpty() ||  tmp.size() < ans.size()) ans.addAll(tmp);
        return;
        }

//        枚举所有的情况
        if ( j == 4 ) {
            i ++ ;
            j = 0;
        }
        // 我不操作门把手
        dfs(i,j + 1);

        // 我操作门把手

        turnAll( i , j );
        tmp.add(new PII(i,j));
        dfs(i,j + 1);
        tmp.remove(tmp.size() - 1);
        turnAll( i , j );
    }

    private static void turnOne(int x , int y) {
        map[x][y] =  map[x][y] == '+' ? '-' : '+';
    }

//    十字操作门把手
    private static void turnAll (int x , int y) {
        for (int i = 0; i < 4; i++) {
//            x 行 i 列全部操作门把手
            turnOne(x,i);
//           i 行 y 列全部操作门把手
            turnOne(i,y);
        }
        turnOne(x,y);
    }

    static class PII {
         int x ;
         int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
