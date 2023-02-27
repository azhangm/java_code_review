package moni;

import java.util.*;

public class T10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] map = new int[1000010];
        for (int i = 0 ; i < n ; i ++) {
            a[i] = sc.nextInt();
            map[a[i]] = i;
        }
        int k = sc.nextInt();
        int len = 2 * k  + 1;
        MyStack leftMinStack = new MyStack(n);
        MyStack rightMinStack = new MyStack(n);
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>();
        for (int x  : a) {
            while (!leftMinStack.isEmpty() && leftMinStack.peek() >= x ) {
                rightMap.put(leftMinStack.peek(),x);
                leftMinStack.pop();
            }
            if (!leftMinStack.isEmpty())
            leftMap.put(x,leftMinStack.peek());
            leftMinStack.push(x);
        }
        for (int i = 0 ; i < n; i ++) {
            int left = i - k;
            int right = i + k;
            int ans = a[i];
            for (int j = 0 ; j < n - len; j ++) {
                int idx = i - k + j;
                if (check(idx,n)) {
                    int x = a[idx];
                    Integer lmin = leftMap.get(x);
                    Integer rmin = rightMap.get(x);
                    int lidx = -1;
                    if (null != lmin)
                        lidx = map[lmin];
                    int ridx = -1;
                    if (null != rmin)
                        ridx = map[rmin];
                    if (lidx != -1 && lidx >= left && lidx <= right)
                        ans = lmin;
                    if (ridx != -1 && ridx >= left && ridx <= right)
                        ans = Math.min(ans,rmin);
                }
            }
            System.out.print(ans + " ");
        }

    }

    private static boolean check(int i , int n) {
        return i >= 0 && i < n;
    }

    static class MyStack {
        int top = -1;
        int[] stack;
        public MyStack(int n) {
            stack = new int[n];
        }

        void push(int x) {
            stack[++top] = x;
        }

        int peek() {
            return stack[top];
        }

        int pop() {
            return stack[top--];
        }

        boolean isEmpty() {
            return top == -1;
        }

    }

}