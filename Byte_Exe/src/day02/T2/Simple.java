package day02.T2;
import java.util.*;
import java.io.*;
public class Simple {


        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            String ip = sc.next();
            boolean check = check(ip);
            if (!check)
                System.out.println("Error");
            else System.out.println(transForm(ip));
        }

        static boolean check(String ip) {
            String[] strs =  ip.split("\\.");
            // 不是四个整数组成 返回 false
            if (strs.length != 4) return false;
            for(int i = 0 ; i < 4 ; i ++ ){
                if (strs[i].charAt(0) == '0' || !Character.isDigit(strs[i].charAt(0))) return false;
                for (int j = 1 ; j < strs[i].length(); j ++ ) {
                    if (!Character.isDigit(strs[j].charAt(0))) return false;
                }
                int i1 = Integer.parseInt(strs[i]);
                if (i1 > 255 ) return  false;
            }
            return true;
        }

        static String transForm(String ip) {
            StringBuilder sb = new StringBuilder("0x");
            String[] strs =  ip.split("\\.");
            for (String s : strs) {
                sb.append(numToString(s));
            }
            return sb.toString();
        }

        static String numToString(String s) {
            int num = Integer.parseInt(s);
            StringBuilder sb = new StringBuilder();
            if (num < 10) {
                sb.append(0).append((char)(num + '0'));
                return sb.toString();
            }
                while (num != 0) {
                int a = num % 16;
                char c ;
                // 变成 对应的 ascall 字符
                if (a >= 10) c = (char) ('A' + a - 10);
                else c = (char) (a + '0');
                sb.append(c);
                num /= 16;
            }
            return sb.reverse().toString();

        }

}
