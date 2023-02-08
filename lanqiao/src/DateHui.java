import java.util.*;
import java.io.*;

public class DateHui {

    static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int date1 = sc.nextInt();
        int date2 = sc.nextInt();
        int res = 0;
        // 最多只有 9999 年
        for (int i = 0 ; i < 10000; i ++ ) {
            int date = i , t = i;
            for (int j = 0 ; j < 4 ; j ++) {date = date * 10 + t % 10 ; t /= 10; }
            if (date > date1 && date < date2 && check(date))
                res ++;
        }

        System.out.println(res);
    }

    static boolean check(int date) {
        int year = date / 10000 ;
        int month = date % 10000 / 100;
        int day = date % 100;

        if (month < 1 || month > 12 || day == 0) return false;

        if (month != 2 && day > months[month]) return false;

        if (month == 2) {
            if (year % 100 == 0 || year % 400 == 0 || year % 4 == 0 ) {
                return day <= months[2] + 1;
            }
            else{
                return day <= months[2];
            }
        }
        return true;
    }

}