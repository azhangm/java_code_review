/**
 * ac 1029
 *  带分数
 * @author zm
 * @date 2022/12/17
 */
import java.util.*;
import java.io.*;
public class AC_1029 {
        static int target ;
        static int ans;
        static boolean[] isUse;
        static int[] num;
        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            target = sc.nextInt();
            isUse = new boolean[10];
            num = new int[10];
            dfs(0);
            System.out.println(ans);
        }

        private static int calc (int l , int r) {
            int res = 0;
            for (int i = l ; i <= r; i ++) {
                res = res * 10 + num[i] ;
            }
            return res;
        }


        // 带分数中，数字 1∼9 分别出现且只出现一次
        private static void dfs(int u) {
            // 暴搜 每个数都出现一次
            if (u == 9) {
                for (int i = 0; i < 7; i ++) {
                    for (int j = i + 1; j < 8; j ++) {

                        int a = calc(0,i);
                        int b = calc(i + 1, j);
                        int c = calc(j + 1, 8);
                        // an = ac + b
                        if (a * c + b == c * target) {
                            ans ++;
                        }
                    }
                }
            }


            for (int i = 1; i < 10 ; i ++ ) {
                if (!isUse[i]){
                    isUse[i] = true;
                    num[u] = i;
                    dfs(u + 1);
                    isUse[i] = false;
                    num[u] = 0;
                }

            }
        }
    }
