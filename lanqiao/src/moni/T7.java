package moni;

import java.util.Scanner;

public class T7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        int[][] points = new int[n][2];//保存信号塔中心点位置
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int cnt = 0;//信号被覆盖的点个数
        for (int x = 0; x <= W; x++) {
            for (int y = 0; y <= H; y++) {
                boolean sign = false;
                for (int p = 0; p < n; p++) {
                    if (Math.sqrt((double) (x - points[p][0]) * (x - points[p][0]) + (y - points[p][1]) * (y - points[p][1])) <= R) {
                        sign = true;
                        break;
                    }
                }
                if (sign) cnt++;
            }
        }
        System.out.println(cnt);
    }
}

