package moni;

import java.util.Scanner;

public class T6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int out = (w + n) % 7 ;
        out = out == 0 ? 7 : out;
        System.out.println(out);
    }

}
