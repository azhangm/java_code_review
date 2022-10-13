package nuc.zm.io;

import org.junit.Test;

import java.io.*;

/**
 * 数据输入输出
 *
 * @author zm
 * @date 2022/10/13
 */
public class DataIO {

    /**
     * 测试数据输出流
        处理流 : 按顺序写入 按顺序读入 不然读出来的不对

     */
    @Test
    public void testDataOutputStream() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("E:\\code_review\\JAVASE\\demo.txt"));
        dataOutputStream.writeInt(123);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeChars("你好");
        dataOutputStream.flush();
        dataOutputStream.close();
//        写进去的是乱码
    }

    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("E:\\code_review\\JAVASE\\demo.txt"));
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readUTF());
        dataInputStream.close();
    }
}
