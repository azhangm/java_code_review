public class LC_2287 {
    int[] map = new int[26];
    public int rearrangeCharacters(String s, String target) {
        int n = s.length();
        int m = target.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            map[idx]++;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int idx = target.charAt(i) - 'a';
            map[idx]--;
            if (i == m - 1 && map[idx] > 0) {
                ans++;
                i = -1;
                continue;
            }
            if (i == m - 1 && map[idx] == 0) {
                ans++;
                break;
            }
            if (map[idx] == -1) break;
        }
        return ans;
    }
}
