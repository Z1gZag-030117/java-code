package com.Socket;

import jdk.nashorn.internal.objects.DataPropertyDescriptor;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SendTest {

    public static void main(String[] args) throws IOException {
        //创建socket对象
        DatagramSocket datagramSocket=new DatagramSocket();

        //创建数据，并把数据打包
        // DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
        byte[] bytes="hello word".getBytes();
//        int len=bytes.length;
//        InetAddress address=InetAddress.getByName("10.30.4.186");
//        int port=10086;//端口号
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,InetAddress.getByName("10.30.4.186"),10086);

        //调用DatagramSocket对象的方法发送数据
        datagramSocket.send(datagramPacket);
        //关闭发送端
        datagramSocket.close();


    }

}
