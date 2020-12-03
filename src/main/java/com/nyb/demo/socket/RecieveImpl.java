package com.nyb.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author:nyb
 * @DESC: 接受类
 * @Date: Created in 14:51 2020/10/15
 * @Modified By:
 */
public class RecieveImpl implements Runnable {

    private Socket socket;

    public RecieveImpl(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println("收到消息："+new String(bytes,0,read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
