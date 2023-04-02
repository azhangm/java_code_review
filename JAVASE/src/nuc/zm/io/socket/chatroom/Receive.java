package nuc.zm.io.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 收到
 *
 * @author zm
 * @date 2023/04/02
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10086);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DatagramPacket datagramPacket;
        while (true) {
            datagramPacket = new DatagramPacket(new byte[1024], 1024);
            datagramSocket.receive(datagramPacket);
            String msg = new String(datagramPacket.getData());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println( "从" + datagramPacket.getPort() + "发来的信息：" + msg);
            if (msg.equals("拜拜")) break;
        }
        datagramSocket.close();

    }
}
