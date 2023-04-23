package com.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Clint1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("socket.getClass() = " + socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] buff=new byte[1024];
        int readLen;
        while((readLen=inputStream.read(buff))!=-1){
            System.out.println(new String(buff,0,readLen));
        }
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
