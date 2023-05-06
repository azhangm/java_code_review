package datetitile;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class DiffTwoDate {
    static int[] mothDay = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while (sc.hasNext()) {
            int date1 = sc.nextInt();
            int date2 = sc.nextInt();
            System.out.println(diff(date1,date2));
        }
    }

    static int diff(int date1,int date2) {
        int day1 = day(date1);
        int day2 = day(date2);

        return day2 > day1 ? day2 - day1 + 1 : day1 - day2 + 1;
    }

    static boolean leapYear(int year) {
        if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0 )
            return true;
        return false;
    }

    static int day(int date) {
        int ans = 0;
        int year = date / 10000;
        date %= 10000;
        int month = date / 100;
        int day = date % 100;
        while (month -- > 0) {
            if (month == 2 && leapYear(year)) ans += 1;
            ans += mothDay[month];
        }
        while (year -- > 0) ans += leapYear(year) ? 366 : 365;

        ans += day;
        return ans;
    }
}
