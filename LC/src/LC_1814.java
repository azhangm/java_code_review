import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_1814 {


    public static void main(String[] args) {
        LC_1814 lc_1814 = new LC_1814();
        System.out.println(lc_1814.countNicePairs(new int[]{42, 11, 1, 97}));
    }

//    42 - rev(42)  =   rev(79) - rev(97)

        public int countNicePairs(int[] nums) {
            int ans = 0;
            Set<Integer> map = new HashSet<>();
            for (int num : nums) {
                int key = num - rev(num);
                if (!map.add(key)) ans ++;

            }
            return ans;
        }

        public int rev(int num) {
            int ans = 0;
            while (num != 0) {
                ans *= 10;
                ans += num %10;
                num /= 10;
            }
            return ans;
        }

}
