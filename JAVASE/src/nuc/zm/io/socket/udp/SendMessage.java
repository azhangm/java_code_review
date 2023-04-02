package nuc.zm.io.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * 发送消息
 * @description  : 使用 udp 协议发送数据
 * @author zm
 * @date 2023/04/02
 */
public class SendMessage {
    public static void main(String[] args) throws IOException {

        // 创建对象 ： 空参 所有可用端口中随机一个进行使用
        DatagramSocket datagramSocket = new DatagramSocket();

        //发送数据
        String msg = "你好！socket";
        byte[] bytes = msg.getBytes();
        InetAddress zhangmeng = InetAddress.getByName("zhangmeng");
        int port = 10086;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,zhangmeng,port);
        // 发送数据
        datagramSocket.send(datagramPacket);
        // 释放资源
        datagramSocket.close();
    }
}
