package recursive;

import java.util.Stack;

/**
 * 反向堆栈
 * @description 使用 递归 逆序 一个栈
 * @author zm
 * @date 2022/11/18
 */
public class ReverseStack {
    public static void main(String[] args) {
        // give your a stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 1 ; i <= 5; i ++) {
            stack.push(i);
        }
        Stack stack1 = new Stack<>();
        stack1.addAll(stack);
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println(getLast(stack));
        }

        reserve(stack1);
        System.out.println(stack1);
    }

    private static void reserve(Stack stack) {
        if (stack.isEmpty()) return;
        int i = getLast(stack);
        reserve(stack);
        stack.push(i);
    }

//    递归 获得 没一
    private static int getLast(Stack<Integer> stack) {
        if (stack.isEmpty()) throw new RuntimeException("别给空栈");
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }
        int last = getLast(stack);
//        每一层的 result 环境都不一样
        stack.push(result);
        return last;
    }
}
