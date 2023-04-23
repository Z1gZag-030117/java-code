package com.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("socket.getClass() = " + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] buff=new byte[1024];
        int readLen;
        while(-1 != (readLen = inputStream.read(buff))){
            System.out.println(new String(buff,0,readLen));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello clint".getBytes());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
