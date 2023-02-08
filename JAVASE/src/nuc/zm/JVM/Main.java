package nuc.zm.JVM;

import org.junit.Test;

/**
 * 主要
 *
 * @author zm
 * @date 2023/02/08
 */
public class Main {

    @Test
    public void testEquals() {

        String hello = new String("hello");
        String str = new String("hello ") + new String("word");
        String str1 = "hello word";
        System.out.println(str == str1);

    }


    @Test
    public void testInteger(){
        Integer a = 129;
        int b = 129;
        System.out.println(a == b);
    }
}
