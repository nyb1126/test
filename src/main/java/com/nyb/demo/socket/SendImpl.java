package com.nyb.demo.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author:nyb
 * @DESC: 发送类
 * @Date: Created in 14:47 2020/10/15
 * @Modified By:
 */
public class SendImpl implements Runnable {
    private Socket socket;

    public SendImpl(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                OutputStream outputStream = socket.getOutputStream();
                String line = scanner.nextLine();
                outputStream.write(line.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
