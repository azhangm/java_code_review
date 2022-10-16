package nuc.zm.MoreThread.method_test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sec选项卡
 * 秒表实现
 * @author zm
 * @date 2022/10/16
 */
public class SecTab {

    public static void main(String[] args) throws InterruptedException {



        SimpleDateFormat simpleDateFormat;



        while (true) {
            Date date = new Date();

            simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

            String format = simpleDateFormat.format(date);

            System.out.println(format);
            Thread.sleep(1000);
        }

    }

}
