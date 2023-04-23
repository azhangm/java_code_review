package binary;

import java.io.*;
import java.math.*;
public class DecVsBin {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = read.readLine().split(" ");
        BigInteger n = new BigInteger(s[0]);
        String bin = toBinary(n);
        wt.println(toDecimal(bin));
        wt.flush();
        wt.close();
        read.close();
    }
    static BigInteger toDecimal(String s) {
        BigInteger ans = new BigInteger(String.valueOf(0));
        BigInteger tmp = new BigInteger(String.valueOf(1));
        for (int i = 0 ; i < s.length(); i ++) {
            int idx = s.charAt(i) - '0';
            ans = ans.add(tmp.multiply(new BigInteger(String.valueOf(idx))));
            tmp = tmp.multiply(new BigInteger(String.valueOf(2)));
        }
        return ans;
    }


    static String toBinary(BigInteger n) {
        StringBuilder sb = new StringBuilder();
        BigInteger one = new BigInteger(String.valueOf(1));
        BigInteger zero = new BigInteger(String.valueOf(0));
        while (!n.equals(zero)) {
            BigInteger mod = n.mod(new BigInteger(String.valueOf(2)));
            sb.append(mod);
            n = n.divide(BigInteger.valueOf(2));
        }
        sb.reverse();
        return sb.toString();
    }
}