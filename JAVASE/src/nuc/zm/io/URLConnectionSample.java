package nuc.zm.io;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * urlconnection样本
 *
 * @author zm
 * @date 2022/11/06
 */
public class URLConnectionSample {

    private static InputStream inputStream;

    public static void main(String[] args) throws IOException {
//      统一资源定位符
        URL url = new URL("https://eec-cn.com/preView/fca1328443f345129ce59f03ecdff4f9/1/b0ec8b85dd854e32b1a5245b18b9ad9d/1?userType=0");

//         建立通信管道  和 某一台服务器建立连接
        URLConnection urlConnection = url.openConnection();

        inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/dadasdasdasda.jpg");

        byte[] bs = new byte[1024];

//        可能出现 没有吧数组填满的问题
        int len;
        while ((len = inputStream.read(bs)) != -1) {
        fileOutputStream.write(bs,0,len);
            }
        if (inputStream != null) inputStream.close();
//
    }
}
