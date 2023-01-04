package Day01;
import java.io.*;
import  java.util.*;
public class Main {
    public static void main(String []args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String a = sc.next();
        String b = sc.next();

        int numA = transForm(a);
        int numB = transForm(b);
        System.out.println(numToString(numA + numB));

    }

    private static String numToString(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int a = num % 36;
            char c ;
            if (a >= 10) {
                c = (char) ((a + 'a' - 10));
            }else {
                c = (char) (a + '0');
            }
            sb.append(c);
            num /= 36;
        }
        return sb.reverse().toString();
    }

    static int transForm(String s) {
        char[] chs =  s.toCharArray();
        int ans = 0;
        for (int i = 0 ; i < s.length() ; i ++ ) {
            ans *= 36;
            ans += (stringToNum(chs[i]));
        }
        return ans;
    }

    static int stringToNum(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a' + 10;
        return  c - '0';
    }
}