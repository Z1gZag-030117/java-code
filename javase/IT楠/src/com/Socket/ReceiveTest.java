package com.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveTest {
    public static void main(String[] args) throws IOException {
        //创建接收端的socket对象
        DatagramSocket datagramSocket=new DatagramSocket(10086);

        //创建一个数据包，用于接收数据
        byte[] bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);

        //调用方DatagramSocket对象的方法来接受数据
        datagramSocket.receive(datagramPacket);

        //解析数据包，并把主句在控制台显示
        byte[] data = datagramPacket.getData();
        int len=data.length;
        String dataString=new String(data,0,len);
        System.out.println("数据是:"+dataString);

        //关闭
        datagramSocket.close();
    }

}
