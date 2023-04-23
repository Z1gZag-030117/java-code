package com.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DCPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);
        byte[] buf=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buf,buf.length);
        System.out.println("等待接受数据");
        socket.receive(packet);
        int length = packet.getLength();
        String s=new String(packet.getData(),0,length);
        System.out.println(s);
        socket.close();
    }
}
