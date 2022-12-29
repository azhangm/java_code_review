import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ac 95
 * 费解的开关
 * @description  这个灯的上下左右相邻的灯也会改变状态
 *              枚举每一个 可以选择改变灯状态和 不改变灯状态
 *               1 亮 ， 0 不亮
 *               与 飞行员兄弟不同 我这个属于 生搬硬套
 *  @author zm
 * @date 2022/12/18
 */
public class AC_95 {
    static int[][] arr;
    static int n;
    static List<PII> ans;
    static List<PII> tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
         n = sc.nextInt();
        arr  = new int[5][5];
        ans = new ArrayList<>();
        tmp = new ArrayList<>();
        while ( n -- > 0) {
            for (int i = 0; i < 5; i++) {
                String[] s = sc.next().split("");
              arr[i][0] = Integer.parseInt(s[0]);
              arr[i][1] = Integer.parseInt(s[1]);
              arr[i][2] = Integer.parseInt(s[2]);
              arr[i][3] = Integer.parseInt(s[3]);
              arr[i][4] = Integer.parseInt(s[4]);
            }
            dfs(0,0,0);
            int res = (ans.size() == 0) ? -1 : ans.size();
            System.out.println(res);
        }
    }

//    参数解释 x ， y 坐标 u 第几步
    private static void dfs(int x , int y , int u)  {
//        来到第6步 就要判断了
        if (u >= 6) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] == 0) return ;
                }
            }
            if (ans.isEmpty() && tmp.size() < 6) ans = tmp;
        }

        if ( x < 5 && y == 5 ) {
            x ++;
            y = 0;
        }

        // 操作开关
        turn(x,y);
        tmp.add(new PII(x,y));
        dfs(x,y + 1,u + 1);
        tmp.remove(tmp.size() - 1);
        turn(x,y);

        // 不操作开关
        dfs(x,y + 1 ,u + 1);


    }



    private static void turn (int x , int y) {
        turnOne(x,y);
        turnOne(x + 1, y);
        turnOne(x - 1 , y);
        turnOne(x,y + 1);
        turnOne(x,y - 1);

//        System.out.println("转变后的数组是 ：  "  +  " 转变坐标 " + x  + ", " + y);
//        for (int i = 0 ; i < 5 ; i ++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print (arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    private static void turnOne(int x , int y) {
        if (x >= 0 && x < 5 && y >= 0 && y < 5)
        arr[x][y] = arr[x][y] == 1 ? 0 : 1;
    }


    static class PII {
        int x;
        int y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
