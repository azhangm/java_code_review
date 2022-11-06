package recursive;

import java.util.Stack;

/**
 * 堆栈倪
 * 栈 逆序
 * @author zm
 * @date 2022/10/31
 */
public class StackNi {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reserve(stack);
        System.out.println(stack);
    }

    private static int dfs(Stack<Integer> stack) {
        int result = stack.pop();
        // 每一层的 result 都不一样
//        子问题求解 -- base case
        if (stack.isEmpty()) {
            System.out.println("栈底元素" + result);
            return result;
        }
//        拿到 栈底 元素 通过 子问题 base case 求解
        int last = dfs(stack);
        stack.push(result);
        return last;
    }

//   如何 逆序 现在每次 可以抽掉 最底部的元素
    private static void reserve(Stack<Integer> stack) {
//        base case 解决的问题 dfs 拿 元素 肯定会 空栈
        if (stack.isEmpty()) return;
//        获得 底部~~~~~~~ 黑盒方法
        int stackBottom = dfs(stack);  // 1 2 3 4 5  得 递归系统栈 最终 返 5 4 3 2 1
//        递归 每次拿 栈底  空了 去加 递归出口 层层调用
        reserve(stack);
        System.out.println("每次压入的元素  : " + stackBottom);
        stack.push(stackBottom);


    }
}
