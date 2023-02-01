import java.util.HashSet;
import java.util.Set;

public class AC_61 {
    public static void main(String[] args) {
        int abcabc = longestSubstringWithoutDuplication("bjvzbhvklndbyjqbfkeskqhegaeuovgvjijermcebtdhtmwuclvnklyetkfxvvglzjgafl");
        System.out.println(abcabc);
    }
        public static int longestSubstringWithoutDuplication(String s) {
            // 字串 不重复 双指针维护一个没有重复字符串的子区间
            // Set 集合维护 不重复的数组
            Set<Integer> set = new HashSet<>();
            int n = s.length();
            int ans = 0;
            for (int i = 0,j = 0; i < n; i = j ) {
                while (j < n && set.add(s.charAt(j) - 'a')) j ++;
                // j 停留在第一个重复字母的区间上 j - i 即可
                ans = Math.max(ans , j - i);
                set.clear();
            }
            return ans;
        }
}
