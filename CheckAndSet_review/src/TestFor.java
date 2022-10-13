import java.util.Date;

public class TestFor {
    public static void main(String[] args) {
        int k = 1;
        long l1 = System.currentTimeMillis();
//        for (int i = 0 ; i < k ; k ++) {
//        }
        while (k != 0);
        long l = System.currentTimeMillis();
        System.out.println(l - l1);
    }
}
