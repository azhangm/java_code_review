package nuc.zm.io.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 多播套接字演示
 *
 * @author zm
 * @date 2023/04/02
 */
public class MulticastSocketDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket();
        InetAddress multicastAddress = InetAddress.getByName("239.255.255.255");
//       将当前电脑添加到组播组中
//        multicastSocket.joinGroup(multicastAddress);

//        像一组电脑发送数据
        String msg = "你好！socket";
        byte[] bytes = msg.getBytes();
        int port = 10086;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,multicastAddress,port);
        // 发送数据
        multicastSocket.send(datagramPacket);
        // 释放资源
        multicastSocket.close();
    }
}
