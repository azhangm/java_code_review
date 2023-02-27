package moni;

public class T3 {
    /**
    * 　　对于一个日期，我们可以计算出年份的各个数位上的数字之和，也可以分别计算月和日的各位数字之和。
     *      请问从 1900 年 1 月 1 日至 9999 年 12 月 31 日，
     *      总共有多少天，年份的数位数字之和等于月的数位数字之和加日的数位数字之和。
     * 　　例如，2022年11月13日满足要求，因为 2+0+2+2=(1+1)+(1+3) 。
    * */
    static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
//        190011 - 99991231
        int ans = 0;
        for (int i = 190011; i <= 99991231 ; i++) {
            if (check(i)) {
                ans ++;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int date) {
        int year = date / 10000 ;
        int month = date % 10000 / 100;
        int day = date % 100;

        if ( month < 1 || month > 12 || day == 0) return false;

        if (month != 2 && day > months[month]) return false;

        if (month == 2) {
            int leap = year % 4 == 0 || year % 100 != 0 || year % 400 == 0 ? 1 : 0;
            if (day > months[month] + leap) return false;
        }
        int sumYear = 0;
        while (year != 0){
            sumYear += year % 10;
            year /= 10;
        }

        int sumMonth = 0;
        while (month != 0) {
            sumMonth += month % 10;
            month /= 10;
        }

        int sumDay = 0;
        while (day != 0) {
            sumDay += day % 10;
            day /= 10;
        }
        return sumYear == sumMonth + sumDay;

    }

}
