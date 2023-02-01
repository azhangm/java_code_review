public class AC_16 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer(" h jPW5a   y rZ 4 6E");
        String s = replaceSpaces(stringBuffer);
        System.out.println(s);
    }
        public static String replaceSpaces(StringBuffer str) {
            int n = str.length();
            for (int i = 0 , j = 0 ; i < n ; j += 2 , i = j) {
                while (j < n && str.charAt(j) != ' ') {
                    j ++;
                }
                // j停留在了空格位置
                if (j != n) {
                    str.replace(j, j + 1, "%20");
                    n += 2;
                    System.out.println(n);
                }
            }
            return str.toString();
        }
}
