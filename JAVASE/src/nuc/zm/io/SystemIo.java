package nuc.zm.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 系统输入输出
 *
 * @author zm
 * @date 2022/10/12
 */
public class SystemIo {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int read;
        OutputStream outputStream = new FileOutputStream("woaini.txt");
        byte[] a = new byte[3];
        while ((char)(in.read(a)) != '0') {
            read = in.read();
            for (int i = 0; i < a.length; i++) {
                outputStream.write(a[i]);
            }
        }
        in.close();
        outputStream.close();
    }
}
