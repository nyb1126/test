package com.nyb.demo.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:nyb
 * @DESC: 客户端类
 * @Date: Created in 14:55 2020/10/15
 * @Modified By:
 */
public class ChatClientThread {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();
        SendImpl send = new SendImpl(socket);
        new Thread(send).start();
        RecieveImpl recieve = new RecieveImpl(socket);
        new Thread(recieve).start();
    }

}
