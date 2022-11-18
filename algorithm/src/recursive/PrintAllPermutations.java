package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 打印所有排列
 * @description  "打印字符串的全排列"
 * @description  ”递归 本质 -->  尝试“
 * @author zm
 * @date 2022/11/18
 */
public class PrintAllPermutations {
    private static final List<String> list = new ArrayList<>();

    public static void main (String[] as) {
        getAllPermutations("123");
    }

    private static void getAllPermutations(String s) {
        if ( s == null || s.length() == 0 ) return;
        ArrayList<Character> characters = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        dfs(characters,"");
        System.out.println(list);
    }

    private static void dfs(List<Character> characters,String ans) {
        if (characters.isEmpty()) {
            list.add(ans);
        }else  {
            for (int i = 0 ; i < characters.size(); i ++) {
                Character remove = characters.remove(i);
                dfs(characters,ans + remove);
                characters.add(i,remove);
            }
        }
    }
}
