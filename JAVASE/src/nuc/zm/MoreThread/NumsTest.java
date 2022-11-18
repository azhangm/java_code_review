package nuc.zm.MoreThread;


/**
 * num测试
 *
 * @author zm
 * @date 2022/11/08
 */
public class NumsTest {
    static int[][] g = new int[1][1];

    public static void main(String[] args) {
        g[0][0] = 1;
        for (int[] ints : g) {
            System.out.println(ints[0]);
        }
    }
}
