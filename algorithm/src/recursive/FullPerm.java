package recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列
 *
 * @author zm
 * @date 2022/10/31
 */
public class FullPerm {

    private static boolean[] use;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
//        String str = sc.next();
        permutation("123");
    }

    /**
     * 排列
     *
     * @param str str
     */
    private static void permutation(String str) {
        if (str == null) return;
        char[] chars = str.toCharArray();
        use = new boolean[chars.length];
        dfs2(chars,new ArrayList<>(),0);
        }


    private static void dfs(char[] str  , List<String> list, int idx) {
        if (idx >= str.length) {
            System.out.println(list);
        }

        for (int i = 0; i < str.length; i++) {
            if (use[i]) continue;
            list.add(String.valueOf(str[i]));
            use[i] = true;
            dfs(str,list,idx + 1);
            list.remove(list.size() - 1);
            use[i] = false;
            }
    }


    private static void dfs2(char[] str  , List<String> list, int idx) {
        if (idx >= str.length) {
            list.add(String.valueOf(str));
            System.out.println(list);
        }

        for (int i = idx; i < str.length; i++) {
            swap(str,i,idx);
            dfs(str, list, idx + 1);
            swap(str,idx, i);
        }
    }

    private static void swap(char[] str , int i , int idx) {
        char tmp = str[i];
        str[i] = str[idx];
        str[idx] = tmp;
    }
}
