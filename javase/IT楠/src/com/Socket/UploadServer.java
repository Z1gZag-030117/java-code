package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
//        String filePath="src\\p.png";
//        ServerSocket serverSocket=new ServerSocket(8888);
//        Socket socket = serverSocket.accept();
//        BufferedInputStream bis = new BufferedInputStream(
//                socket.getInputStream());
//        byte[] bytes = StreamUtil.streamToByteArray(bis);
//        BufferedOutputStream bos = new BufferedOutputStream(
//                new FileOutputStream(filePath));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bw.write("收听到图片");
//        bw.flush();
//        socket.shutdownOutput();
//        bos.write(bytes);
//        bos.close();
//        bis.close();
//        socket.close();
//        serverSocket.close();
        String destFilePath="src\\picture.png";
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes=StreamUtil.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();
        socket.shutdownOutput();
        writer.close();

        bis.close();
        socket.close();
        serverSocket.close();
    }
}
