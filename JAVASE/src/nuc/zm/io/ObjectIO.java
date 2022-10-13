package nuc.zm.io;

import org.junit.Test;

import java.io.*;

/**
 * 对象输入输出
 *
 * @author zm
 * @date 2022/10/13
 */
public class ObjectIO {

    /**
     * 测试字符串序列化
     */
    @Test
    public void testStringSerialization() throws IOException {
        File file = new File("demo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject("你好");
        oos.close();
    }

    @Test
    public void testStringDeSerialization() throws IOException, ClassNotFoundException {
        File file = new File("demo.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object o = objectInputStream.readObject();
        System.out.println(((String) o));
    }
}
