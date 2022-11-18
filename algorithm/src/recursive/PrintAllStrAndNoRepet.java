package recursive;

import java.util.HashSet;
import java.util.Set;

/**
 * 打印所有 str 的子序列 和 没有重复
 *
 * @author zm
 * @date 2022/11/18
 */
public class PrintAllStrAndNoRepet {
    private static final Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String s = "123";
        getAllNoRepetStr(s);
    }

    private static void getAllNoRepetStr(String s) {
        if (s == null || s.length() == 0) return;
        dfs(s.toCharArray(),0,"");
        System.out.println(set);
    }

    private static void dfs(char[] toCharArray, int i, String s) {
        if (i == toCharArray.length) {
            set.add(s);
        }else {
            dfs(toCharArray,i + 1, s + toCharArray[i]);
            dfs(toCharArray,i + 1, s);
        }
    }
}
