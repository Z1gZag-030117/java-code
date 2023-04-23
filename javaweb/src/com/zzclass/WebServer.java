package com.zzclass;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebServer {



    public static void main(String[] args) throws IOException {
        //启动一个服务器
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        //获得输入流
        InputStream inputStream = accept.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        while((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes));
        }
        inputStream.close();
        accept.close();
    }

    @Test
    public void test(){
        String context="my name is zigzag come from csgo";
        String regexp=".*zigzag.*";
        Pattern pattern = Pattern.compile(regexp); //编译一个正则表达式，获得编译后的结果、
        Matcher matcher = pattern.matcher(context);
        System.out.println(matcher.matches());
    }

}
