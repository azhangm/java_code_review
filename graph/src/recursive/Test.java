package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 * @description  测试在 递归中 使用 全局变量 和 使用递归 参数的区别
 * @author zm
 * @date 2022/10/26
 */
public class Test {

    private static List<Integer> list = new ArrayList<>();
    static int x = 1;

//    递归测试 在 第 10 层 递归结束
    private static void dfs(int i ) {
        if (i >= 10) return;
        list.add(i++);
        x = i;
        System.out.println("全局" + x);
        dfs(i);
    }
// 验证 作为 局部变量
    private static void dfs(int i , List<Integer> list , String x) {
        if (i >= 10) return;
        list.add(i++);
        x = String.valueOf(i);
        System.out.println(x);
        dfs(i,list,x);
    }
    public static void main(String[] args) {
        dfs(1);
        System.out.println(list);
        List<Integer> test = new ArrayList<>();
        String y = "!";
        dfs(1,test,y);
        System.out.println("y" +  y );
        System.out.println(test);
        System.out.println( "x " + x);
    }
}
