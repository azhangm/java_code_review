import java.util.*;
import java.io.*;

public class MultipyTable {
    static char[] table = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M',
                    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'

    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int bit = sc.nextInt();
        for (int i = 1 ; i < bit ; i ++) {
            for (int j = 1 ; j <= i ; j ++ ) {
                int pro = i * j;
                System.out.print(transForm(i,bit) + "*" + transForm(j,bit) + "=" + transForm(pro,bit) + " ");
            }
            System.out.println();
        }

    }


    static String transForm (int num , int bit) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
           sb.append(table[num % bit]);
           num /= bit;
         }
        // 高位在前
        sb.reverse();
        return  sb.toString();
    }
}