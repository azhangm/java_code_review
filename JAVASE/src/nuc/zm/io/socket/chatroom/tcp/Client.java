package nuc.zm.io.socket.chatroom.tcp;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建socket
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", Server.PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 用户输入信息
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String msg = read.readLine();

            // 发送消息
            writer.write(msg + "\n");
            writer.flush();

            //  读取服务器返回的消息

            String s = reader.readLine();
            System.out.println( s);
        } finally {
            if (socket != null)
                socket.close();
        }
    }
}
