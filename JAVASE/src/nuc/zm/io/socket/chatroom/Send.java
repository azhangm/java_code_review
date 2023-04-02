package nuc.zm.io.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发送
 *
 * @author zm
 * @date 2023/04/02
 */
public class Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = read.readLine();
            // 给 10086 发送数据
            byte[] bytes = s.getBytes();
            InetAddress zhangmeng = InetAddress.getByName("zhangmeng");
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, zhangmeng, 10086);
            datagramSocket.send(dp);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println(s);
            if (s.equals("拜拜")) break;
        }
        datagramSocket.close();
    }
}
