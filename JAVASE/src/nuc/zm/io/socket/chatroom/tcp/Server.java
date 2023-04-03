package nuc.zm.io.socket.chatroom.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final  int PORT = 9999;
    static ServerSocket serverSocket;
    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务启动成功，监听 PORT 端口");
            System.out.println(serverSocket);
            Socket accept = serverSocket.accept();
            System.out.println("客户端 [" + accept.getPort() + "] 已连接");
            BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            // 读取客户端发送的消息
            String s = reader.readLine();
            if (s != null) {
                System.out.println("客户端 [" + accept.getPort() + "] ：" +  s );
                writer.write("服务器 : " + s + "\n");
                writer.flush();
            }
        } finally {
            if (serverSocket != null){
                serverSocket.close();
            }
        }


    }
}
