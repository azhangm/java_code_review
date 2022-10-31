package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印 str 全部子序列
 *
 * @author zm
 * @date 2022/10/30
 */
public class PrintStr {

    public static void main(String[] args) {
        String str = "!23";
        char[] chars = str.toCharArray();
        System.out.println(dfs(0, chars, "", new ArrayList<>()));
    }

    static List<String > dfs(int i , char[] str , String path , List<String > list) {
           if (i >= str.length) {
               System.out.println(path);
                list.add(path);
                return null;
           }
        dfs(i + 1,str,path,list);
        dfs(i  + 1,str,path + str[i],list);
        return list;
    }

}
