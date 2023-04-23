package com.Socket;

import java.io.IOException;
import java.net.*;

public class DCPClint {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9998);
        byte[] data = "hello".getBytes();
        DatagramPacket packet=new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9999);
        socket.send(packet);
        socket.close();
    }
}
