package com.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceivePractice {

    public static void main(String[] args) throws IOException {
        //创建接受端的socket对象，
        DatagramSocket datagramSocket=new DatagramSocket(12345);

        while (true){
            //创建一个数据包，用于接受数据
            byte[] bytes=new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
            //掉哦那个DatagramSocket对象的方法接受数据
            datagramSocket.receive(datagramPacket);

            //解析数据包，把数据在控制台上显示
            System.out.println("接受的数据是："+new String(datagramPacket.getData(),0, datagramPacket.getLength()));
        }



    }

}
