package com.zhuzhe;

import com.zhuzhe.constant.MassageType;
import com.zhuzhe.util.MassageUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        //创建
        Socket socket=new Socket();
        //链接
        socket.connect(new InetSocketAddress(8888));
        //发送消息
        OutputStream outputStream=socket.getOutputStream();
        MassageUtil.writeMassage(outputStream,new Massage(MassageType.TO_SERVER,"hello"));
        outputStream.close();

    }
}
