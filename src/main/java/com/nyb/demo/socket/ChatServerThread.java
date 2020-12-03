package com.nyb.demo.socket;

import java.net.Socket;

/**
 * @Author:nyb
 * @DESC: 服务端类
 * @Date: Created in 14:45 2020/10/15
 * @Modified By:
 */
public class ChatServerThread {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8081);
        SendImpl send = new SendImpl(socket);
        new Thread(send).start();
        RecieveImpl recieve = new RecieveImpl(socket);
        new Thread(recieve).start();
    }
}
