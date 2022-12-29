//    https://www.acwing.com/problem/content/4723/


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
//    小写 字母 26
//     两个字母相同且相邻，连续字母对
//        双指针 维护一个 不会重复的区间
        StringBuilder ans = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        Deque<Character> deque = new LinkedList<>();
        deque.addLast(str[0]);
        for (int i = 1 ; i < str.length ; i ++) {
//            过滤相同的
            if (!deque.isEmpty() && str[i] == deque.peekLast()) {
                deque.removeLast();
                continue;
            }
            deque.addLast(str[i]);

        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        System.out.println(sb);
    }
}
