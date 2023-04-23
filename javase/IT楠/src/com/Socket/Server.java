package com.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("server 正在监听");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
//        int len;
//        byte[] buf=new byte[1024];
//        while((len=inputStream.read(buf))!=-1){
//            System.out.println(new String(buf,0,len));
//        }
        byte[] bytes=new byte[1024];
        int len;
        while((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("hello clint".getBytes(StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello clint 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
       /*
         socket.shutdownOutput();
        inputStream.close();
        */
        outputStream.close();
        socket.close();
        serverSocket.close();
    }

}
