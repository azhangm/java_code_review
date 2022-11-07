import java.util.ArrayList;
import java.util.List;

/**
 * leetcode816
 *
 * @author zm
 * @date 2022/11/07
 */
public class Leetcode816 {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList<>();
            if (s == "") return ans;
            //   [)
            s = s.substring(1,s.length() - 1);
            List<Record> list = new ArrayList<>();
            for (int i = 0 ; i < s.length() ; i ++) {
                Record record = new Record();
                record.x = s.substring(0,i + 1);
                record.y = s.substring(i + 1);
                list.add(record);
            }
            //   查看 x y 生成结果 便于后续操作
            System.out.println(list);
            // 过滤 不合法的 坐标
            for (Record record : list) {
                if ("".equals(record.x) || "".equals(record.y)) continue;
                List<String> listx = new ArrayList<>();
                List<String> listy = new ArrayList<>();


//                过滤开头是 0 的整数

                listx.add(record.x);
                listy.add(record.y);

                // 过滤 数长度小于2 的
                for (int i = 1; i < record.x.length(); i++) {
                    if (i != 1 && record.x.charAt(0) == '0' || record.x.charAt(record.x.length() -1 ) == '0') continue;
                    listx.add(record.x.substring(0,i) + "." + record.x.substring(i));
                }
                for (int i = 1; i < record.y.length(); i++) {
                    if (i != 1 && record.y.charAt(0) == '0' || record.y.charAt(record.y.length() -1 ) == '0') continue;
                    listy.add(record.y.substring(0,i) + "." + record.y.substring(i));
                }
                for (String x : listx) {
                    for (String y : listy) {
                        if (x.charAt(0) == '0' && x.length() > 1 && !x.contains(".")) break;

                        if (y.charAt(0) == '0'  && y.length() > 1) {
                            System.out.println(y  + "===" +   y.contains("."));
                            if (y.contains(".")) {
                                System.out.println("add  " + x + " m " + y);
                                ans.add("(" + x + "," + y + ")");
                            }
                            continue;
                        }
                        System.out.println("add  " + x + " p " + y);

                        ans.add("(" + x + "," + y + ")");

                    }
                }
            }

            return ans;
        }

        static class Record {
            String x;
            String y;

            public String toString(){
                return x + "," + y;
            }
        }

    public static void main(String[] args) {
//        System.out.println(new Leetcode816().ambiguousCoordinates("(123)"));
//        System.out.println(new Leetcode816().ambiguousCoordinates("(00011)"));
//        System.out.println(new Leetcode816().ambiguousCoordinates("(100)"));
        System.out.println(new Leetcode816().ambiguousCoordinates("(001)"));
//        System.out.println(new Leetcode816().ambiguousCoordinates("(0123)"));
    }
}
