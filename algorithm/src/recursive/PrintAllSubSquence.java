package recursive;

import java.util.ArrayList;

/**
 * 打印所有 子序列
 *
 * @author zm
 * @date 2022/11/18
 */
public class PrintAllSubSquence {

    private static final ArrayList<String> ans = new ArrayList<>();


    public static void main(String[] args) {
        getAllStr("123");
        System.out.println(ans);
    }

    public static void getAllStr(String s) {
        if (s == null || s.length() == 0) return;
//        每次 分支状态 选 / 不选
        dfs(s.toCharArray(), 0, "");
        System.out.println(ans.toArray().length);
    }

    private static void dfs(char[] toCharArray, int i, String s) {
        if (i == toCharArray.length) {
            ans.add(s);
        } else {
            dfs(toCharArray, i + 1, s + toCharArray[i]);
            dfs(toCharArray, i + 1, s);
        }
    }
}

