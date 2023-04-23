package com.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Clint {

    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("clint");
        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello server".getBytes());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
//        int len;
//        byte[] buf=new byte[1024];
//        while((len= inputStream.read(buf))!=-1){
//            System.out.println(new String(buf,0,len));
//        }
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //outputStream.close();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
