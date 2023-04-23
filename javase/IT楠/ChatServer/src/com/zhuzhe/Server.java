package com.zhuzhe;

import com.zhuzhe.util.MassageUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建服务器
        ServerSocket serverSocket=new ServerSocket();
        //绑定端口
        serverSocket.bind(new InetSocketAddress(8888));
        System.out.println("服务器在8888端口启动");
        //开始监听
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        Optional<Massage> massage = MassageUtil.readMassage(inputStream);
        massage.ifPresent(System.out::println);


    }

}
