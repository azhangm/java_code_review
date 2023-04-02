package nuc.zm.io.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 接收消息
 * @description : 接收数据 快递公司 例子 我找快递公司 - 创建对象  拿箱子-- 接收打包好的数据 拆箱子 -- 解析数据包 签收走人 -- 释放资源
 * @author zm
 * @date 2023/04/02
 */
public class MulticastSocketReceiveMessage1 {
    public static void main(String[] args) throws IOException {
        // 找快递公司
        MulticastSocket datagramSocket = new MulticastSocket(10086);
        InetAddress byName = InetAddress.getByName("239.255.255.255");
        datagramSocket.joinGroup(byName);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        datagramSocket.receive(datagramPacket);

        // 解析数据包
        InetAddress address = datagramPacket.getAddress();
        System.out.println("从哪台电脑发来 ？"  + address.getHostName());
        System.out.println("哪个端口号？" + datagramPacket.getPort());
        System.out.println("发送的数据是: " + new String(datagramPacket.getData()));
        System.out.println("ip + 端口号 " + datagramPacket.getSocketAddress());
    }
}
