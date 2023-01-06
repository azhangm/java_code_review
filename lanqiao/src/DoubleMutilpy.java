import java.math.BigInteger;
import java.util.Scanner;

/**
 * 双阶乘
 *
 * @author zm
 * @date 2023/01/01
 */
public class DoubleMutilpy {

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 0; i <= 2021; i++) {
            if (i % 2 == 1) bigInteger  = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigInteger.divideAndRemainder(BigInteger.valueOf(100000))[1]);
    }
}
